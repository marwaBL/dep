/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modele.Editeur;
import modele.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */
public class EditeurDao {
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



 public ArrayList listEditeur(){	
		
		ArrayList list=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Editeur ");
		
                       
			    list= (ArrayList) query.list();
                            
                             
                       
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			
			return list;
			}
 public boolean EditeurPub(ArrayList l,String nom,String prenom)
 {
     int i=0;
     System.out.println("editeur "+l);
     while(i<l.size())
     {
         if(((Editeur)l.get(i)).getNomEd().equalsIgnoreCase(nom)&&((Editeur)l.get(i)).getPrenomEd().equalsIgnoreCase(prenom))
  return true;
             i++;
             }
     return false;
     
 }
 
 public void ajoutNouveauEditeur(String nom,String prenom)
 {
     
              Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
        Editeur a=new Editeur();
       a.setNomEd(nom);
       a.setPrenomEd(prenom);
	session.save(a);
        
	transaction.commit();
	System.out.println("Data Saved");
       
	}catch(Exception e)
	{e.printStackTrace();}
         }
         
     
     
 
 
 
 

}
