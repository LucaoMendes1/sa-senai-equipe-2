package br.com.senai.controlegestaopessoasview.tela.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.controlegestaopessoasview.dto.Facilitador;
import br.com.senai.controlegestaopessoasview.dto.Treinamento;

public class TreinamentoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 2;
	
	private List<Treinamento> treinamentos;
	
	public TreinamentoTableModel(
			List<Treinamento> treinamentos) {
		this.treinamentos = treinamentos;
	}

	@Override
	public int getRowCount() {
		return treinamentos.size();
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
			return "Descrição";
		}
		
		throw new IllegalArgumentException("Indice inválido");
	}
	
	public Treinamento getPor(int rowIndex) {
		return treinamentos.get(rowIndex);
	}
	
	
	public void remover(Treinamento treinamentos) {
		this.treinamentos.remove(treinamentos);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return this.treinamentos.get(rowIndex).getId();
		}else if (columnIndex == 1) {			
			return this.treinamentos.get(rowIndex).getDescricaoLonga();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	

}
