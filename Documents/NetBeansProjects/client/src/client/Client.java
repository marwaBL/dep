/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author USER1
 */
  import java.io.Serializable;
public class Client implements Serializable {
  




	private String nom,prenom;
	private String tel,cin;

	public Client(String nom, String prenom, String tel, String cin) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	
	
	
	
	


}
