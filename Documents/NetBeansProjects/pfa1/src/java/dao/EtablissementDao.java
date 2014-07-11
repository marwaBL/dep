/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modele.Chercheur;
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
public class EtablissementDao {
    private ArrayList etab=new ArrayList();
     public ArrayList listEtablissement(String univlib){	
		
		ArrayList list=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Universite  where LibUniv =:lib ");
		query.setParameter("lib", univlib);
                       
			    Universite u=(Universite) query.uniqueResult();
                             Object[] le=u.getEtablissements().toArray();
                             
                              for (int i=0;i<le.length;i++)
                              {
                                 etab.add((Etablissement)le[i]);
                                  list.add(((Etablissement)le[i]).getLibEtab());
                           
                           }
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
    public Etablissement codeetab (String lib)
    {
        int i=0;
        while(i<etab.size())
        {
            if(((Etablissement)etab.get(i)).getLibEtab().equals(lib))
                return ((Etablissement)etab.get(i));
            i++;
        }
        
        return null;
    }
    public ArrayList listetablissement()
    {
        ArrayList list=new ArrayList();
        ArrayList listinter=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from Etablissement  ");
		
			 
                           Object[]le= query.list().toArray();
                             
                              for (int i=0;i<query.list().size();i++)
                              {
                                 
                                  list.add(((Etablissement)le[i]).getLibEtab());
                           
                           }
		//list= (ArrayList) query.list();
		  /* for(int i=0;i<list.size();i++)
                   {
                       System.out.println(list.get(i));
                   }*/
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			
			return list;
			
    }
    public Etablissement findEtablissementByStructure(Structurerecherche ch)
   {
       Etablissement st=null;
        Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("from  Etablissement  where  CodeEtab=:codest ");
		query.setParameter("codest", ch.getEtablissement().getCodeEtab());
                

                       
			      st=(Etablissement) query.uniqueResult();
                      // System.out.println("code st "+ch.getEtablissement().getCodeEtab());     
                       //System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
       return st;
   }
    
     public Etablissement findEtablissementByFonction(Chercheur ch)
   {
       Etablissement st=null;
       if(ch.getEtablissementByEtaCodeEtab2()==null)
           return null;
        Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("from  Etablissement  where  CodeEtab=:codest ");
		query.setParameter("codest", ch.getEtablissementByEtaCodeEtab2().getCodeEtab());
                

                       
			      st=(Etablissement) query.uniqueResult();
                      // System.out.println("code st "+ch.getEtablissement().getCodeEtab());     
                       //System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
       return st;
   }
    public Etablissement findEtablissementByGrade(Chercheur ch)
   {
       Etablissement st=null;
       if(ch.getEtablissementByEtaCodeEtab()==null)
           return null;
        Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("from  Etablissement  where  CodeEtab=:codest ");
		query.setParameter("codest", ch.getEtablissementByEtaCodeEtab().getCodeEtab());
                

                       
			      st=(Etablissement) query.uniqueResult();
                      // System.out.println("code st "+ch.getEtablissement().getCodeEtab());     
                       //System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
       return st;
   }
    
     public Etablissement findEtablissementByInscription(Chercheur ch)
   {
       Etablissement st=null;
       if(ch.getEtablissementByCodeEtab()==null)
           return null;
        Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("from  Etablissement  where  CodeEtab=:codest ");
		query.setParameter("codest", ch.getEtablissementByCodeEtab().getCodeEtab());
                

                       
			      st=(Etablissement) query.uniqueResult();
                      // System.out.println("code st "+ch.getEtablissement().getCodeEtab());     
                       //System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
       return st;
   }
     
}
