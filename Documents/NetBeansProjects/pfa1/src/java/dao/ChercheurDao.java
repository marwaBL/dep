/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import modele.Chercheur;
import modele.Etablissement;
import modele.HibernateUtil;
import modele.Structurerecherche;
import modele.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */

public class ChercheurDao {
    
    
    
    
    
  public Chercheur findChercheurbyNomPrenom (String nom,String prenom)
  {
      Chercheur ch=null;
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction(); 
			Query query = session.createQuery("from  Chercheur  where  NomCH=:nomch  and PrenomCh=:prenomch");
		query.setParameter("nomch", nom);
                query.setParameter("prenomch", prenom);
                       
			      ch=(Chercheur) query.uniqueResult();
                            
                       System.out.println(ch);
                   
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			
			return ch;
  }
  
  public Chercheur insert(Chercheur direc,Structurerecherche structure,Etablissement etabf,Etablissement etabg,Etablissement etabi, String nom,String prenom,Date datenais,String lieunais,String sexe,String nomjf,String cin,String passport,String tel,String mail,String grade,String type,String sujet,int avance,String fonction,int anneeinscr,String etat,User us)
	{ Chercheur u=new Chercheur();
            System.out.println("fonction "+etabf); 
	// u.setUserId(5);
	 u.setAnnee(anneeinscr);
         u.setAvancement(avance);
        u.setChercheur(direc);
        u.setCinCh(cin);
        u.setDateNaisCh(datenais);
        u.setEmailCh(mail);
        u.setEtat(etat);
       
        /////etabfonction
        u.setEtablissementByEtaCodeEtab2(etabf);
       //etabinscription
        u.setEtablissementByCodeEtab(etabi);
       u.setPhoto("C:/Users/USER1/Desktop/images/profil.png");
       ////etabgrade
        u.setEtablissementByEtaCodeEtab(etabg);
        u.setFonctionCh(fonction);
        u.setGradeCh(grade);
        u.setLieuNaisCh(lieunais);
        u.setNomCh(nom);
        u.setNomJfch(nomjf);
        u.setPassCh(passport);
        u.setPrenomCh(prenom);
        u.setSexeCh(sexe);
        u.setStructurerecherche(structure);
        u.setSujetRechCh(sujet);
        u.setTelCh(tel);
        u.setTypeCh(type);
	u.setUser(us);
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
	session.save(u);
        
	transaction.commit();
	System.out.println("Data Saved");
        return u;
	}catch(Exception e)
	{e.printStackTrace();}
	return null;
	}
  
  public Chercheur insertIncomplet(Structurerecherche structure, String nom,String prenom,String cin,String mail,User us)
	{ Chercheur u=new Chercheur();
            
        u.setCinCh(cin);
       
        u.setEmailCh(mail);
        u.setEtat("non valide");
       
       
       u.setPhoto("C:/Users/USER1/Desktop/images/profil.png");
      
        u.setNomCh(nom);
       
        u.setPrenomCh(prenom);
       
        u.setStructurerecherche(structure);
       
        
	u.setUser(us);
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
	session.save(u);
        
	transaction.commit();
	System.out.println("Data Saved");
        return u;
	}catch(Exception e)
	{e.printStackTrace();}
	return null;
	}
  
  
public void updatephoto (Chercheur ch,String path)
{
   
  Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                ch.setPhoto(path);
			session.update(ch);
        
	transaction.commit();
	System.out.println("Data updated");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  
   
       
  
}
  public void valideChercheur(Chercheur ch)
  {
      Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                ch.setEtat("valide");
			session.update(ch);
        
	transaction.commit();
	System.out.println("Data updated");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  }
   public void RefuseChercheur(Chercheur ch)
  {
      Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
               // ch.setEtat("valide");
			//session.update(ch);
                session.delete(ch);
        
	transaction.commit();
	System.out.println("Data deleted");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  }
  
   public void valideToutChercheur(ArrayList lch)
  {
      Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                for(int i=0;i<lch.size();i++)
                {((Chercheur)lch.get(i)).setEtat("valide");
			session.update((Chercheur)lch.get(i));
                }
	transaction.commit();
	System.out.println("Data updated");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  }
   public Chercheur findChercheurByUser(User u)
   {
        Session session =  HibernateUtil.getSessionFactory().openSession();
		Chercheur ch=null;
			try	{
		Transaction	transaction = session.beginTransaction();
               
        Query query = session.createQuery("from  Chercheur  where  login=:nomch  and passwd=:prenomch");
		query.setParameter("nomch", u.getId().getLogin());
                query.setParameter("prenomch", u.getId().getPasswd());
                       
			      ch=(Chercheur) query.uniqueResult();
                            
                       System.out.println(ch);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
       return ch;
   }
   
   public Structurerecherche findstructureBychercheur(Chercheur ch)
   {
       Structurerecherche st=null;
        Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("from  Structurerecherche  where  code=:codest ");
		query.setParameter("codest", ch.getStructurerecherche().getCode());
                

                       
			      st=(Structurerecherche) query.uniqueResult();
                 //      System.out.println("code st "+ch.getStructurerecherche().getCode());     
                   //    System.out.println(st);
	           System.out.println("liste ch "+st.getChercheurs());
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			//finally{session.close();
        //}
       return st;
   }
   
  
  public boolean findChercheurAdministrateur (Chercheur ch,Structurerecherche s)
  {
     Structurerecherche st=null;
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction(); 
			Query query = session.createQuery("from  Structurerecherche  where  code=:codest");
		query.setParameter("codest", s.getCode());
               
                       
			      st=(Structurerecherche) query.uniqueResult();
                            
                       System.out.println(st);
                   if((st.getChercheur()).getIdCh().equals(ch.getIdCh()))
                       return true;
                   else
                       return false;
			}
                        
			catch(Exception e)
			{e.printStackTrace();return false;}
			finally{session.close();}
			
			
  } 
  
  
  public Chercheur update(Chercheur direc,Etablissement etabf,Etablissement etabg,Etablissement etabi, String nom,String prenom,Date datenais,String lieunais,String sexe,String nomjf,String cin,String passport,String tel,String mail,String grade,String type,String sujet,int avance,String fonction,int anneeinscr,Chercheur ch)
	{ Chercheur u=new Chercheur();
            System.out.println("nom prenom  cher"+nom +prenom +ch.getCinCh()); 
	// ch.setUserId(5);
	 ch.setAnnee(anneeinscr);
         u.setAvancement(avance);
        ch.setChercheur(direc);
        ch.setCinCh(cin);
        ch.setDateNaisCh(datenais);
        ch.setEmailCh(mail);
       
       
        /////etabfonction
        ch.setEtablissementByEtaCodeEtab2(etabf);
       //etabinscription
        u.setEtablissementByCodeEtab(etabi);
      // u.setPhoto("C:/Users/USER1/Desktop/images/profil.png");
       ////etabgrade
        ch.setEtablissementByEtaCodeEtab(etabg);
        ch.setFonctionCh(fonction);
        ch.setGradeCh(grade);
        ch.setLieuNaisCh(lieunais);
        ch.setNomCh(nom);
        ch.setNomJfch(nomjf);
        ch.setPassCh(passport);
        ch.setPrenomCh(prenom);
        ch.setSexeCh(sexe);
       
        ch.setSujetRechCh(sujet);
        ch.setTelCh(tel);
        ch.setTypeCh(type);
	
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
	session.update(ch);
        
	transaction.commit();
	System.out.println("Data Saved");
        return u;
	}catch(Exception e)
	{e.printStackTrace();}
	return null;
	}
   public ArrayList listEncadrementMaster(Chercheur ch)
   { ArrayList l =null;
         Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("from  Chercheur  where  Che_IdCh=:id and TypeCh=:type ");
		query.setParameter("id", ch.getIdCh());
                query.setParameter("type", "Etudiant en Master");
                

                       
			      l=(ArrayList) query.list();
                 //      System.out.println("code st "+ch.getStructurerecherche().getCode());     
                   //    System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
        return  l;
   }
   
    public void updateEtudiantMaster(Chercheur ch)
  {
      Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                
			session.update(ch);
        
	transaction.commit();
	System.out.println("Data updated");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  }
    
   
    
    public ArrayList listEncadrementThese(Chercheur ch)
   { ArrayList l =null;
         Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("from  Chercheur  where  Che_IdCh=:id and TypeCh=:type ");
		query.setParameter("id", ch.getIdCh());
                query.setParameter("type", "Doctorant");
                

                       
			      l=(ArrayList) query.list();
                 //      System.out.println("code st "+ch.getStructurerecherche().getCode());     
                   //    System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
        return  l;
   }
   
    public void updateDoctorant(Chercheur ch)
  {
      Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
                
			session.update(ch);
        
	transaction.commit();
	System.out.println("Data updated");
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  }
    
    
    
    public int nbdemande (Chercheur ch)
    {int nb=0;
           Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery("select count (*) from  Inscription  where  code=:id and etat=:type ");
		query.setParameter("id", ch.getStructurerecherche().getCode());
                query.setParameter("type", "non valide");
                

                       
			 nb=Integer.parseInt(query.uniqueResult().toString());
                 //      System.out.println("code st "+ch.getStructurerecherche().getCode());     
                   //    System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
        
        return nb;
    }
    
     public ArrayList listdemande (Chercheur ch)
    {ArrayList l= new ArrayList ();
  //  ArrayList res=new ArrayList();
           Session session =  HibernateUtil.getSessionFactory().openSession();
        try{
		 Query query = session.createQuery(" from  Chercheur  where  code=:id and etat=:type ");
		query.setParameter("id", ch.getStructurerecherche().getCode());
                query.setParameter("type", "non valide");
              l=  (ArrayList) query.list();
                   
                       
			 
                 //      System.out.println("code st "+ch.getStructurerecherche().getCode());     
                   //    System.out.println(st);
	
			}
                        
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
        
        return l;
    }
            
   
}
