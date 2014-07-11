/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.UserController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modele.HibernateUtil;
import modele.User;
import modele.UserId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER1
 */

public class UserDao  {
   private  User us;

    public User getUs() {
        return us;
    }

    public void setUs(User us) {
        this.us = us;
    }
    
    
    
    
    
    public User find(String log,String pw){	
		
		 User u=null;
		 Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from User where login = :login and passwd = :password");
		
                        query.setParameter("login", log);
			query.setParameter("password",pw );
			                        
		 u =(User) query.uniqueResult();
		   
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally{session.close();}
			
			return u;
			}
    /*public String dispatcher(User u)
    {
        if(u==null)
        {
            return "";
            
        }
        else
        { Session session =  HibernateUtil.getSessionFactory().openSession();
			User us=(User) session.get(User.class, 1);
            
            if(u.getType().equals("Chercheur"))
                return "accueilch";
        }
    }*/
     public ArrayList recentUser()
     {
         ArrayList listuser=new ArrayList ();
          Session session =  HibernateUtil.getSessionFactory().openSession();
			 
			try	{
		Transaction	transaction = session.beginTransaction();
			Query query = session.createQuery("from User order by dateinscription desc");
                    listuser=    (ArrayList) query.list();
                            System.out.println(" liste dao "+ listuser);
                        
		}
			catch(Exception e)
			{e.printStackTrace();}
			
                        return  listuser;
                        
         
     }
    public User insert(String identifiant,String password,String type)
	{ User u = new User();
            UserId id=new UserId();
            id.setPasswd(password);
            id.setLogin(identifiant);
	// u.setUserId(5);
	 u.setId(id);
         u.setType(type);
         u.setDateinscription(new Date());
	System.out.println(identifiant);
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
	return u;
	}

}
