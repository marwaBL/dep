/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChercheurDao;
import dao.EtablissementDao;
import dao.StructureRechercheDao;
import dao.UniversiteDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;

/**
 *
 * @author USER1
 */
@Named(value = "structureRechercheController")
@SessionScoped
public class StructureRechercheController implements Serializable {
  
    private ArrayList universites;
    private ArrayList etablissements;
    private  UniversiteDao univdao =new UniversiteDao();
    private EtablissementDao etabdao= new EtablissementDao();
     private ChercheurDao chdao= new ChercheurDao();
private String univlib;
private String etablib;
private String responsable;
private String denomination;
private String type;
private String code;
private String discipline;
private String site;
private String email;

    /**
     * Creates a new instance of StructureRechercheController
     */
    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }





    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    public String getEtablib() {
        return etablib;
    }

    public void setEtablib(String etablib) {
        this.etablib = etablib;
    }

    public ChercheurDao getChdao() {
        return chdao;
    }

    public void setChdao(ChercheurDao chdao) {
        this.chdao = chdao;
    }




    public ArrayList getEtablissements() {
        return etablissements;
    }

    public String getUnivlib() {
        return univlib;
    }

    public void setEtablissements(ArrayList etablissements) {
        this.etablissements = etablissements;
    }

    public void setUnivlib(String univlib) {
        this.univlib = univlib;
    }



    public EtablissementDao getEtabdao() {
        return etabdao;
    }

    public void setEtabdao(EtablissementDao etabdao) {
        this.etabdao = etabdao;
    }



   
    



    public ArrayList getUniversites() {
        return universites;
    }

    public UniversiteDao getUnivdao() {
        return univdao;
    }

    public void setUniversites(ArrayList universites) {
        this.universites = universites;
    }

    public void setUnivdao(UniversiteDao univdao) {
        this.univdao = univdao;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    
    
    
    
    public StructureRechercheController() 
    {
       universites= univdao.listUniv();
        
    }
    
    
    public String findEtablissementByCodeUniv()
    {
        if(!univlib.equals("Université"))
        {
         ArrayList l= etabdao.listEtablissement(univlib);
         System.out.println(l);
         etablissements=l;
        }
        else
        {
            etablissements=new ArrayList();
        }
        
        return "";
    }
     public String ajoutStructure()
     { boolean loggedIn = false; 
     FacesMessage msg = null;  
      RequestContext context = RequestContext.getCurrentInstance();  
        
     
       
         System.out.println("code "+etabdao.codeetab(etablib));
            if(type.equals("Unité")&& !code.startsWith("U")) 
        {
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "code invalide", "code invalide");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
      return "";
        }
         if(type.equals("Labo")&& !code.startsWith("L")) 
        {
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "code invalide", "code invalide");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
      return "";
        }
          try{
                    UIComponent component=null;
         EmailValidator em= new EmailValidator();
                              em.validate( FacesContext.getCurrentInstance(),  component, email) ;  
}catch(ValidatorException e)
                    {
                       loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Email invalide", "Email invalide");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
        return "";
                    }
         StringTokenizer st=new StringTokenizer(responsable," ");
     try{
         String nom=  st.nextToken();
      String prenom =st.nextToken();
    
      if(chdao.findChercheurbyNomPrenom(nom, prenom)==null)
      {
          System.out.println("nom "+nom);
          loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Responsable inexistant", "Responsable inexistant");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
      }
      else
      {
         StructureRechercheDao stdao=new StructureRechercheDao();
         stdao.insert(code, denomination, type, discipline, site, chdao.findChercheurbyNomPrenom(nom, prenom), etabdao.codeetab(etablib));
      }
      
       }catch(Exception e)
     
      {
          loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Responsable inexistant", "Entrer le nom et prenom du Responsable ");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
      }   
         return "";
     }
    
    
    
}
