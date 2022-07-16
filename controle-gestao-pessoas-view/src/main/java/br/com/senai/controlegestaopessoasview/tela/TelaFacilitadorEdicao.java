package br.com.senai.controlegestaopessoasview.tela;

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

import br.com.senai.controlegestaopessoasview.dto.Facilitador;
import br.com.senai.controlegestaopessoasview.dto.Usuario;

@Component
public class TelaFacilitadorEdicao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtNomeCompleto;
	private JTextField edtCpf;
	private JTextField edtRg;
	private JTextField edtLogin;
	private JTextField edtSenha;
	private JTextArea edtFormacao;
	

	/**
	 * Create the frame.
	 */
	public TelaFacilitadorEdicao() {
		setTitle("Facilitador (EDIÇÃO) - SA System 1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		edtNomeCompleto = new JTextField();
		edtNomeCompleto.setColumns(10);
		
		edtCpf = new JTextField();
		edtCpf.setColumns(10);
		
		edtRg = new JTextField();
		edtRg.setColumns(10);
		
		edtFormacao = new JTextArea();
		edtFormacao.setColumns(10);
		
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		
		JLabel lblCpf = new JLabel("CPF");
		
		JLabel lblRg = new JLabel("RG");
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblSenha = new JLabel("Senha");
		
		JLabel lblNewLabel = new JLabel("Formação");
		
		JButton btnSalvar = new JButton("Salvar");
		
		edtLogin = new JTextField();
		edtLogin.setColumns(10);
		
		edtSenha = new JTextField();
		edtSenha.setColumns(10);
		
		JTextArea edtFormacao = new JTextArea();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(edtNomeCompleto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(edtCpf, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCpf))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblRg)
											.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE))
										.addComponent(edtRg, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))))
							.addComponent(lblNomeCompleto)
							.addComponent(lblNewLabel)
							.addComponent(btnSalvar, Alignment.TRAILING)
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGap(180)
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGap(166)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(edtLogin, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(edtSenha, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
						.addComponent(edtFormacao, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNomeCompleto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtNomeCompleto, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(lblRg))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(edtCpf, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(edtRg, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtFormacao, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtLogin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(edtSenha, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnSalvar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void carregarFacilitador(Facilitador facilitador) {
		edtNomeCompleto.setText(facilitador.getNomeCompleto());
		this.edtNomeCompleto.setVisible(true);
		
		edtCpf.setText(facilitador.getCpf());
		this.edtCpf.setVisible(true);
		
		edtRg.setText(facilitador.getRg());
		this.edtRg.setVisible(true);
		
		edtLogin.setText(facilitador.getLogin());
		this.edtLogin.setVisible(true);

		edtFormacao.setText(facilitador.getFormacao());
		this.edtFormacao.setVisible(true);
		
	}
	
	
	
	
}
