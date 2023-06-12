import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaUsuario {

	private JFrame frame;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private JTextField textNome;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldCidade;
	private JTextField textFieldNumero;
	private JTextField textFieldRua;
	private JTextField textFieldCEP;
	private JButton btnEnviar;
	private JButton btnRegistrar;
	private JButton btnEnviarRegis;
	private JComboBox comboBoxEstados;
	
	private ButtonGroup bGroupLoginRegistro;
	
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
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 15, 46, 14);
		frame.getContentPane().add(lblEmail);
		this.lblEmail = lblEmail;
		
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
		this.lblNome = lblNome;
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(220, 115, 46, 14);
		frame.getContentPane().add(lblRua);
		this.lblRua = lblRua;
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(220, 140, 46, 14);
		frame.getContentPane().add(lblEstado);
		this.lblEstado = lblEstado;
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 140, 46, 14);
		frame.getContentPane().add(lblCidade);
		this.lblCidade = lblCidade;
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(220, 165, 46, 14);
		frame.getContentPane().add(lblCEP);
		this.lblCEP = lblCEP;
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 165, 46, 14);
		frame.getContentPane().add(lblNumero);
		this.lblNumero = lblNumero;
		
		textFieldNome = new JTextField();
		textFieldNome.setText("Walter Andé de Sá Barreto Filho");
		textFieldNome.setEnabled(false);
		textFieldNome.setBounds(100, 87, 176, 20);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		this.textFieldNome = textFieldNome;
		
		textFieldCpf = new JTextField();
		textFieldCpf.setText("132.808.944-41");
		textFieldCpf.setEnabled(false);
		textFieldCpf.setBounds(100, 112, 99, 20);
		frame.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		this.textFieldCpf = textFieldCpf;
		
		textFieldCidade = new JTextField();
		textFieldCidade.setText("Recife");
		textFieldCidade.setEnabled(false);
		textFieldCidade.setBounds(100, 137, 99, 20);
		frame.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		this.textFieldCidade = textFieldCidade;
		
		textFieldNumero = new JTextField();
		textFieldNumero.setText("835");
		textFieldNumero.setEnabled(false);
		textFieldNumero.setBounds(100, 162, 99, 20);
		frame.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		this.textFieldNumero = textFieldNumero;
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(10, 115, 46, 14);
		frame.getContentPane().add(lblCpf);
		this.lblCpf = lblCpf;
		
		textFieldRua = new JTextField();
		textFieldRua.setText("Rua padre Carapuceiro");
		textFieldRua.setEnabled(false);
		textFieldRua.setBounds(276, 112, 148, 20);
		frame.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		this.textFieldRua = textFieldRua;
		
		textFieldCEP = new JTextField();
		textFieldCEP.setEnabled(false);
		textFieldCEP.setBounds(276, 162, 86, 20);
		frame.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		this.textFieldCEP = textFieldCEP;
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		this.comboBoxEstados = comboBoxEstados;
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableDetailElements();
				disableAcessElements();
			}
		});
		btnRegistrar.setBounds(280, 42, 109, 23);
		frame.getContentPane().add(btnRegistrar);
		this.btnRegistrar = btnRegistrar;
		
		ButtonGroup bGroupLoginRegistro = new ButtonGroup();
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(66, 12, 150, 20);
		frame.getContentPane().add(textFieldEmail);
	    this.bGroupLoginRegistro = bGroupLoginRegistro;
	    this.textFieldEmail = textFieldEmail;
	    
	    JButton btnEnviarRegis = new JButton("Enviar Registro");
	    btnEnviarRegis.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		disableDetailElements();
				enableAcessElements();
	    	}
	    });
	    btnEnviarRegis.setEnabled(false);
	    btnEnviarRegis.setBounds(10, 198, 130, 23);
	    frame.getContentPane().add(btnEnviarRegis);
		btnEnviarRegis.setVisible(false);
	    this.btnEnviarRegis = btnEnviarRegis;
	  
	    
	}
	
	private void enableDetailElements() {
		textFieldNome.setEnabled(true);		
		textFieldCpf.setEnabled(true);
		comboBoxEstados.setEnabled(true);
		textFieldCidade.setEnabled(true);
		textFieldRua.setEnabled(true);
		textFieldNumero.setEnabled(true);
		textFieldCEP.setEnabled(true);
		btnEnviarRegis.setEnabled(true);
		
		textFieldNome.setVisible(true);		
		textFieldCpf.setVisible(true);
		comboBoxEstados.setVisible(true);
		textFieldCidade.setVisible(true);
		textFieldRua.setVisible(true);
		textFieldNumero.setVisible(true);
		textFieldCEP.setVisible(true);
		btnEnviarRegis.setVisible(true);
		
		lblNome.setVisible(true);
		lblCpf.setVisible(true);
		lblEstado.setVisible(true);
		lblCidade.setVisible(true);
		lblRua.setVisible(true);
		lblNumero.setVisible(true);
		lblCEP.setVisible(true);
		
	}
	private void disableDetailElements() {
		textFieldNome.setEnabled(false);		
		textFieldCpf.setEnabled(false);
		comboBoxEstados.setEnabled(false);
		textFieldCidade.setEnabled(false);
		textFieldRua.setEnabled(false);
		textFieldNumero.setEnabled(false);
		textFieldCEP.setEnabled(false);
		btnEnviarRegis.setEnabled(false);
		
		textFieldNome.setVisible(false);		
		textFieldCpf.setVisible(false);
		comboBoxEstados.setVisible(false);
		textFieldCidade.setVisible(false);
		textFieldRua.setVisible(false);
		textFieldNumero.setVisible(false);
		textFieldCEP.setVisible(false);
		btnEnviarRegis.setVisible(false);
		
		lblNome.setVisible(false);
		lblCpf.setVisible(false);
		lblEstado.setVisible(false);
		lblCidade.setVisible(false);
		lblRua.setVisible(false);
		lblNumero.setVisible(false);
		lblCEP.setVisible(false);
	}
	private void enableAcessElements() {
		textFieldEmail.setEnabled(true);
		textFieldSenha.setEnabled(true);	
		btnEnviar.setEnabled(true);	
		btnRegistrar.setEnabled(true);

		lblEmail.setEnabled(true);
		lblSenha.setEnabled(true);
	}
	private void disableAcessElements() {
		textFieldEmail.setEnabled(false);
		textFieldSenha.setEnabled(false);
		btnEnviar.setEnabled(false);	
		btnRegistrar.setEnabled(false);
		
		lblEmail.setEnabled(false);
		lblSenha.setEnabled(false);
	}
}
