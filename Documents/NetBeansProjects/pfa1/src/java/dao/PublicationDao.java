/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import modele.Auteur;
import modele.Chercheur;
import modele.Ecrire;
import modele.Editeur;
import modele.HibernateUtil;
import modele.Publication;
import modele.Structurerecherche;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */
public class PublicationDao {
    
    
    
     public Publication insert( String titre, Integer annee, Integer mois, String note, String cle, String howpub, String adresse, String journal, Integer pagedeb, Integer pagefin, Integer volume, Integer nombre, String edition, String chapitre, String serie, String booktitle, String organisation, String type, String etablissement, String typeRapport )
	{  
            Publication p=new Publication(titre, annee, mois, note, cle, howpub, adresse, journal, pagedeb, pagefin, volume, nombre, edition, chapitre, serie, booktitle, organisation, type, etablissement, typeRapport, null);
        
            
	 Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try{
	transaction = session.beginTransaction();
       
           
	session.save(p);
            
	transaction.commit();
	System.out.println("Data Saved");
        return p;
	}catch(Exception e)
	{e.printStackTrace(); return null;}
	
	}
        
  public boolean ExistePublication(String titre){	
		
		ArrayList list=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Publication ");
		
                       
			    list= (ArrayList) query.list();
                            
                        BigInteger bigInt = null;
                        BigInteger bigp = null;
      
           titre= titre.replaceAll(" ", "");
      titre=  titre.toLowerCase();
          MessageDigest m = MessageDigest.getInstance("MD5");
          m.reset();
          
          m.update(titre.getBytes());
          byte[] digest = m.digest();
         bigInt = new BigInteger(1,digest);
         int i=0;
         while(i<list.size())
         { Publication p=(Publication)list.get(i);
         String t=p.getTitre();
         t= t.replaceAll(" ", "");
      t=  t.toLowerCase();
              m.update((t).getBytes());
          byte[] digestp = m.digest();
         bigp = new BigInteger(1,digestp);
         if(bigp.equals(bigInt))
             return true;
         i++;
         }
                           return false;
         
      } catch (NoSuchAlgorithmException ex) {
          System.out.println("erreur hashage"+ ex);
          return true;
      }       
                         
			
			catch(Exception e)
			{e.printStackTrace(); return true;}
			finally{session.close();}
			
			
			}  
  
  public ArrayList top10Publication(Structurerecherche s){	
		
		ArrayList list=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from Publication\n" +
"where IdPub in(\n" +
"select IdPub from Ecrire \n" +
"where IdAut in (select IdAut from  Auteur\n" +
"where IdAut in(\n" +
"select IdAut from Chercheur c \n" +
"where Idch=10)))\n" +
"order by annee desc \n" +
"limit 3;");
		
                     //  query.setString("code", s.getCode());
			    list= (ArrayList) query.list();
                            
                       
         
                          
         
                        }
                         
			
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
  return list;			
			
			}  
    
  public ArrayList top10PublicationLabo(Structurerecherche st){
      ArrayList res=new ArrayList();
         Set lch=st.getChercheurs();
         Object[] tch = lch.toArray();
       for(int i=0;i<lch.size();i++)
            {
               if(((Chercheur)tch[i]).getAuteurs().toArray().length!=0)
               { System.out.println("chercheur "+((Chercheur)tch[i]).getAuteurs());
               Object[] aut=((Chercheur)tch[i]).getAuteurs().toArray();
                   System.out.println("au "+((Auteur)aut[0]).getEcrires());
                   Object [] ecr=((Auteur)aut[0]).getEcrires().toArray();
                   for(int j=0;j<ecr.length;j++)
                       System.out.println("titre " +((Ecrire)ecr[j]).getPublication().getTitre());
               }
            }
      
      return res;
  }	
   
  
  public ArrayList top10()
  {
     ArrayList list=new ArrayList();
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from  Publication  order by annee desc ");
		
                       
			    list= (ArrayList) query.list();
                        }catch(Exception e)
			{e.printStackTrace(); }
			finally{
                           // session.close();
                        }
			
			return list;
                        
  }
  
}
