/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author USER1
 */  import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

  


public class Ajout extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtCin;
	private JTextField txtTel;
	private JLabel lbNom;
	private JLabel lbPrenom;
	private JLabel lbCin;
	private JLabel lbTlephone;
	private JButton btnAjouter;
	private JButton btnRetour;
	// clientInterface ca;
	
	

////methode pour ajouter l'employe dans la table bd	
public void  ajouterEmp(Client emp)
	
	{
		try
		{	//if (System.getSecurityManager() == null)
//System.setSecurityManager(new RMISecurityManager());

		   
			// Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099);

          //  clientInterface caf=(clientInterface) Naming.lookup("carnet");

			clientInterface caf=(clientInterface)Naming.lookup("carnet");
			System.out.println("l'employé :");
		  
		  
		   caf.ajouter(emp);        //appel a la methode ajouter du serveur
		   Alerte dialog = new Alerte(caf.callMeBack());
	if(!caf.callMeBack().equals(""))  //si le serveur retourne une exception 
		 {if(caf.callMeBack().contains("CIN")) //si probleme de CIN
			 txtCin.setText("");
		 if(caf.callMeBack().contains("telephone"))//si probleme de Telephone
			 txtTel.setText("");
		 if(caf.callMeBack().equals("Employé bien ajouté"))//si l' employe a ete bien ajouté
		 {
			 txtNom.setText("");
			 txtCin.setText("");
			 txtPrenom.setText("");
			 txtTel.setText("");
			 dialog.lblNewLabel.setIcon(new ImageIcon ("C:\\Users\\USER1\\Desktop\\tp java\\jee\\Client\\tick 1.gif"));
			 dialog.lblNewLabel.setForeground(new Color(34, 139, 34));
		 }
				
				
				
				dialog.setVisible(true);
		 }
		 
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Ajout() {
		setTitle("Ajout Employ\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(438, 400);
		
		setLocationRelativeTo(null);
		
		contentPane = new JPanel()
		
        {
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
 
                ImageIcon m = new ImageIcon("C:\\Users\\USER1\\Desktop\\tp java\\fundo-floral.jpg");
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);
 
            }
        };
        
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		 lbNom = new JLabel("Nom");
		//lbNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbNom.setBounds(82, 76, 46, 14);
		contentPane.add(lbNom);
		
		 lbPrenom = new JLabel("Pr\u00E9nom");
		//lbPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbPrenom.setBounds(82, 127, 63, 14);
		contentPane.add(lbPrenom);
		
		 lbCin = new JLabel("CIN");
		//lbCin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbCin.setBounds(82, 174, 46, 14);
		contentPane.add(lbCin);
		
		 lbTlephone = new JLabel("T\u00E9lephone");
		//lbTlephone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTlephone.setBounds(82, 222, 81, 22);
		contentPane.add(lbTlephone);
		
		txtNom = new JTextField();
		txtNom.setBounds(197, 75, 86, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(197, 126, 86, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtCin = new JTextField();
		txtCin.setBounds(197, 173, 86, 20);
		contentPane.add(txtCin);
		txtCin.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(197, 225, 86, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		 btnAjouter = new JButton("Ajouter");
		//btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjouter.setBounds(116, 307, 89, 23);
		contentPane.add(btnAjouter);
		 btnAjouter.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 	
			 		
						     Client emp=new Client(txtNom.getText(), txtPrenom.getText(),txtTel.getText(), txtCin.getText());
						    
						     ajouterEmp(emp);
			 	
			 	    
			 		 
			 	}
			 });
		
		btnRetour = new JButton("Retour");
		
		//btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.setBounds(238, 307, 89, 23);
		contentPane.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Accueil ac=new Accueil();
				hide();
				ac.show();
				
			}
		});
		
		
		
	}
}


