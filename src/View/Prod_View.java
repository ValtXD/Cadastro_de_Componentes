package View;

import Controller.ProdutoController;
import Produto.Componente;
import Produto.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prod_View {
    private JFrame frame;
    private JTable tableProdutos;
    private DefaultTableModel tableModel;
    private ProdutoController controller;

    public Prod_View() {
        controller = new ProdutoController();

        // Configuração da janela principal
        frame = new JFrame("Cadastro de Componentes");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Configuração da tabela
        String[] colunas = {"Nome", "Preço", "Código Legado", "Tipo Material", "Importado"};
        tableModel = new DefaultTableModel(colunas, 0);
        tableProdutos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableProdutos);

        // Painel para formulário de cadastro
        JPanel panelForm = new JPanel(new GridLayout(0, 2));
        JTextField nomeField = new JTextField(10);
        JTextField precoField = new JTextField(5);
        JTextField codigoLegadoField = new JTextField(10);
        JTextField tipoMaterialField = new JTextField(10);
        JCheckBox importadoCheckBox = new JCheckBox("Importado");

        panelForm.add(new JLabel("Nome:"));
        panelForm.add(nomeField);
        panelForm.add(new JLabel("Preço:"));
        panelForm.add(precoField);
        panelForm.add(new JLabel("Código Legado:"));
        panelForm.add(codigoLegadoField);
        panelForm.add(new JLabel("Tipo Material:"));
        panelForm.add(tipoMaterialField);
        panelForm.add(importadoCheckBox);

        // Botão para adicionar produto
        JButton btnAdicionar = new JButton("Adicionar Componente");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    float preco = Float.parseFloat(precoField.getText());
                    String codigoLegado = codigoLegadoField.getText();
                    String tipoMaterial = tipoMaterialField.getText();
                    boolean importado = importadoCheckBox.isSelected();

                    // Adiciona o componente ao controller
                    Produto componente = new Componente(nome, preco, codigoLegado, tipoMaterial, importado);
                    controller.adicionarProduto(componente);

                    // Atualiza a tabela
                    atualizarTabela();

                    // Limpar campos
                    nomeField.setText("");
                    precoField.setText("");
                    codigoLegadoField.setText("");
                    tipoMaterialField.setText("");
                    importadoCheckBox.setSelected(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao formatar o preço!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adiciona componentes na janela
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelForm, BorderLayout.NORTH);
        frame.add(btnAdicionar, BorderLayout.SOUTH);

        // Exibe a janela
        frame.setVisible(true);
    }

    private void atualizarTabela() {
        // Limpa a tabela antes de listar os produtos
        tableModel.setRowCount(0);

        // Adiciona os produtos à tabela
        for (Produto produto : controller.listarProdutos()) {
            if (produto instanceof Componente) {
                Componente componente = (Componente) produto;
                Object[] linha = {
                        componente.getNome(),
                        componente.getPreco(),
                        componente.getCodigoLegado(),
                        componente.getTipoMaterial(),
                        componente.isImportado() ? "Sim" : "Não"
                };
                tableModel.addRow(linha);
            }
        }
    }

    public static void main(String[] args) {
        new Prod_View();
    }
}
