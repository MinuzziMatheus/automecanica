/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractTableModel;

import dao.ItemDAO;
import entidade.Item;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author minuzzi
 */
public class ItemTableModel extends AbstractTableModel {
    
    private List<Item> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Nome", "Descrição", "Valor (Un)", "Situação", "Quantidade"};

    public ItemTableModel() {
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
                return dados.get(linha).getDescription();
            case 3:
                return dados.get(linha).getValue();
            case 4:
                return dados.get(linha).getSituation();
            case 5:
                return dados.get(linha).getAmount();
        }

        return null;
    }
    
    
    public void updateData(){
        this.dados = new ItemDAO().getAll();
    }

    public void addRow(Item p) {//adiciona uma linha
        this.dados.add(p);
        this.fireTableDataChanged();//atualiza a tabela quando houver alteração
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);// parâmetros ~> (início, fim)
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
                dados.get(linha).setDescription(((String) valor));//valor que vem do Text Field é sempre uma String
                break;
            case 3:
                dados.get(linha).setValue(Integer.parseInt((String) valor));
                break;
            case 4:
                dados.get(linha).setSituation(((String) valor).charAt(0));//valor que vem do Text Field é sempre uma String
                break;
            case 5:
                dados.get(linha).setAmount(Integer.parseInt((String) valor));
                break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
}
