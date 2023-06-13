package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import usuario.*;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaUsuario {

	private JFrame frame;
	private JTextField textFieldCpf;
	private JTextField textFieldSenha;
	private JTextField textNome;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldCidade;
	private JTextField textFieldNumero;
	private JTextField textFieldRua;
	private JTextField textFieldCEP;
	private JButton btnEnviar;
	private JButton btnRegistrar;
	private JButton btnEnviarRegis;
	private JButton btnVoltar;
	private JComboBox comboBoxEstados;
	
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblCEP;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario window = new TelaUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(10, 15, 46, 14);
		frame.getContentPane().add(lblCpf);
		this.lblCpf = lblCpf;
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblSenha);
		this.lblSenha = lblSenha;
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(66, 43, 150, 20);
		frame.getContentPane().add(textFieldSenha);
		textFieldSenha.setColumns(10);
		this.textFieldSenha = textFieldSenha;
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(10, 90, 80, 14);
		frame.getContentPane().add(lblNome);
		lblNome.setVisible(false);
		this.lblNome = lblNome;

		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(220, 115, 46, 14);
		frame.getContentPane().add(lblRua);
		lblRua.setVisible(false);
		this.lblRua = lblRua;

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(220, 140, 46, 14);
		frame.getContentPane().add(lblEstado);
		lblEstado.setVisible(false);
		this.lblEstado = lblEstado;

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 140, 46, 14);
		frame.getContentPane().add(lblCidade);
		lblCidade.setVisible(false);
		this.lblCidade = lblCidade;
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(220, 165, 46, 14);
		frame.getContentPane().add(lblCEP);
		lblCEP.setVisible(false);
		this.lblCEP = lblCEP;
		
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 165, 46, 14);
		frame.getContentPane().add(lblNumero);
		lblNumero.setVisible(false);
		this.lblNumero = lblNumero;		
		
		textFieldNome = new JTextField();
		textFieldNome.setEnabled(false);
		textFieldNome.setBounds(100, 87, 176, 20);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setVisible(false);		
		this.textFieldNome = textFieldNome;		
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEnabled(false);
		textFieldEmail.setBounds(100, 112, 99, 20);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setVisible(false);
		this.textFieldEmail = textFieldEmail;		

		textFieldCidade = new JTextField();
		textFieldCidade.setEnabled(false);
		textFieldCidade.setBounds(100, 137, 99, 20);
		frame.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		textFieldCidade.setVisible(false);
		this.textFieldCidade = textFieldCidade;
		
		textFieldNumero = new JTextField();
		textFieldNumero.setEnabled(false);
		textFieldNumero.setBounds(100, 162, 99, 20);
		frame.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		textFieldNumero.setVisible(false);
		this.textFieldNumero = textFieldNumero;
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 115, 46, 14);
		lblEmail.setVisible(false);
		frame.getContentPane().add(lblEmail);
		this.lblEmail = lblEmail;
		
		textFieldRua = new JTextField();
		textFieldRua.setEnabled(false);
		textFieldRua.setBounds(276, 112, 148, 20);
		frame.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		textFieldRua.setVisible(false);
		this.textFieldRua = textFieldRua;
		
		textFieldCEP = new JTextField();
		textFieldCEP.setEnabled(false);
		textFieldCEP.setBounds(276, 162, 86, 20);
		frame.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		textFieldCEP.setVisible(false);
		this.textFieldCEP = textFieldCEP;
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDao userDao = new UsuarioDao();
				String cpf = textFieldCpf.getText();
				Usuario user = userDao.buscarUsuario(cpf);
				String senha = textFieldSenha.getText().trim();
				
				if(!ValidadorCPF.ehCpfValido(cpf)) {
					JOptionPane.showMessageDialog(null, 
							"Cpf inválido");
					clearAcess();
				}else if(user == null) {
					JOptionPane.showMessageDialog(null, 
							"Usuário não encontrado");
					clearAcess();
				}else if(user.getSenha().equals(senha) ) {
					
					JOptionPane.showMessageDialog(null, 
							"Login com sucesso");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								TelaHome window = new TelaHome(user);
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}else {
					JOptionPane.showMessageDialog(null, 
							"Senha inválida");
				}
			}
		});
		btnEnviar.setBounds(280, 12, 109, 23);
		frame.getContentPane().add(btnEnviar);
		this.btnEnviar = btnEnviar;
		
		JComboBox comboBoxEstados = new JComboBox();
		comboBoxEstados.setEnabled(false);
		comboBoxEstados.setModel(new DefaultComboBoxModel(new String[] {"Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		comboBoxEstados.setBounds(276, 137, 86, 20);
		frame.getContentPane().add(comboBoxEstados);
		comboBoxEstados.setVisible(false);
		this.comboBoxEstados = comboBoxEstados;
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDao userDao = new UsuarioDao();
				String cpf = textFieldCpf.getText();
				
				if(!ValidadorCPF.ehCpfValido(cpf)) {
					JOptionPane.showMessageDialog(null, 
							"Cpf inválido");
					clearAcess();
				}else if(userDao.buscarUsuario(cpf) != null) {
					JOptionPane.showMessageDialog(null, 
							"Usuário ja existente");
					clearAcess();
				}else {
					enableDetailElements();
					disableAcessElements();
				}
			}
		});
		btnRegistrar.setBounds(280, 42, 109, 23);
		frame.getContentPane().add(btnRegistrar);
		this.btnRegistrar = btnRegistrar;
		
		ButtonGroup bGroupLoginRegistro = new ButtonGroup();
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(66, 12, 150, 20);
		frame.getContentPane().add(textFieldCpf);
	    this.textFieldCpf = textFieldCpf;
	    
	    JButton btnEnviarRegis = new JButton("Enviar Registro");
	    btnEnviarRegis.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		UsuarioMediator userMediator = UsuarioMediator.getInstance();
	    		
	    		String nome = textFieldNome.getText().trim();
	    		String senha = textFieldSenha.getText().trim();
				String cpf = textFieldCpf.getText().trim();
				String email = textFieldEmail.getText().trim();
				String rua = textFieldRua.getText().trim();
				String cidade = textFieldCidade.getText().trim();
				String estado = comboBoxEstados.getSelectedItem().toString();
				String cep = textFieldCEP.getText().trim();
				Integer numero = Integer.parseInt(textFieldNumero.getText().trim());
				String pais = "Brasil";
				
				Endereco endereco = new Endereco(rua, cidade, estado, cep, numero, pais);
				
				Usuario user = new Usuario(nome, senha, cpf, email, endereco);
				
				String message = userMediator.validarUsuario(user);
				
				if(message != null) {
					JOptionPane.showMessageDialog(null, 
							message);
				}else {
					userMediator.incluirUsuario(user);
					JOptionPane.showMessageDialog(null, 
							"Registrado com sucesso");
					clearDetail();
					disableDetailElements();
					enableAcessElements();
				}
	    	}
	    });
	    btnEnviarRegis.setEnabled(false);
	    btnEnviarRegis.setBounds(10, 198, 130, 23);
	    frame.getContentPane().add(btnEnviarRegis);
		btnEnviarRegis.setVisible(false);
	    this.btnEnviarRegis = btnEnviarRegis;
	    
	    JButton btnVoltar = new JButton("Voltar");
	    btnVoltar.setEnabled(false);
	    btnVoltar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		enableAcessElements();
	    		disableDetailElements();
	    	}
	    });
	    btnVoltar.setBounds(150, 198, 109, 23);
	    frame.getContentPane().add(btnVoltar);
	    btnVoltar.setVisible(false);
	    this.btnVoltar = btnVoltar;
	    
	    
	}
	
	private void enableDetailElements() {
		textFieldNome.setEnabled(true);		
		textFieldEmail.setEnabled(true);
		comboBoxEstados.setEnabled(true);
		textFieldCidade.setEnabled(true);
		textFieldRua.setEnabled(true);
		textFieldNumero.setEnabled(true);
		textFieldCEP.setEnabled(true);
		btnEnviarRegis.setEnabled(true);
		btnVoltar.setEnabled(true);
		
		textFieldNome.setVisible(true);		
		textFieldEmail.setVisible(true);
		comboBoxEstados.setVisible(true);
		textFieldCidade.setVisible(true);
		textFieldRua.setVisible(true);
		textFieldNumero.setVisible(true);
		textFieldCEP.setVisible(true);
		btnEnviarRegis.setVisible(true);
		btnVoltar.setVisible(true);
		
		lblNome.setVisible(true);
		lblEmail.setVisible(true);
		lblEstado.setVisible(true);
		lblCidade.setVisible(true);
		lblRua.setVisible(true);
		lblNumero.setVisible(true);
		lblCEP.setVisible(true);
		
	}
	private void disableDetailElements() {
		textFieldNome.setEnabled(false);		
		textFieldEmail.setEnabled(false);
		comboBoxEstados.setEnabled(false);
		textFieldCidade.setEnabled(false);
		textFieldRua.setEnabled(false);
		textFieldNumero.setEnabled(false);
		textFieldCEP.setEnabled(false);
		btnEnviarRegis.setEnabled(false);
		btnVoltar.setEnabled(false);
		
		textFieldNome.setVisible(false);		
		textFieldEmail.setVisible(false);
		comboBoxEstados.setVisible(false);
		textFieldCidade.setVisible(false);
		textFieldRua.setVisible(false);
		textFieldNumero.setVisible(false);
		textFieldCEP.setVisible(false);
		btnEnviarRegis.setVisible(false);
		btnVoltar.setVisible(false);
		
		lblNome.setVisible(false);
		lblEmail.setVisible(false);
		lblEstado.setVisible(false);
		lblCidade.setVisible(false);
		lblRua.setVisible(false);
		lblNumero.setVisible(false);
		lblCEP.setVisible(false);
	}
	private void enableAcessElements() {
		textFieldCpf.setEnabled(true);
		textFieldSenha.setEnabled(true);	
		btnEnviar.setEnabled(true);	
		btnRegistrar.setEnabled(true);

		lblCpf.setEnabled(true);
		lblSenha.setEnabled(true);
	}
	private void disableAcessElements() {
		textFieldCpf.setEnabled(false);
		textFieldSenha.setEnabled(false);
		btnEnviar.setEnabled(false);	
		btnRegistrar.setEnabled(false);
		
		lblCpf.setEnabled(false);
		lblSenha.setEnabled(false);
	}
	private void clearDetail() {
		textFieldNome.setText("");		
		textFieldEmail.setText("");	
		textFieldCidade.setText("");	
		textFieldRua.setText("");	
		textFieldNumero.setText("");	
		textFieldCEP.setText("");		
	}
	private void clearAcess() {
		textFieldCpf.setText("");	
		textFieldSenha.setText("");
	}
}
