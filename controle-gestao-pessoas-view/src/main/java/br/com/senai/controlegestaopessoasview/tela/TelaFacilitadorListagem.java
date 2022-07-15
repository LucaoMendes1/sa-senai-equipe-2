package br.com.senai.controlegestaopessoasview.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

@Component
public class TelaFacilitadorListagem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable table;

	/**
	 * Create the frame.
	 */
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
			}
		});
		
		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		
		table = new JTable();
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		
		JButton btnEditar = new JButton("Editar");
		
		JLabel lblFiltro = new JLabel("Filtro");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(366)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblFiltro, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
									.addComponent(btnAdicionar))
								.addComponent(txtFiltro, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))))
					.addGap(28))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAdicionar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(lblFiltro, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFiltro, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnListar)
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemover)
						.addComponent(btnEditar))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
