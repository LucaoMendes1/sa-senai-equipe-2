package br.com.senai.controlegestaopessoasview.tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@Component
public class TelaDeLogin extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLogin;
	private JTextField tfSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin frame = new TelaDeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(33, 134, 220, 33);
		contentPane.add(tfSenha);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogar.setBounds(89, 179, 110, 41);
		contentPane.add(btnLogar);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setBounds(33, 108, 55, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(33, 35, 55, 16);
		contentPane.add(lblLogin);
	}

}
