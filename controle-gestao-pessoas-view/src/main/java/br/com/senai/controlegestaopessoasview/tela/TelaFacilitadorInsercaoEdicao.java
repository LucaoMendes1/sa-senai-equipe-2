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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.senai.controlegestaopessoasview.client.FacilitadorClient;
import br.com.senai.controlegestaopessoasview.dto.Facilitador;

@Component
public class TelaFacilitadorInsercaoEdicao extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeCompleto;
	private JTextField textCpf;
	private JTextField textRg;
	private JTextField tfLogin;
	
	@Autowired
	private FacilitadorClient client;
	
	@Lazy
	@Autowired
	private TelaFacilitadorListagem listagem;
	
	private JPasswordField psSenha;

	/**
	 * Create the frame.
	 */
	public TelaFacilitadorInsercaoEdicao() {
		setTitle("Facilitador (INSERÇÃO/EDIÇÃO) - SA System 1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 561);
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
		
		JTextArea textArea = new JTextArea();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facilitador novoFacilitador = new Facilitador();
				novoFacilitador.setCpf(textCpf.getText());
				novoFacilitador.setFormacao(textArea.getText());
				novoFacilitador.setLogin(tfLogin.getText());
				novoFacilitador.setSenha(psSenha.getText());
				novoFacilitador.setNomeCompleto(textNomeCompleto.getText());
				novoFacilitador.setRg(textRg.getText());
				client.inserir(novoFacilitador);
			}
		});
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				listagem.setVisible(true);
			}
		});
		
		psSenha = new JPasswordField();
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
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addGap(180))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(tfLogin, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
										.addGap(33)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(psSenha, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addGap(27)))
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfLogin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(psSenha, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnSalvar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
