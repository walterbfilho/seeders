package telas;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

import usuario.*;

import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class TelaHome {

	JFrame frame;
	private Usuario user;
	
	private JLabel lblOng;
	private JLabel lblOngDesc;
	private JLabel lblTag1;
	private JLabel lblTag2;
	private JLabel lblTag3;
	private JComboBox comboBoxTag1;
	private JComboBox comboBoxTag2;
	private JComboBox comboBoxTag3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHome window = new TelaHome();
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
	public TelaHome() {
		initialize();
	}
	public TelaHome(Usuario user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame = frame;
		frame.getContentPane().setLayout(null);
		
		JLabel lblTag1 = new JLabel("Tag1");
		lblTag1.setBounds(10, 24, 34, 14);
		frame.getContentPane().add(lblTag1);
		this.lblTag1 = lblTag1;
		
		JButton btnNewButton = new JButton("Adicionar Projeto");
		btnNewButton.setBounds(275, 227, 149, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBuscarProjeot = new JButton("Buscar Projetos");
		btnBuscarProjeot.setBounds(10, 49, 163, 23);
		btnBuscarProjeot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
	    		if(cont != 0) {			
	    			for (Component component : frame.getContentPane().getComponents()) {
	    				if (component instanceof JLabel) {
	    					if(component != lblTag1 && component != lblTag2 && component != lblTag3) {
	    						component.setVisible(false);
	    					}
	    				}
	    			}
	    		}
				
				Geolocalizacao geo = new Geolocalizacao();
				OngMediator ongMediator = OngMediator.getInstance();
				
				OngCadastrada[] ongs = ongMediator.ongDAO.buscarOngsPorTag(tags);
				int i = 0;

				for(OngCadastrada ong:ongs) {
					if(ong != null) {
						JLabel lblOng = new JLabel(ong.getNome());
						lblOng.setBounds(56, 130 + 20*i, 200, 14);
						frame.getContentPane().add(lblOng);
						i++;
					}
				}
				
			}
		});
		frame.getContentPane().add(btnBuscarProjeot);
		
		JComboBox comboBoxTag1 = new JComboBox();
		comboBoxTag1.setBounds(54, 22, 75, 18);
		comboBoxTag1.setModel(new DefaultComboBoxModel(new String[] {"sem tag", "saúde", "higiene", "roupa", "usados", "água", "comida", "moradia", "entretenimento", "educação", "cultura", "arte", "animais", "esporte", "assistencia social", "direitos humanos", "meio ambiente"}));
		frame.getContentPane().add(comboBoxTag1);
		this.comboBoxTag1 = comboBoxTag1;
		
		JLabel lblTag2 = new JLabel("Tag2");
		lblTag2.setBounds(152, 26, 34, 14);
		frame.getContentPane().add(lblTag2);
		this.lblTag2 = lblTag2;
		
		JComboBox comboBoxTag2 = new JComboBox();
		comboBoxTag2.setBounds(196, 24, 75, 18);
		comboBoxTag2.setModel(new DefaultComboBoxModel(new String[] {"sem tag", "saúde", "higiene", "roupa", "usados", "água", "comida", "moradia", "entretenimento", "educação", "cultura", "arte", "animais", "esporte", "assistencia social", "direitos humanos", "meio ambiente"}));
		frame.getContentPane().add(comboBoxTag2);
		this.comboBoxTag2 = comboBoxTag2;
		
		JLabel lblTag3 = new JLabel("Tag3");
		lblTag3.setBounds(288, 26, 34, 14);
		frame.getContentPane().add(lblTag3);
		this.lblTag3 = lblTag3;
		
		JComboBox comboBoxTag3 = new JComboBox();
		comboBoxTag3.setBounds(332, 24, 75, 18);
		comboBoxTag3.setModel(new DefaultComboBoxModel(new String[] {"sem tag", "saúde", "higiene", "roupa", "usados", "água", "comida", "moradia", "entretenimento", "educação", "cultura", "arte", "animais", "esporte", "assistencia social", "direitos humanos", "meio ambiente"}));
		frame.getContentPane().add(comboBoxTag3);
		this.comboBoxTag3 = comboBoxTag3;
		
		JLabel lblNewLabel = new JLabel("Ongs mais proximas");
		lblNewLabel.setBounds(140, 83, 163, 14);
		frame.getContentPane().add(lblNewLabel);
		

		
		Geolocalizacao geo = new Geolocalizacao();
		OngMediator ongMediator = OngMediator.getInstance();
		
		OngCadastrada[] ongs = ongMediator.ordenarOngsPorDistancia(user).ongs;
		Double[] distancias = ongMediator.ordenarOngsPorDistancia(user).distancias;
		int i = 0;
		for(OngCadastrada ong:ongs) {
			JLabel lblOng = new JLabel(ong.getNome());
			lblOng.setBounds(56, 130 + 20*i, 200, 14);
			frame.getContentPane().add(lblOng);
			this.lblOng = lblOng;
		
			JLabel lblOngDesc = new JLabel( distancias[i].intValue()/1000 + " Km");
			lblOngDesc.setBounds(250, 130 + 20*i, 200, 14);
			frame.getContentPane().add(lblOngDesc);
			this.lblOngDesc = lblOngDesc;
			i++;
		}
		
		
	}
}
