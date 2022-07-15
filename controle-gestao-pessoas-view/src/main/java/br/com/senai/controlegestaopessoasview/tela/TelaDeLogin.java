package br.com.senai.controlegestaopessoasview.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.controlegestaopessoasview.client.UsuarioClient;
import br.com.senai.controlegestaopessoasview.dto.Tipo;
import br.com.senai.controlegestaopessoasview.dto.Usuario;

@Component
public class TelaDeLogin extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLogin;
	
	@Autowired
	private UsuarioClient client;
	
	@Autowired
	private TelaPrincipalGestor tpGestor;
	
	@Autowired
	private TelaPrincipalFacilitador tpFacilitador;
	
	private JPasswordField psSenha;

	/**
	 * Create the frame.
	 */
	public TelaDeLogin() {
		setTitle("Login - SA System 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(33, 63, 220, 33);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setLogin(tfLogin.getText());
				usuario.setSenha(psSenha.getText());
				navegar(usuario);
			}
			private void navegar(Usuario usuario) {
				Usuario usuarioLogado = client.logar(usuario);
				if (usuarioLogado != null) {
					if (usuarioLogado.getTipo() == Tipo.GESTOR) {
						tpGestor.setVisible(true);						
					}else if (usuarioLogado.getTipo() == Tipo.FACILITADOR) {
						tpFacilitador.setVisible(true);						
					}
					contentPane.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(contentPane, "Usuário não encontrado!");
				}
			}
		});

		btnLogar.setBounds(81, 193, 110, 41);
		contentPane.add(btnLogar);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setBounds(33, 108, 55, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(33, 35, 55, 16);
		contentPane.add(lblLogin);
		
		psSenha = new JPasswordField();
		psSenha.setBounds(33, 141, 220, 40);
		contentPane.add(psSenha);
	}
}
