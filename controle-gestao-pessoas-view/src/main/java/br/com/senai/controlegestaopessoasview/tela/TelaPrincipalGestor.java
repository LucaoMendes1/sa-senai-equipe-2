 package br.com.senai.controlegestaopessoasview.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.senai.controlegestaopessoasview.dto.Usuario;

@Component
public class TelaPrincipalGestor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserStatus;
	private JTextField txtNomeUsuario;


	
	@Lazy
	@Autowired
	private TelaDeLogin telaLogin;
	
	@Lazy
	@Autowired
	private TelaFacilitadorListagem tpFacilitadorListagem;
	
	@Lazy
	@Autowired
	private TelaTreinamentoListagem telaTreinamentoListagem;
	
	public TelaPrincipalGestor() {
		setTitle("Principal (Acesso GESTOR)- SA System 1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnFacilitadores = new JButton("Facilitadores");
		btnFacilitadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpFacilitadorListagem.setVisible(true);
			}
		});
		
		JButton btnTreinamentos = new JButton("Treinamentos");
		btnTreinamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaTreinamentoListagem.setVisible(true);
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
				
				telaLogin.setVisible(true);
			}
		});
		
		txtUserStatus = new JTextField();
		txtUserStatus.setEditable(false);
		txtUserStatus.setText("Usuário Logado");
		txtUserStatus.setColumns(10);
		
		txtNomeUsuario =  new JTextField();
		txtNomeUsuario.setEditable(false);
		txtNomeUsuario.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(151, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTreinamentos, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFacilitadores, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGap(149))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(txtUserStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNomeUsuario, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(btnFacilitadores, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnTreinamentos, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNomeUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUserStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void carregarTela(Usuario usuario) {
		txtNomeUsuario.setText(usuario.getNomeCompleto());
		this.setVisible(true);
	}
}
