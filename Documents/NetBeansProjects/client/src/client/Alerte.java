/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author USER1
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


 

public class Alerte extends JDialog {

	JButton btnNewButton;
	JLabel lblNewLabel;
	/**
	 * Create the dialog.
	 */
	public Alerte(String msg) {
		setTitle("Alerte");
		setBounds(100, 100, 420, 200);
	    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 JPanel contentPane;
        contentPane = new JPanel()
		
        {
            protected void paintComponent(Graphics g) 
            {
               super.paintComponent(g);
 
                ImageIcon m = new ImageIcon("fbleu.png");
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);
 			
            }
        };
        //contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblNewLabel = new JLabel(msg,JLabel.CENTER);
		lblNewLabel.setIcon(new ImageIcon("alert.jpg"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 36, 384, 31);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				hide();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(168, 104, 89, 23);
		getContentPane().add(btnNewButton);
		
	}
}
   

