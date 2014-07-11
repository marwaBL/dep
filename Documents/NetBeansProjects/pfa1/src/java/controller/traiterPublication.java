/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER1
 */
public class traiterPublication {
  private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
  
    public void traiter()
    {
       titre= titre.replaceAll(" ", "");
      titre=  titre.toLowerCase();
    }
    
  public BigInteger hash ()
  { 
      traiter();
      BigInteger bigInt = null;
      try {
          MessageDigest m = MessageDigest.getInstance("MD5");
          m.reset();
          m.update(titre.getBytes());
          byte[] digest = m.digest();
         bigInt = new BigInteger(1,digest);
          System.out.println("int "+bigInt);
          System.out.println("titre "+titre.hashCode());
      } catch (NoSuchAlgorithmException ex) {
          System.out.println("erreur hashage"+ ex);
      }
       return bigInt;
  }
  public boolean titreExiste(BigInteger a,BigInteger b)
  {
      
      return a.compareTo(b)==0;
  }
  
  
}
