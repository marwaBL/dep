/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChercheurDao;
import dao.InscriptionDao;
import dao.StructureRechercheDao;
import dao.UserDao;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import modele.User;
import java.util.ArrayList;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;
import modele.Chercheur;
import modele.Structurerecherche;
import modele.UserId;
import org.hibernate.validator.constraints.Email;
import org.primefaces.context.RequestContext;
import util.SendMailtls;

/**
 *
 * @author USER1
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    /**
     * Creates a new instance of UserController
     */
    private String type;
    private String identifiant;
    private String passwrd;
    private String passwrd2;
         private UserDao user;
    	private UserId id;
	private  String login;
	private  String password;
        private String nom;
        private String prenom;
        private String cin;
        private String structure;
        private String denomination;
         ArrayList l;
       private  boolean isloggedin;
         boolean conforme=true;
        private StructureRechercheDao stdao =new StructureRechercheDao() ;
         private ArrayList listdenomination;
	 @Email(message = "must be a valid email")  
    private String email;  
static User u;
    public String getType() {
        return type;
    }

    public boolean isIsloggedin() {
        return isloggedin;
    }

    public void setIsloggedin(boolean isloggedin) {
        this.isloggedin = isloggedin;
    }

    
    
    
    public void setType(String type) {
        this.type = type;
    }

    
         
         
         
         
         
    public UserController() {
        //listdenomination=new ArrayList();
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public String getPasswrd2() {
        return passwrd2;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public void setPasswrd2(String passwrd2) {
        this.passwrd2 = passwrd2;
    }

    
    
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }

    public UserDao getUser() {
        return user;
    }

    public UserId getId() {
        return id;
    }

    public  String getLogin() {
        return login;
    }

    public  String getPassword() {
        return password;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public ArrayList getListdenomination() {
        return listdenomination;
    }

    public void setListdenomination(ArrayList listdenomination) {
        this.listdenomination = listdenomination;
    }

    
    
    
    
    
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    
    public String dologin() {
       
            user=new UserDao();
      RequestContext context = RequestContext.getCurrentInstance();  
    FacesMessage msg = null;  
    boolean loggedIn = false;  
String pageresult="";
User  us=user.find(login,password);
            if (us!=null)
                    {System.out.println("connexteeeeeeee : ");
                    loggedIn = true;  
                   //  msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", login); 
                    u=us;
                        System.out.println("user "+ u.getType());
                     if(us.getType().equals("Chercheur"))
                     {
                        /* try{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/pfa1/faces/profilChercheur.xhtml");
                     }catch(Exception e)
                     {
                      System.out.println("erreur navigation");
                     }*/
                           pageresult="/accueilch";
                           isloggedin=true;
                        /*  FacesContext facesContext = FacesContext.getCurrentInstance();
                          HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true); 
                          session.setAttribute("user", us); */
                     }
                  
                     else{
                     if(us.getType().equals("Administrateur Laboratoire"))
                           pageresult="/accueiladl";
                     else
                         pageresult="/accueilads";
                     }
                    }
            else
            {
                System.out.println("non connexteeeeeeee : ");
            loggedIn = false;  
        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur d'authentification", "Login et/ou password invalide");
             pageresult= "/erreur";
              FacesContext.getCurrentInstance().addMessage(null, msg);  
    context.addCallbackParam("loggedIn", loggedIn); 

            }
       /* FacesContext.getCurrentInstance().getExternalContext().redirect("page1.xhtml");    
          
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
              return pageresult;
	}
 public String creercompte()
 { 
    
     ChercheurDao chdao= new ChercheurDao();
     	user=new UserDao();
	  RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null; 
         boolean loggedIn = false; 
       String pageresult="";
       System.out.println("pass 1 "+passwrd+"2"+passwrd2);
       System.out.println("conf "+conforme);
       if(!conforme)
       {
           
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur ", "password non comformes");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
       }
              /*  if(!passwrd.equals(passwrd2)||password.equals("")||passwrd2.equals(""))
                {
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur ", "password non comformes");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
                }*/
                else
                {User  us=user.find(identifiant,passwrd2);
                  if (us!=null)
			{System.out.println("existe deja : ");
			 msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur ", "Utilisateur existe déjà");
		// pageresult= "/erreur";
                        
                             
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
                        }
		else
		{
                    try{
                    UIComponent component=null;
                         EmailValidator em= new EmailValidator();
                              em.validate( FacesContext.getCurrentInstance(),  component, email) ;  

                    //System.out.println(" : ");
		loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Félicitation", "Vous etes enregistré vous pouvez vous connecté");
		// pageresult= "/erreur";
                        System.out.println("den: "+denomination);
                        Structurerecherche s=findstructure();
                        if(s!=null)
                         System.out.println("st:"+s);   
           User ures= user.insert(identifiant, passwrd2,"Chercheur");
          Chercheur nouvch=chdao.insertIncomplet(s,  nom, prenom, cin, email,ures);
                        InscriptionDao insdao= new InscriptionDao() ;
                        insdao.insert(s,"non valide", nouvch);
            Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
flash.setKeepMessages(true);
flash.setRedirect(true);
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
        pageresult="succes";
     String    msgg = "ffffffffffffffffff";
        String   dest = "marwaboulakbech@gmail.com";
         String  obj = "Inscription";
         String  sender = "marwa-boulakbech@hotmail.fr";
         SendMailtls.sendmail(msgg, dest,  obj, sender);
                    }catch(ValidatorException e)
                    {
                       loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur validation", "Email invalide");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
                    }
                }
                
		
       
                }
		
     
     //System.out.println("vvvvvvvvvvvv");
     return pageresult;
 }
 
 
 
 public String compte()
 { System.out.println("compte");
     return "compte";
 }
  public void chooseCar() {  
            RequestContext.getCurrentInstance().execute("validation");  
        } 
  public Structurerecherche findstructure()
  {
      for(int i=0;i<l.size();i++)
      {
          if(((Structurerecherche)l.get(i)).getDenomination().equals(denomination))
              return((Structurerecherche)l.get(i));
      }
      return null;
  }
   public String findStructureByType()
    {
        if(!structure.equals(""))
        {
      l= stdao.findStructureByType(structure);
         System.out.println(l);
         listdenomination=new ArrayList();
         for(int i=0;i<l.size();i++)
         {
             listdenomination.add(((Structurerecherche)l.get(i)).getDenomination());
         }
       //listdenomination=l;
        }
        else
        {
            listdenomination=new ArrayList();
        }
        
        return "";
    }
  public void confirmerMP()
  {  RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null; 
        boolean loggedIn = false; 
        System.out.println(" pass1 pass2 "+passwrd+passwrd2);
       if(!passwrd.equals(passwrd2))
                {
                    conforme=false;
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur ", "mot de passe non comformes");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
                }
       else
       { conforme=true;
           System.out.println("confMP "+conforme);}
  }
  
    public String logout() {
   System.out.println("logout appelé");
   isloggedin=false;
   FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  
   return "logout";
  }  
  
  
  
  
}
