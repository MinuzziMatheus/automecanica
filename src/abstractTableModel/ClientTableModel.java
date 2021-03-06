/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractTableModel;

import dao.ClientDAO;
import entidade.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author minuzzi
 */
public class ClientTableModel extends AbstractTableModel {
    private List<Client> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Nome", "CPF", "E-mail"};

    public ClientTableModel() {
        updateData();
    }

    @Override
    public int getRowCount() {
        return dados.size();//tamanho da lista, logo o número de rows (linhas) de dados
    }

    @Override
    public String getColumnName(int column) {//retorna o nome da Coluna, o java usa para noemar as colunas também!
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;//mesma coisa que as linhas, a quantidade de colunas
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getName();
            case 2:
                return dados.get(linha).getCpf();
            case 3:
                return dados.get(linha).getEmail();
        }

        return null;
    }

    public void addRow(Client p) {//adiciona uma linha
        this.dados.add(p);
        this.fireTableDataChanged();//atualiza a tabela quando houver alteração
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);// parâmetros ~> (início, fim)
    }
    
    public void updateData(){
        this.dados = new ClientDAO().getAll();
    }


    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setId(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setName(((String) valor));
                break;
            case 2:
                dados.get(linha).setCpf(((String) valor));
                break;
            case 3:
                dados.get(linha).setEmail(((String) valor));//valor que vem do Text Field é sempre uma String
                break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
}
