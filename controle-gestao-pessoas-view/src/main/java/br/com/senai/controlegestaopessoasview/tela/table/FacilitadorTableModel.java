package br.com.senai.controlegestaopessoasview.tela.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.controlegestaopessoasview.dto.Facilitador;


public class FacilitadorTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 2;
	
	private List<Facilitador> facilitadores;
	
	public FacilitadorTableModel(
			List<Facilitador> facilitadores) {
		this.facilitadores = facilitadores;
	}

	@Override
	public int getRowCount() {
		return facilitadores.size();
	}

	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		
		if (column == 0) {
			return "ID";
		}else if (column == 1) {		
			return "Nome Completo";
		}
		
		throw new IllegalArgumentException("Indice inválido");
	}
	
	public Facilitador getPor(int rowIndex) {
		return facilitadores.get(rowIndex);
	}
	
	public void removePor(int rowIndex) {
		this.facilitadores.remove(rowIndex);
	}
	
	public void remover(Facilitador facilitadores) {
		this.facilitadores.remove(facilitadores);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return this.facilitadores.get(rowIndex).getId();
		}else if (columnIndex == 1) {			
			return this.facilitadores.get(rowIndex).getUsuario().getNomeCompleto();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
}
