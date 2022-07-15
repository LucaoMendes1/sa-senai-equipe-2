package br.com.senai.controlegestaopessoasview.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class TelaFacilitadorInsercaoEdicao extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeCompleto;
	private JTextField textCpf;
	private JTextField textRg;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the frame.
	 */
	public TelaFacilitadorInsercaoEdicao() {
		setTitle("Facilitador (INSERÇÃO/EDIÇÃO) - SA System 1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textNomeCompleto = new JTextField();
		textNomeCompleto.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		
		textRg = new JTextField();
		textRg.setColumns(10);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		
		JLabel lblCpf = new JLabel("CPF");
		
		JLabel lblRg = new JLabel("RG");
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblSenha = new JLabel("Senha");
		
		JLabel lblNewLabel = new JLabel("Formação");
		
		JButton btnSalvar = new JButton("Salvar");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textNomeCompleto, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textCpf, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCpf))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblRg)
											.addPreferredGap(ComponentPlacement.RELATED, 242, Short.MAX_VALUE))
										.addComponent(textRg, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNomeCompleto)
								.addGap(366)
								.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnSalvar)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGap(180)
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGap(166)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(496, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNomeCompleto)
						.addComponent(btnConsultar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textNomeCompleto, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(lblRg))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textCpf, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRg, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnSalvar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
