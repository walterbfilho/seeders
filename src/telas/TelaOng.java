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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TelaOng{
	private Usuario user = null;
	JFrame frame;
	private JTextField textFieldCpf;
	private JTextField textFieldCelular;
	private JTextField textFieldSenha;
	private JTextField textFieldEmail;
	private JTextField textNome;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JTextField textFieldPix;
	private JTextField textFieldNumero;
	private JTextField textFieldRua;
	private JTextField textFieldCEP;
	private JTextField textFieldLinkedIn;
	private JTextField textFieldSite;
	private JTextField textFieldInstagram;
	private JTextField textFieldFacebook;
	private JButton btnEnviar;
	private JButton btnRegistrar;
	private JButton btnEnviarRegis;
	private JButton btnVoltar;
	private JComboBox comboBoxEstados;
	private JComboBox comboBoxTag1;
	private JComboBox comboBoxTag2;
	private JComboBox comboBoxTag3;
	
	private ButtonGroup bGroupLoginRegistro;
	
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEstado;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblCEP;
	private JLabel lblDescricao;
	private JTextField textFieldCidade;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOng window = new TelaOng();
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
	public TelaOng() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.frame = frame;
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 140, 46, 14);
		frame.getContentPane().add(lblCelular);
		this.lblCpf = lblCelular;
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 115, 46, 14);
		frame.getContentPane().add(lblEmail);
		this.lblSenha = lblEmail;
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(66, 112, 118, 20);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		this.textFieldEmail = textFieldEmail;
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 15, 46, 14);
		frame.getContentPane().add(lblNome);
		this.lblNome = lblNome;

		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(220, 89, 46, 14);
		frame.getContentPane().add(lblRua);
		this.lblRua = lblRua;

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(220, 114, 46, 14);
		frame.getContentPane().add(lblEstado);
		this.lblEstado = lblEstado;

		JLabel lblPix = new JLabel("Pix");
		lblPix.setBounds(10, 86, 46, 14);
		frame.getContentPane().add(lblPix);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(221, 168, 46, 14);
		frame.getContentPane().add(lblCEP);
		this.lblCEP = lblCEP;
		
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(221, 196, 46, 14);
		frame.getContentPane().add(lblNumero);
		this.lblNumero = lblNumero;		
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(66, 12, 172, 20);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);	
		this.textFieldNome = textFieldNome;		
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(66, 43, 172, 20);
		frame.getContentPane().add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		this.textFieldDescricao = textFieldDescricao;		

		textFieldPix = new JTextField();
		textFieldPix.setBounds(66, 83, 118, 20);
		frame.getContentPane().add(textFieldPix);
		textFieldPix.setColumns(10);
		this.textFieldPix = textFieldPix;
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(277, 193, 86, 20);
		frame.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		this.textFieldNumero = textFieldNumero;
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(10, 46, 46, 14);
		frame.getContentPane().add(lblDescricao);
		this.lblDescricao= lblDescricao;
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(276, 86, 148, 20);
		frame.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		this.textFieldRua = textFieldRua;
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(277, 165, 86, 20);
		frame.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		this.textFieldCEP = textFieldCEP;
		
		JComboBox comboBoxEstados = new JComboBox();
		comboBoxEstados.setModel(new DefaultComboBoxModel(new String[] {"Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		comboBoxEstados.setBounds(276, 111, 86, 20);
		frame.getContentPane().add(comboBoxEstados);
		this.comboBoxEstados = comboBoxEstados;
		
		ButtonGroup bGroupLoginRegistro = new ButtonGroup();
		
		textFieldCelular = new JTextField();
		textFieldCelular.setColumns(10);
		textFieldCelular.setBounds(66, 137, 118, 20);
		frame.getContentPane().add(textFieldCelular);
	    this.bGroupLoginRegistro = bGroupLoginRegistro;
	    this.textFieldCelular = textFieldCelular;
	    
	    JButton btnEnviarRegis = new JButton("Enviar Registro");
	    btnEnviarRegis.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		OngMediator ongMediator = OngMediator.getInstance();
	    		
	    		String nome = textFieldNome.getText().trim();
	    		String[] tagsAux = new String[3];
	    		
	    		int cont = 0;
	    		if(comboBoxTag1.getSelectedItem().toString() != null) {
	    			tagsAux[cont] = comboBoxTag1.getSelectedItem().toString();
	    			cont++;
	    		}
	    		if(comboBoxTag2.getSelectedItem().toString() != null) {
	    			tagsAux[cont] = comboBoxTag2.getSelectedItem().toString();
	    			cont++;
	    		}
	    		if(comboBoxTag3.getSelectedItem().toString() != null) {
	    			tagsAux[cont] = comboBoxTag3.getSelectedItem().toString();
	    			cont++;
	    		}
	    		String[] tags = new String[cont];
	    		
	    		for(int i = 0; i<cont; i++) {
	    			tags[i] = tagsAux[i];
	    		}
	    		
				String descricao = textFieldDescricao.getText().trim();
				String pix = textFieldPix.getText().trim();
				
				String email = textFieldEmail.getText().trim();
				String celular = textFieldCelular.getText().trim();
				String linkedIn = textFieldLinkedIn.getText().trim();
				String site = textFieldSite.getText().trim();
				String instagram = textFieldInstagram.getText().trim();
				String facebook = textFieldFacebook.getText().trim();
				
				InfoContato info = new InfoContato(email, celular, linkedIn, site, instagram, facebook);
				
				String rua = textFieldRua.getText().trim();
				String cidade = textFieldCidade.getText().trim();
				String estado = comboBoxEstados.getSelectedItem().toString();
				String cep = textFieldCEP.getText().trim();
				Integer numero = Integer.parseInt(textFieldNumero.getText().trim());
				String pais = "Brasil";
				
				Endereco endereco = new Endereco(rua, cidade, estado, cep, numero, pais);
				
				OngCadastrada ong = new OngCadastrada(nome, tags, descricao, pix, info, endereco);
				
				String message = ongMediator.validarOng(ong);
				
				if(message != null) {
					JOptionPane.showMessageDialog(null, 
							message);
				}else {
					ongMediator.incluirOng(ong);
					JOptionPane.showMessageDialog(null, 
							"Registrado com sucesso");

				}
	    	}
	    });
	    btnEnviarRegis.setBounds(10, 277, 130, 23);
	    frame.getContentPane().add(btnEnviarRegis);

	    this.btnEnviarRegis = btnEnviarRegis;
	    
	    JLabel lblLinkedIn = new JLabel("LinkedIn");
	    lblLinkedIn.setBounds(10, 168, 46, 14);
	    frame.getContentPane().add(lblLinkedIn);
	    
	    textFieldLinkedIn = new JTextField();
	    textFieldLinkedIn.setColumns(10);
	    textFieldLinkedIn.setBounds(66, 165, 118, 20);
	    frame.getContentPane().add(textFieldLinkedIn);
	    this.textFieldLinkedIn = textFieldLinkedIn;
	    
	    textFieldSite = new JTextField();
	    textFieldSite.setColumns(10);
	    textFieldSite.setBounds(66, 190, 118, 20);
	    frame.getContentPane().add(textFieldSite);
	    this.textFieldSite = textFieldSite;
	    
	    JLabel lblSite = new JLabel("Site");
	    lblSite.setBounds(10, 193, 46, 14);
	    frame.getContentPane().add(lblSite);
	    
	    textFieldInstagram = new JTextField();
	    textFieldInstagram.setColumns(10);
	    textFieldInstagram.setBounds(66, 218, 118, 20);
	    frame.getContentPane().add(textFieldInstagram);
	    this.textFieldInstagram = textFieldInstagram;
	    
	    JLabel lblInstagram = new JLabel("Instagram");
	    lblInstagram.setBounds(10, 221, 65, 14);
	    frame.getContentPane().add(lblInstagram);
	    
	    textFieldFacebook = new JTextField();
	    textFieldFacebook.setColumns(10);
	    textFieldFacebook.setBounds(66, 246, 118, 20);
	    frame.getContentPane().add(textFieldFacebook);
	    this.textFieldFacebook = textFieldFacebook;
	    
	    JLabel lblFacebook = new JLabel("Facebook");
	    lblFacebook.setBounds(10, 246, 46, 14);
	    frame.getContentPane().add(lblFacebook);
	    
	    JLabel lblTag1 = new JLabel("Tag1");
	    lblTag1.setBounds(221, 223, 46, 14);
	    frame.getContentPane().add(lblTag1);
	    
	    JLabel lblTag2 = new JLabel("Tag2");
	    lblTag2.setBounds(221, 249, 46, 14);
	    frame.getContentPane().add(lblTag2);
	    
	    JLabel lblTag3 = new JLabel("Tag3");
	    lblTag3.setBounds(221, 277, 46, 14);
	    frame.getContentPane().add(lblTag3);
	    
	    comboBoxTag1 = new JComboBox();
	    comboBoxTag1.setModel(new DefaultComboBoxModel(new String[] {"sem tag", "saúde", "higiene", "roupa", "usados", "água", "comida", "moradia", "entretenimento", "educação", "cultura", "arte", "animais", "esporte", "assistencia social", "direitos humanos", "meio ambiente"}));
	    comboBoxTag1.setBounds(277, 219, 86, 20);
	    frame.getContentPane().add(comboBoxTag1);
	    this.comboBoxTag1 = comboBoxTag1;
	    
	    JComboBox comboBoxTag2 = new JComboBox();
	    comboBoxTag2.setModel(new DefaultComboBoxModel(new String[] {"sem tag", "saúde", "higiene", "roupa", "usados", "água", "comida", "moradia", "entretenimento", "educação", "cultura", "arte", "animais", "esporte", "assistencia social", "direitos humanos", "meio ambiente"}));
	    comboBoxTag2.setBounds(277, 246, 86, 20);
	    frame.getContentPane().add(comboBoxTag2);
	    this.comboBoxTag2 = comboBoxTag2;
	    
	    JComboBox comboBoxTag3 = new JComboBox();
	    comboBoxTag3.setModel(new DefaultComboBoxModel(new String[] {"sem tag", "saúde", "higiene", "roupa", "usados", "água", "comida", "moradia", "entretenimento", "educação", "cultura", "arte", "animais", "esporte", "assistencia social", "direitos humanos", "meio ambiente"}));
	    comboBoxTag3.setBounds(277, 274, 86, 20);
	    frame.getContentPane().add(comboBoxTag3);
	    this.comboBoxTag3 = comboBoxTag3;
	    
	    JLabel lblCidade = new JLabel("Cidade");
	    lblCidade.setBounds(220, 140, 46, 14);
	    frame.getContentPane().add(lblCidade);
	    
	    textFieldCidade = new JTextField();
	    textFieldCidade.setColumns(10);
	    textFieldCidade.setBounds(276, 137, 86, 20);
	    frame.getContentPane().add(textFieldCidade);
	    this.textFieldCidade = textFieldCidade;
	    
	}
	
	private void clearDetail() {
		textFieldNome.setText("");		
		textFieldDescricao.setText("");	
		textFieldPix.setText("");	
		textFieldRua.setText("");	
		textFieldNumero.setText("");	
		textFieldCEP.setText("");		
	}
	private void clearAcess() {
		textFieldCelular.setText("");	
		textFieldEmail.setText("");
	}
}
