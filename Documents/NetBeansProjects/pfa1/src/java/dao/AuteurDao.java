/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import modele.Auteur;
import modele.Ecrire;
import modele.HibernateUtil;
import modele.Publication;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */
public class AuteurDao {
    



 public ArrayList listAuteur(){	
		
		ArrayList list=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Auteur ");
		
                       
			    list= (ArrayList) query.list();
                            
                             
                          /*    for (int i=0;i<l.size();i++)
                              {
                                
                                  list.add(((Auteur)l.get(i)).getNomAut());
                           
                           }*/
		//list= (ArrayList) query.list();
		   /*for(int i=0;i<list.size();i++)
                   {
                       System.out.println(list.get(i));
                   }*/
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			
			return list;
			}
 public Auteur AuteurPub(ArrayList l,String nom,String prenom)
 {
     int i=0;
     while(i<l.size())
     {
         if(((Auteur)l.get(i)).getNomAut().equalsIgnoreCase(nom)&&((Auteur)l.get(i)).getPrenomAut().equalsIgnoreCase(prenom))
  return ((Auteur)l.get(i));
             i++;
             }
     return new Auteur(null, nom, prenom, null);
     
 }
 
 public void ajoutNouveauAuteur(ArrayList l,ArrayList listauteur)
 {
     Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
    /* System.out.println("list"+l.size());
     for(int i=0;i<l.size();i++)
     { System.out.println("id aut "+((Auteur)l.get(i)).getIdAut()+((Auteur)l.get(i)).getNomAut());
         if(((Auteur)l.get(i)).getIdAut()==null)
         { 
              Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
        Auteur a=(Auteur)l.get(i);
        l.remove((Auteur)l.get(i));
	session.save(a);
        
	transaction.commit();
	System.out.println("Data Saved");
        l.add(a);
	}catch(Exception e)
	{e.printStackTrace();}
         }
         
     }*/
     for(int i=0;i<l.size();i++)
     
     {
         Auteur a= new Auteur();
         a.setNomAut(((Auteur)l.get(i)).getNomAut());
                 a.setPrenomAut(((Auteur)l.get(i)).getPrenomAut());
         
         if(!listauteur.contains(a))
         {
             transaction = session.beginTransaction();
       
	session.save(a);
        
	transaction.commit();
         }
     }
     }
 public Auteur findAuteurByChercheur(int idch)
 { Auteur a=null;
    
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Auteur where IdCh=:id ");
		query.setParameter("id", idch);
                
                       
			a    = (Auteur) query.uniqueResult();
                            
                             
                         
		
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			return a;
			
 }
 
  public ArrayList findListEcrireByPublication(Publication p)
 { ArrayList l=new ArrayList();
 ArrayList la=null ;
    
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Ecrire where IdPub=:id  order by rang");
		query.setParameter("id", p.getIdPub());
                
                       
		 la    = (ArrayList) query.list();
                      /*  for(int i=0;i<la.size();i++)
                           l.add(((Ecrire)la.get(i)).getAuteur());
                             
                            System.out.println("au "+((Auteur)l.get(0)).getNomAut());*/
		
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			return la;
			
 }
 
}