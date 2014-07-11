/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modele.Etablissement;
import modele.HibernateUtil;
import modele.Structurerecherche;
import modele.Universite;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */
public class UniversiteDao {
    
    public ArrayList listUniv(){	
		
		ArrayList list=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from Universite ");
		
                       
			   for(int i=0;i<query.list().size();i++)
                           { Universite u=(Universite) query.list().get(i);
                               list.add(u.getLibUniv());
                           
                           }
		//list= (ArrayList) query.list();
		   for(int i=0;i<list.size();i++)
                   {
                       System.out.println(list.get(i));
                   }
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			
			return list;
			}
    public Universite findUniversiteByEtablissement(Etablissement etab)
    {
         Universite st=null;
        Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("from  Universite where  CodeUniv=:codest ");
		query.setParameter("codest", etab.getUniversite().getCodeUniv());
                

                       
			      st=(Universite) query.uniqueResult();
                          
                     //  System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
       return st;
    }
    
}
