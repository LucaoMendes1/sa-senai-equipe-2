package br.com.senai.controlegestaopessoasview.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import br.com.senai.controlegestaopessoasview.client.FacilitadorClient;
import br.com.senai.controlegestaopessoasview.client.TreinamentoClient;
import br.com.senai.controlegestaopessoasview.dto.Facilitador;
import br.com.senai.controlegestaopessoasview.dto.Treinamento;

@Component
public class TelaInsercaoEdicaoTreinamento extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFTitulo;
	private JFormattedTextField tFDataDeRealizacao;
	private JTextArea tADescricaoLonga;
	private MaskFormatter maskData;
	
	
	@Autowired
	private TreinamentoClient treinamentoClient;
	
	@Lazy
	@Autowired
	private TelaTreinamentoListagem listagem;
	
	private Treinamento treinamentoSalvo;
	
	@Autowired
	private FacilitadorClient facilitadorClient;
	
	private JComboBox<Facilitador> comboBoxFacilitador;



	public void colocarEmEdicao(
			Treinamento treinamentoSalvo) {
		this.tFTitulo.setText(treinamentoSalvo.getTitulo());
		this.tFDataDeRealizacao.setText(treinamentoSalvo.getDataLocalizacao().toString());
		this.tADescricaoLonga.setText(treinamentoSalvo.getDescricaoLonga());
		this.treinamentoSalvo = treinamentoSalvo;
		setVisible(true);
	}
	
	public TelaInsercaoEdicaoTreinamento() {
		setTitle("Treinamento (INSERÇÃO/EDIÇÃO) - SA System 1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				listagem.abrirTela();
			}
		});
		
		JLabel lblTitulo = new JLabel("Título");
		
		try {
			maskData = new MaskFormatter("##/##/####");

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		tFTitulo = new JTextField();
		tFTitulo.setColumns(10);
		
		tADescricaoLonga = new JTextArea();
		tADescricaoLonga.setColumns(10);
		
		JLabel lblDataDeRealizacao = new JLabel("Data de Realização");
		
		tFDataDeRealizacao = new JFormattedTextField(maskData);
		tFDataDeRealizacao.setColumns(10);
		
		JLabel lblFacilitador = new JLabel("Facilitador");
		
		comboBoxFacilitador = new JComboBox<Facilitador>();
		
		JLabel lblNDescricaoLonga = new JLabel("Descrição Longa");
		
		JTextArea tADescricaoLonga = new JTextArea();
		
		JButton btnNSalvar = new JButton("Salvar");
		btnNSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Treinamento novoTreinamento = new Treinamento();
					novoTreinamento.setDescricaoLonga(tADescricaoLonga.getText());
					novoTreinamento.setFacilitador((Facilitador)comboBoxFacilitador.getSelectedItem());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					String date = tFDataDeRealizacao.getText();
					LocalDate localDate = LocalDate.parse(date, formatter);
					novoTreinamento.setDataLocalizacao(localDate);
					novoTreinamento.setTitulo(tFTitulo.getText());
					treinamentoClient.inserir(novoTreinamento);
					JOptionPane.showMessageDialog(contentPane, "Treinamento salvo com sucesso!!!");
				} catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(contentPane, "Formato inválido para a data");
				}catch (HttpClientErrorException hcee) {
					JSONObject erroClient = new JSONObject(hcee.getResponseBodyAsString());
					JSONArray erros = erroClient.getJSONArray("erros");
					for( Object erro : erros) {
						JSONObject erroJson = (JSONObject) erro;
						JOptionPane.showMessageDialog(contentPane, erroJson.get("mensagem"));
					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(tFTitulo, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblTitulo)
											.addGap(274)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(tFDataDeRealizacao, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDataDeRealizacao))
									.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblFacilitador)
									.addContainerGap(385, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBoxFacilitador, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNDescricaoLonga)
									.addContainerGap(389, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tADescricaoLonga, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(btnNSalvar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnConsultar)
							.addGap(22))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(btnConsultar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitulo)
						.addComponent(lblDataDeRealizacao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tFTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tFDataDeRealizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFacilitador)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxFacilitador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNDescricaoLonga)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tADescricaoLonga, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNSalvar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	@PostConstruct
	public void inicializar() {
		List<Facilitador> facilitadores = new ArrayList<Facilitador>();
		facilitadores = facilitadorClient.buscarTodos();
		for (Facilitador facilitador : facilitadores) {
			comboBoxFacilitador.addItem(facilitador);
		}
	}
}
