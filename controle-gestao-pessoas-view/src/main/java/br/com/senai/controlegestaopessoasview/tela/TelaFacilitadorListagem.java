package br.com.senai.controlegestaopessoasview.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.controlegestaopessoasview.client.FacilitadorClient;
import br.com.senai.controlegestaopessoasview.dto.Facilitador;
import br.com.senai.controlegestaopessoasview.dto.Usuario;
import br.com.senai.controlegestaopessoasview.tela.table.FacilitadorTableModel;

@Component
public class TelaFacilitadorListagem extends JFrame {

	@Autowired
	private FacilitadorClient client;

	@Autowired
	private TelaFacilitadorInsercaoEdicao telaFacilitadorInsercaoEdicao;

	@Autowired
	private FacilitadorClient clienteFacilitador;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable table;

	private void atualizar(JTable table) {
		List<Facilitador> facilitadores = client.listarPor(txtFiltro.getText());
		FacilitadorTableModel model = new FacilitadorTableModel(facilitadores);
		table.setModel(model);
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(0).setPreferredWidth(50);
		cm.getColumn(1).setPreferredWidth(352);
		table.updateUI();
	}

	private Facilitador getFacilitadorSelecionadaNa(JTable table) {
		int linhaSelecionada = table.getSelectedRow();
		if (linhaSelecionada < 0) {
			throw new IllegalArgumentException("Nenhuma linha foi selecionada");
		}
		FacilitadorTableModel model = (FacilitadorTableModel) table.getModel();
		Facilitador itemSelecionado = model.getPor(linhaSelecionada);
		return itemSelecionado;
	}

	private void removerRegistroDa(JTable table) {
		try {

			Facilitador facilitadorSelecionado = getFacilitadorSelecionadaNa(table);

			int opcaoSelecionada = JOptionPane.showConfirmDialog(contentPane, "Deseja remover?", "Remoção",
					JOptionPane.YES_NO_OPTION);

			if (opcaoSelecionada == JOptionPane.YES_OPTION) {
				this.client.excluir(facilitadorSelecionado);
				((FacilitadorTableModel) table.getModel()).remover(facilitadorSelecionado);
				table.updateUI();
				JOptionPane.showMessageDialog(contentPane, "Facilitador removido com sucesso");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	}

	public TelaFacilitadorListagem() {
		setTitle("Facilitador (LISTAGEM) - SA System 1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaFacilitadorInsercaoEdicao.setVisible(true);
				setVisible(false);
			}

		});

		JTable table = new JTable();
		table.setFillsViewportHeight(true);

		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar(table);
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerRegistroDa(table);
			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				
			}
		});

		JLabel lblFiltro = new JLabel("Filtro");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(table,
								GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addGap(366)
										.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addContainerGap().addComponent(btnListar,
										GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(23)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblFiltro, GroupLayout.PREFERRED_SIZE, 51,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
												.addComponent(btnAdicionar))
										.addComponent(txtFiltro, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))))
				.addGap(28)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(btnAdicionar))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(28).addComponent(lblFiltro,
								GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtFiltro, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnListar).addGap(18)
				.addComponent(table, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnRemover)
						.addComponent(btnEditar))
				.addContainerGap(30, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	public Facilitador enviarFacilitador(Usuario usuarioBusca) {
		Facilitador facilitadorEncontrado = new Facilitador();

		facilitadorEncontrado = clienteFacilitador.buscarFacilitador(usuarioBusca);

		return facilitadorEncontrado;

	}

}
