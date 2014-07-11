/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Date;
import modele.Chercheur;
import modele.Etablissement;
import modele.HibernateUtil;
import modele.Structurerecherche;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */
public class StructureRechercheDao {
    private String responsable;
    private String liuniv;
    private String libetab;

    public String getResponsable() {
        return responsable;
    }

    public String getLiuniv() {
        return liuniv;
    }

    public String getLibetab() {
        return libetab;
    }
    
    public void insert(String code,String denomination,String type,String discipline,String site,Chercheur ch,Etablissement etab)
	{ Structurerecherche st = new Structurerecherche();
           
	st.setType(type);
        st.setChercheur(ch);
        st.setCode(code);
        st.setDateDeb(new Date());
        st.setDateFin(new Date());
        st.setDenomination(denomination);
        st.setDiscipline(discipline);
        st.setEtablissement(etab);
        st.setSite(site);
        
	
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
	session.save(st);
	transaction.commit();
	System.out.println("Data Saved");
	}catch(Exception e)
	{e.printStackTrace();}
	
	}
    
    
     public Structurerecherche find (String denomination,String type)
	{ 
        
	Structurerecherche st=null;
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
        Query query = session.createQuery("from  Structurerecherche  where  Denomination=:deno  and Type=:type");
		query.setParameter("deno", denomination);
                query.setParameter("type", type);
                       //System.out.println("type "+type);
                       //System.out.println("type "+denomination);
			      st=(Structurerecherche) query.uniqueResult();
                             /*   System.out.println(st.getDenomination());*/
                              if(st!=null)
                              { responsable=st.getChercheur().getPrenomCh()+" "+st.getChercheur().getNomCh();
                       libetab=st.getEtablissement().getLibEtab();
                       liuniv=st.getEtablissement().getUniversite().getLibUniv();
                              }
                         
	
	return st;
	}catch(Exception e)
	{e.printStackTrace();
        return null;
        }

	}
     public ArrayList findStructureByType (String type)
	{ 
        
	ArrayList  st=new ArrayList();
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
        Query query = session.createQuery("from  Structurerecherche  where  Type=:type");
		
                query.setParameter("type", type);
                       //System.out.println("type "+type);
                       //System.out.println("type "+denomination);
			      st= (ArrayList<Structurerecherche>) query.list();
                             /*   System.out.println(st.getDenomination());*/
                       
                              ArrayList l=new ArrayList();
                              
                              for(int i=0;i<st.size();i++)
                         {
                             Structurerecherche s=(Structurerecherche)st.get(i);
                             l.add(s.getDenomination());
                         }
                         
	
	return st;
	}catch(Exception e)
	{e.printStackTrace();
        return null;
        }

	}
     
     public Chercheur findDirecteurStructure(Structurerecherche st)
     {
         Chercheur ch=null;
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
        Query query = session.createQuery("from  Chercheur  where IdCh=:chno ");
		query.setParameter("chno", st.getChercheur().getIdCh());
               
                       //System.out.println("type "+type);
                       //System.out.println("type "+denomination);
			      ch=(Chercheur) query.uniqueResult();
                             /*   System.out.println(st.getDenomination());*/
                             
                         
	
	return ch;
	}catch(Exception e)
	{e.printStackTrace();
        return null;
        }
     }
    
}
