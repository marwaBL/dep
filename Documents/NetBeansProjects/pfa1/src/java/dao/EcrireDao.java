/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modele.Auteur;
import modele.Ecrire;
import modele.EcrireId;
import modele.HibernateUtil;
import modele.Publication;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */
public class EcrireDao {
    
    
    public void ajout(ArrayList l,Publication p)
 {Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
        System.out.println("ecrire id + "+((Auteur)l.get(0)).getIdAut());
        
       
        
     for(int i=0;i<l.size();i++)
     {
         Ecrire e=new Ecrire();
          try	{
		Transaction	transaction1 = session.beginTransaction();
			Query query = session.createQuery("from  Auteur where NomAut=:nom and PrenomAut=:prenom ");
		query.setParameter("nom", ((Auteur)l.get(i)).getNomAut());
                query.setParameter("prenom", ((Auteur)l.get(i)).getPrenomAut());
                       
			Auteur a=(Auteur) query.uniqueResult();
                            
                             
                         
		
			
	
         EcrireId eid=new EcrireId(p.getIdPub(),a.getIdAut());
         e.setId(eid);
         e.setAuteur(a);
         e.setPublication(p);
         e.setRang(i);
         
              }
			catch(Exception ex)
			{ex.printStackTrace();}
	try{
	transaction = session.beginTransaction();
	session.save(e);
        
	transaction.commit();
	System.out.println("Data Saved");
        
	}catch(Exception ex)
	{ex.printStackTrace();}
         }
         
     
     }
 
    public ArrayList  findListPublicationByAuteur(Auteur a)
    { ArrayList listec=null;
         Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Ecrire where IdAut=:id ");
		query.setParameter("id", a.getIdAut());
                
                       
			listec   = (ArrayList) query.list();
                            
                             
                         
		
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			return listec;
    }
     public ArrayList  findListPublication(ArrayList l)
    { ArrayList listec=new ArrayList();
         Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                for(int i=0;i<l.size();i++)
                {	
                    Ecrire e=(Ecrire) l.get(i);
                    
                    
                    Query query = session.createQuery("from  Publication where IdPub=:id order by annee desc");
		query.setParameter("id", e.getPublication().getIdPub());
                
                       
			Publication p   = (Publication) query.uniqueResult();
                        listec.add(p);
                            
                }             
                         
		
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			return listec;
    }
    
     public ArrayList  findListAuteur(ArrayList l)
    { ArrayList listec=new ArrayList();
         Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                for(int i=0;i<l.size();i++)
                {	
                    Ecrire e=(Ecrire) l.get(i);
                    
                    
                    Query query = session.createQuery("from  Auteur where IdAut=:id ");
		query.setParameter("id", e.getAuteur().getIdAut());
                
                       
			Auteur p   = (Auteur) query.uniqueResult();
                        listec.add(p);
                            
                }             
                         
		
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			return listec;
    }

     
     public ArrayList  findListPublicationtest(ArrayList l)
    { ArrayList listec=new ArrayList();
         Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
              
                    ArrayList <String> lidp=new ArrayList<String>();
                    for(int i=0;i<l.size();i++)
                    { String c=((Ecrire)l.get(i)).getPublication().getIdPub()+"";
                        lidp.add(c);
                    
                    }
                            System.out.println("id pub "+lidp);
                            
                    Query query = session.createQuery("from  Publication where IdPub in (:id) order by annee desc");
		query.setParameterList("id", lidp);
                            System.out.println("req "+  query.getQueryString());
               /* for(int i=0;i<lidp.size();i++)
                {
                   Query query = session.createQuery("from  Publication where IdPub =:id order by annee desc");
		query.setParameter("id", lidp.get(i)); 
                System.out.println("res "+query.list());
			listec= (ArrayList) query.list();
                }*/
                           
			listec= (ArrayList) query.list();
                         System.out.println("res "+listec);
                            
                           
                         
		
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			return listec;
    }
     
}




