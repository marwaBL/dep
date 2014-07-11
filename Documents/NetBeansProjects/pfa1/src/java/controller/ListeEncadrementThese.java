/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChercheurDao;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

/**
 *
 * @author USER1
 */
@Named(value = "listeEncadrementThese")
@SessionScoped
public class ListeEncadrementThese implements Serializable {

    /**
     * Creates a new instance of ListeEncadrementThese
     */
    public ListeEncadrementThese() {
         listeencadmaster= chdao.listEncadrementThese(ProfilController.ch);
                 
                 //chdao.listEncadrementMaster(ProfilController.ch);
         remplirListImage();
    }
  private StreamedContent image;
    ArrayList listeencadmaster=new ArrayList();
    ChercheurDao chdao= new ChercheurDao();
Chercheur chselected;
    ArrayList listimage =new ArrayList();

    public ArrayList getListimage() {
        return listimage;
    }

    public void setListimage(ArrayList listimage) {
        this.listimage = listimage;
    }
    
    
    
    
     public void remplirListImage() {
         FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
   listimage.add(new DefaultStreamedContent());
}
       
byte[] bytes=new byte[1024];
for(int i=0;i<listeencadmaster.size();i++){
        try {FileInputStream fis = new FileInputStream(new File(((Chercheur)listeencadmaster.get(i)).getPhoto()));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);     
           //  System.out.println("read " + readNum + " bytes,");

            }
 bytes = bos.toByteArray();
        } catch (IOException ex) {

        }
         listimage.add( new DefaultStreamedContent(new ByteArrayInputStream(bytes)));
   }

    /*   String path=fc.getExternalContext().getRequestParameterMap().get("photo");
       byte[]photodata=org.apache.commons.io.FileUtils.readFileToByteArray(new File(path));*/
   
        
        
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






    public Chercheur getChselected() {
        return chselected;
    }

    public void setChselected(Chercheur chselected) {
        this.chselected = chselected;
    }





    public ArrayList getListeencadmaster() {
        return listeencadmaster;
    }

    public void setListeencadmaster(ArrayList listeencadmaster) {
        this.listeencadmaster = listeencadmaster;
    }  
    
    public void valider()
{ if(chselected!=null)
   { System.out.println("selection");
  chdao.updateDoctorant(chselected);
  // chdao.updateEtudiantMaster(chselected);
   FacesMessage msg = null; 
         boolean loggedIn = false; 
          RequestContext context = RequestContext.getCurrentInstance();  
     msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chercheur mis à jour ", "Chercheur mis à jour");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
                
   
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
    



}
