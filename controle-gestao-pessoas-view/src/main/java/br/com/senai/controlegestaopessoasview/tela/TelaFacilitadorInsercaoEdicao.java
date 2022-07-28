package br.com.senai.controlegestaopessoasview.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.senai.controlegestaopessoasview.client.FacilitadorClient;
import br.com.senai.controlegestaopessoasview.dto.Facilitador;
import br.com.senai.controlegestaopessoasview.dto.Usuario;


@Component
public class TelaFacilitadorInsercaoEdicao extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtNomeCompleto;
	private JTextField edtCpf;
	private JTextField edtRg;
	private JTextField edtLogin;
	
	@Autowired
	private FacilitadorClient client;
	
	private Facilitador facilitadorSalvo;
	
	@Lazy
	@Autowired
	private TelaFacilitadorListagem listagem;
	
	private JPasswordField edtSenha;
	
	
	private JTextField edtFormacao;
	
	public void colocarEmEdicao(
			Facilitador facilitadorSalvo) {
		this.edtNomeCompleto.setText(facilitadorSalvo.getUsuario().getNomeCompleto());
		this.edtCpf.setText(facilitadorSalvo.getCpf());
		this.edtRg.setText(facilitadorSalvo.getRg());
		this.edtFormacao.setText(facilitadorSalvo.getFormacao());
		this.edtLogin.setText(facilitadorSalvo.getUsuario().getLogin());
		this.edtSenha.setText(facilitadorSalvo.getUsuario().getSenha());
		this.facilitadorSalvo = facilitadorSalvo;
		setVisible(true);
	}
	

	public TelaFacilitadorInsercaoEdicao() {
		setTitle("Facilitador (INSERÇÃO/EDIÇÃO) - SA System 1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		edtNomeCompleto = new JTextField();
		edtNomeCompleto.setColumns(10);
		
		edtCpf = new JTextField();
		edtCpf.setColumns(10);
		
		edtRg = new JTextField();
		edtRg.setColumns(10);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		
		JLabel lblCpf = new JLabel("CPF");
		
		JLabel lblRg = new JLabel("RG");
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblSenha = new JLabel("Senha");
		
		JLabel lblNewLabel = new JLabel("Formação");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facilitador novoFacilitador = new Facilitador();
				Usuario novoUsuario = new Usuario();
				novoFacilitador.setUsuario(novoUsuario);
				novoFacilitador.setCpf(edtCpf.getText());
				novoFacilitador.setFormacao(edtFormacao.getText());
				novoFacilitador.getUsuario().setLogin(edtLogin.getText());
				novoFacilitador.getUsuario().setSenha(edtSenha.getText());
				novoFacilitador.getUsuario().setNomeCompleto(edtNomeCompleto.getText());
				novoFacilitador.setRg(edtRg.getText());
				if (facilitadorSalvo != null) {
					novoFacilitador.setId(facilitadorSalvo.getId());
					novoFacilitador.getUsuario().setId(facilitadorSalvo.getUsuario().getId());
					client.alterar(novoFacilitador);
					JOptionPane.showMessageDialog(contentPane, "A alteração foi concluída com sucesso!");
				}else {
					client.inserir(novoFacilitador);
					JOptionPane.showMessageDialog(contentPane, "Novo facilitador inserido com sucesso!");
				}
			}
		});
		
		edtLogin = new JTextField();
		edtLogin.setColumns(10);
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				listagem.setVisible(true);
			}
		});
		
		edtSenha = new JPasswordField();
		
		edtFormacao = new JTextField();
		edtFormacao.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSalvar)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(edtLogin, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(edtSenha, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
									.addGap(15))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNomeCompleto)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
									.addComponent(edtNomeCompleto, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(edtCpf, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblCpf))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblRg)
												.addPreferredGap(ComponentPlacement.RELATED, 242, Short.MAX_VALUE))
											.addComponent(edtRg, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))))))
						.addComponent(lblNewLabel)
						.addComponent(edtFormacao, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnConsultar)
						.addComponent(lblNomeCompleto))
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
					.addGap(22)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtFormacao, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtSenha, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(edtLogin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnSalvar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void montarTela(Facilitador facilitador) {
		
		edtCpf.setText(facilitador.getCpf());
		edtNomeCompleto.setText(facilitador.getUsuario().getNomeCompleto());
		edtRg.setText(facilitador.getRg());
		edtLogin.setText(facilitador.getUsuario().getSenha());
		edtSenha.setText(facilitador.getUsuario().getSenha());
		edtFormacao.setText(facilitador.getFormacao());
	}
	
	public void limparFormulario() {
		this.edtNomeCompleto.setText("");
		this.edtCpf.setText("");
		this.edtRg.setText("");
		this.edtFormacao.setText("");
		this.edtLogin.setText("");
		this.edtSenha.setText("");
		this.facilitadorSalvo = null;
	}
}
