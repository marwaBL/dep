/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.Chercheur;
import modele.Etablissement;
import modele.HibernateUtil;
import modele.Inscription;
import modele.InscriptionId;
import modele.Structurerecherche;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */
public class InscriptionDao {
   private  ArrayList listnomprenom= new ArrayList();
     public String insert(Structurerecherche st,String etat,Chercheur ch)
	{Inscription ins = new Inscription();
           
	ins.setEtat(etat);
        ins.setChercheur(ch);
        ins.setStructurerecherche(st);
        ins.setId(new InscriptionId(ch.getIdCh(), st.getCode()));
        
	
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
	session.save(ins);
	transaction.commit();
	System.out.println("Data Saved");
        return "saved";
	}catch(Exception e)
	{e.printStackTrace();}
	return "";
	}
    
    public ArrayList findInscriptionNonvalide (String codest)
    {
        ArrayList list=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Inscription where  code=:codest and etat=:etatst");
		query.setParameter("codest", codest);
                       query.setParameter("etatst", "non valide");
			List lst=  query.list();
                           
                             
                              for (int i=0;i<lst.size();i++)
                              {
                                listnomprenom.add(((Inscription)lst.get(i)).getChercheur().getNomCh()+" "+((Inscription)lst.get(i)).getChercheur().getPrenomCh());
                                  list.add(((Inscription)lst.get(i)).getChercheur());
                           
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

    public ArrayList getListnomprenom() {
        return listnomprenom;
    }
     public void valideInscription(Chercheur ch,Structurerecherche st)
  {
      Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                Inscription ins= new Inscription();
                ins.setChercheur(ch);
                ins.setEtat("valide");
                ins.setStructurerecherche(st);
                ins.setId(new InscriptionId(ch.getIdCh(),  st.getCode()));
			session.update(ins);
        
	transaction.commit();
	System.out.println("Data updated");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  }
     
      public void refuseInscription(Chercheur ch,Structurerecherche st)
  {
      Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                Inscription ins= new Inscription();
                ins.setChercheur(ch);
                //ins.setEtat("valide");
                ins.setStructurerecherche(st);
                ins.setId(new InscriptionId(ch.getIdCh(),  st.getCode()));
			session.delete(ins);
        
	transaction.commit();
	System.out.println("Data updated");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  }
     
     
    public void valideToutInscription(ArrayList lch)
  {
      Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                for(int i=0;i<lch.size();i++)
                {
                    Inscription ins= new Inscription();
                ins.setChercheur((Chercheur)lch.get(i));
                ins.setEtat("valide");
                ins.setStructurerecherche(((Chercheur)lch.get(i)).getStructurerecherche());
                ins.setId(new InscriptionId(((Chercheur)lch.get(i)).getIdCh(),  ((Chercheur)lch.get(i)).getStructurerecherche().getCode()));
			session.update(ins);
                }
	transaction.commit();
	System.out.println("Data updated");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  } 
}
