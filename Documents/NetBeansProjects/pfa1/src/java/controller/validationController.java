/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChercheurDao;
import dao.InscriptionDao;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import modele.Chercheur;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author USER1
 */
@Named(value = "validationController")
@SessionScoped
public class validationController implements Serializable {

   private  ArrayList <Chercheur>  listins = new ArrayList <Chercheur>();
   private  modeleController vm ;
   private Chercheur chselected;
   private String nom;
    private Chercheur chselected2;
  ArrayList listnomprenom= new ArrayList();
private StreamedContent image;
private boolean disable=false;
String code;
    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }





    public StreamedContent getImage() {
      
     FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
    return new DefaultStreamedContent();
}
       
byte[] bytes=new byte[1024];
if(chselected!=null){
        try {FileInputStream fis = new FileInputStream(new File(chselected.getPhoto()));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);     
           //  System.out.println("read " + readNum + " bytes,");

            }
 bytes = bos.toByteArray();
        } catch (IOException ex) {

        }

}

    /*   String path=fc.getExternalContext().getRequestParameterMap().get("photo");
       byte[]photodata=org.apache.commons.io.FileUtils.readFileToByteArray(new File(path));*/
       return new DefaultStreamedContent(new ByteArrayInputStream(bytes));
        
        
    }

    public void setImage(StreamedContent image) {
        this.image = image;
    }
public void valider()
{ if(chselected!=null)
   { System.out.println("selection");
       ChercheurDao chdao= new ChercheurDao();
    chdao.valideChercheur(chselected);
    InscriptionDao insdao=new InscriptionDao();
    insdao.valideInscription(chselected, chselected.getStructurerecherche());
   }
else
    
{
    System.out.println("null");
     FacesMessage msg = null; 
         boolean loggedIn = false; 
          RequestContext context = RequestContext.getCurrentInstance();  
     msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur ", "Probleme");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
                      
}
}

public void refuser()
{
    if(chselected!=null)
   { System.out.println("selection pour refuser");
       ChercheurDao chdao= new ChercheurDao();
    //chdao.valideChercheur(chselected);
      
    InscriptionDao insdao=new InscriptionDao();
    insdao.refuseInscription(chselected, chselected.getStructurerecherche());
     chdao.RefuseChercheur(chselected);
   // insdao.valideInscription(chselected, chselected.getStructurerecherche());
   }
else
    
{
    System.out.println("null");
     FacesMessage msg = null; 
         boolean loggedIn = false; 
          RequestContext context = RequestContext.getCurrentInstance();  
     msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur ", "Probleme");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
                      
}
}
public void toutvalider()
{
    ChercheurDao chdao= new ChercheurDao();
    chdao.valideToutChercheur(listins);
    InscriptionDao insdao=new InscriptionDao();
    insdao.valideToutInscription(listins);
    FacesMessage msg = null; 
         boolean loggedIn = false; 
          RequestContext context = RequestContext.getCurrentInstance();  
     msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Validation ", "Toutes les demandes sont validées");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
        //listins.clear();
}






    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  
  
  
  
    public Chercheur getChselected2() {
        return chselected2;
    }

    public void setChselected2(Chercheur chselected2) {
        this.chselected2 = chselected2;
    }

  
  
  
  
  
  
    public Chercheur getChselected() {
        return chselected;
    }

    public void setChselected(Chercheur chselected) {
        this.chselected = chselected;
    }

    public modeleController getVm() {
        return vm;
    }

    public void setVm(modeleController vm) {
        this.vm = vm;
    }

  
  
  
  
  
  
    public ArrayList getListins() {
        return listins;
    }

    public ArrayList getListnomprenom() {
       
        
        return listnomprenom;
    }

    public void setListins(ArrayList listins) {
        this.listins = listins;
    }

    public void setListnomprenom(ArrayList listnomprenom) {
        this.listnomprenom = listnomprenom;
    }
    
  
  
  
  
  
    public void listinscription()
    { 
          InscriptionDao insdao= new InscriptionDao();
      listins=insdao.findInscriptionNonvalide(code);
   listnomprenom= insdao.getListnomprenom();
    }
    public void testselected()
    {
        setChselected2(chselected);
        nom=chselected.getNomCh();
        System.out.println("selected "+ chselected.getNomCh());
    }
    public validationController() {
      code= ProfilController.ch.getStructurerecherche().getCode();
        System.out.println("structure "+ProfilController.ch.getStructurerecherche().getDenomination());
         InscriptionDao insdao= new InscriptionDao();
         System.out.println("code "+code);
      listins=insdao.findInscriptionNonvalide(code);
        System.out.println("list "+listins);
   listnomprenom= insdao.getListnomprenom();
  //      System.out.println("list "+listnomprenom);
         vm = new modeleController(listins);
       }
    public void update()
    {
        listins.remove(chselected);
    }
    
     public void updatetout()
    {
         FacesMessage msg = null; 
         boolean loggedIn = false; 
          RequestContext context = RequestContext.getCurrentInstance();  
     msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Validation ", "Toutes les demandes sont validées");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
       // listins.clear();
        
    }
    
}
