/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AuteurDao;
import dao.EcrireDao;
import dao.EditeurDao;
import dao.PublicationDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modele.Auteur;
import modele.Editeur;
import modele.Publication;


/**
 *
 * @author USER1
 */
@Named(value = "ajoutPublicationController")
@SessionScoped
public class AjoutPublicationController implements Serializable {

    /**
     * Creates a new instance of AjoutPublication
     */
    
    private String type;
    private ArrayList auteurs;
 private String mois;
 private String nomAuteur;
 private String prenomAuteur;
 private String titre;
 private String annee;
 private String cle;
 private String note;
 private String adresseB;
 private String howpubB;
 private String journal;
 private String pagedebA;
 private String pagefinA;
 private String volumeA;
 private String nombreA;
 private String editionI;
 private String chapitreI;
  private String pagedebI;
 private String pagefinI;
 private String volumeI;
 private String serieI;
 private String adresseI;
 private String booktitleC;
 private String editionC;
  private String pagedebC;
 private String pagefinC;
 private String organisationC;
 private String adresseC;
 private String nomed;
 private String prenomed;
 private ArrayList champssup=new ArrayList();
  private ArrayList champssup1=new ArrayList();
   private ArrayList champssup2=new ArrayList();
 private ArrayList <Auteur> testauteur=new ArrayList<Auteur>();
    AuteurDao autdao =new AuteurDao();
     EditeurDao eddao =new EditeurDao();
     ArrayList led;
    ArrayList l;

    public ArrayList<Auteur> getTestauteur() {
        return testauteur;
    }

    public void setTestauteur(ArrayList<Auteur> testauteur) {
        this.testauteur = testauteur;
    }

    
    
    
    
    public ArrayList getChampssup1() {
        return champssup1;
    }

    public void setChampssup1(ArrayList champssup1) {
        this.champssup1 = champssup1;
    }

    public ArrayList getChampssup2() {
        return champssup2;
    }

    public void setChampssup2(ArrayList champssup2) {
        this.champssup2 = champssup2;
    }

    
    public ArrayList getChampssup() {
        return champssup;
    }

    public void setChampssup(ArrayList champssup) {
        this.champssup = champssup;
    }

    
    
    
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAdresseB() {
        return adresseB;
    }

    public void setAdresseB(String adresseB) {
        this.adresseB = adresseB;
    }

    public String getHowpubB() {
        return howpubB;
    }

    public void setHowpubB(String howpubB) {
        this.howpubB = howpubB;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getPagedebA() {
        return pagedebA;
    }

    public void setPagedebA(String pagedebA) {
        this.pagedebA = pagedebA;
    }

    public String getPagefinA() {
        return pagefinA;
    }

    public void setPagefinA(String pagefinA) {
        this.pagefinA = pagefinA;
    }

    public String getVolumeA() {
        return volumeA;
    }

    public void setVolumeA(String volumeA) {
        this.volumeA = volumeA;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getEditionI() {
        return editionI;
    }

    public void setEditionI(String editionI) {
        this.editionI = editionI;
    }

    public String getChapitreI() {
        return chapitreI;
    }

    public void setChapitreI(String chapitreI) {
        this.chapitreI = chapitreI;
    }

    public String getPagedebI() {
        return pagedebI;
    }

    public void setPagedebI(String pagedebI) {
        this.pagedebI = pagedebI;
    }

    public String getPagefinI() {
        return pagefinI;
    }

    public void setPagefinI(String pagefinI) {
        this.pagefinI = pagefinI;
    }

    public String getVolumeI() {
        return volumeI;
    }

    public void setVolumeI(String volumeI) {
        this.volumeI = volumeI;
    }

    public String getSerieI() {
        return serieI;
    }

    public void setSerieI(String serieI) {
        this.serieI = serieI;
    }

    public String getAdresseI() {
        return adresseI;
    }

    public void setAdresseI(String adresseI) {
        this.adresseI = adresseI;
    }

    public String getBooktitleC() {
        return booktitleC;
    }

    public void setBooktitleC(String booktitleC) {
        this.booktitleC = booktitleC;
    }

    public String getEditionC() {
        return editionC;
    }

    public void setEditionC(String editionC) {
        this.editionC = editionC;
    }

    public String getPagedebC() {
        return pagedebC;
    }

    public void setPagedebC(String pagedebC) {
        this.pagedebC = pagedebC;
    }

    public String getPagefinC() {
        return pagefinC;
    }

    public void setPagefinC(String pagefinC) {
        this.pagefinC = pagefinC;
    }

    public String getOrganisationC() {
        return organisationC;
    }

    public void setOrganisationC(String organisationC) {
        this.organisationC = organisationC;
    }

    public String getAdresseC() {
        return adresseC;
    }

    public void setAdresseC(String adresseC) {
        this.adresseC = adresseC;
    }

    public String getNomed() {
        return nomed;
    }

    public void setNomed(String nomed) {
        this.nomed = nomed;
    }

    public String getPrenomed() {
        return prenomed;
    }

    public void setPrenomed(String prenomed) {
        this.prenomed = prenomed;
    }
 
    
    
    
    
    
    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    public void setPrenomAuteur(String prenomAuteur) {
        this.prenomAuteur = prenomAuteur;
    }

 
 
 
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

 
 
 
 
 
 
    public ArrayList getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(ArrayList auteurs) {
        this.auteurs = auteurs;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }
    
    
    
    public AjoutPublicationController() {
        
         auteurs=new ArrayList();
          l=autdao.listAuteur();
          
          led=eddao.listEditeur();
         /*if(l==null)
               auteurs.add(new Auteur());
   else*/
          testauteur.add(new Auteur() );
    // auteurs.add(autdao.AuteurPub(l,"", ""));
        /*  Auteur a=new Auteur();
     auteurs.add(autdao.AuteurPub(l,a.getNomAut(), a.getPrenomAut()));*/
       
        
    }
      public void addPanelAuteur()
     {   
         //testauteur.set(testauteur.size()-1, null);
         testauteur.add(new Auteur());
         System.out.println ("test "+testauteur);
        /* auteurs.set(auteurs.size()-1, autdao.AuteurPub(l,nomAuteur, prenomAuteur));
         auteurs.add(autdao.AuteurPub(l,"", ""));*/
          /* Auteur a=new Auteur();
     auteurs.add(autdao.AuteurPub(l,a.getNomAut(), a.getPrenomAut()));*/
         System.out.println("size "+ auteurs);
     }
     public void removePanelAuteur()
     {
          if(testauteur.size()==1)
         {
           FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquer un auteur", "Vous devez indiquer un auteur");
                FacesContext.getCurrentInstance().addMessage(null, error);
           
         }
          else
         testauteur.remove(testauteur.size()-1);
         
        
         
       /*  auteurs.remove(auteurs.size()-1);
         if(auteurs.size()==0)
         { auteurs.add(autdao.AuteurPub(l,"", ""));
             FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquer un auteur", "Vous devez indiquer un auteur");
                FacesContext.getCurrentInstance().addMessage(null, error);
         }
         System.out.println("size "+ auteurs.size());*/
         
     }
      public List<String> complete(String query) {  
        List<String> results = new ArrayList<String>();  
          
         
            results.add( "Janvier");  
              results.add( "Fevrier"); 
                results.add( "Mars"); 
                  results.add( "Avril"); 
                    results.add( "Mai"); 
                      results.add( "Juin"); 
                        results.add( "Juillet"); 
                          results.add( "Aout"); 
                            results.add("Septembre");   
                            results.add("Octobre");   
                            results.add("Novembre"); 
                            results.add("Decembre"); 
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("item "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    }  
      
      
       public List<String> completeNomAuteur(String query) {  
        List<String> results = new ArrayList<String>();  
          
       
       for(int i=0; i<l.size() ;i++)
       {
           results.add(((Auteur)l.get(i)).getNomAut());
       }
       
            
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("nom "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    }  
       
        public List<String> completePrenomAuteur(String query) {  
        List<String> results = new ArrayList<String>();  
          
       
       for(int i=0; i<l.size() ;i++)
       {
           results.add(((Auteur)l.get(i)).getPrenomAut());
       }
       
            
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("prenom "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    }  
    
        
        
        
         public List<String> completeNomEditeur(String query) {  
        List<String> results = new ArrayList<String>();  
          
       
       for(int i=0; i<led.size() ;i++)
       {
           results.add(((Editeur)led.get(i)).getNomEd());
       }
       
            
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("nom "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    }  
       
        public List<String> completePrenomEditeur(String query) {  
        List<String> results = new ArrayList<String>();  
          
       
       for(int i=0; i<led.size() ;i++)
       {
           results.add(((Editeur)led.get(i)).getPrenomEd());
       }
       
            
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("prenom "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    }  
    public boolean displayPanelEditeur()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Inbook")||type.equals("Conference")||type.equals("Livre")||type.equals("Collection"))
                return true;
            else
                return false;
        }
    }
    
     public boolean displayPanelArticle()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Article"))
                return true;
            else
                return false;
        }
    }
     public boolean displayPanelBrochure()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Brochure"))
                return true;
            else
                return false;
        }
    }
      public boolean displayPanelInbook()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Inbook"))
                return true;
            else
                return false;
        }
    }
       public boolean displayPanelConference()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Conference"))
                return true;
            else
                return false;
        }
    }
        public boolean displayPanelLivre()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Livre"))
                return true;
            else
                return false;
        }
    }
         public boolean displayPanelCollection()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Collection"))
                return true;
            else
                return false;
        }
    }
          public boolean displayPanelDivers()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Divers"))
                return true;
            else
                return false;
        }
    }
           public boolean displayPanelDoc()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Doc"))
                return true;
            else
                return false;
        }
    }
            public boolean displayPanelRapport()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Rapport"))
                return true;
            else
                return false;
        }
    }
    public String insert()
    { System.out.println("titre "+titre);
        if(mois==null)
        {
           
             FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquer le mois de la publication", "Vous devez indiquer le mois de la publication");
                FacesContext.getCurrentInstance().addMessage(null, error);
        return "";
        }
         if(annee==null)
        {
            
             FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquer l'annee de la publication", "Vous devez indiquer l'annee de la publication");
                FacesContext.getCurrentInstance().addMessage(null, error);
        return "";
        }
          if(type==null)
        {
            
             FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquer le type de la publication", "Vous devez indiquer le type de la publication");
                FacesContext.getCurrentInstance().addMessage(null, error);
        return "";
        }
         
       int m=0;
        if(mois.equals("Janvier"))
        m=1;
        if(mois.equals("Fevrier"))
        m=2;
        if(mois.equals("Mars"))
        m=3;
        if(mois.equals("Avril"))
        m=4;
        if(mois.equals("Mai"))
        m=5;
        if(mois.equals("Juin"))
        m=6;
        if(mois.equals("Juillet"))
        m=7;
        if(mois.equals("Aout"))
        m=8;
        if(mois.equals("Septembre"))
        m=9;
        if(mois.equals("Octobre"))
        m=10;
        if(mois.equals("Novembre"))
        m=11;
        if(mois.equals("Decembre"))
        m=12;
        PublicationDao pubdao=new PublicationDao();
        
       
            System.out.println("insertion");
            int v=0,n=0,pd=0,pf=0;
            if(volumeA!=null)
                
                if(!volumeA.equals(""))
                v=new Integer(volumeA);
            if(nombreA!=null)
            if(!nombreA.equals(""))
                n=new Integer(nombreA);
            if(pagedebA!=null)
                
                if(!pagedebA.equals(""))
                pd=new Integer(pagedebA);
            if(pagefinA!=null)
            { 
                if(!pagefinA.equals(""))
                pf=new Integer(pagefinA);
            }
         /* boolean existe=  pubdao.ExistePublication(titre);
          System.out.println("existe "+existe);*/
          if(pubdao.ExistePublication(titre))
          {
              FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "La publication a été déjà inserée ", "La publication a été déjà inserée");
                FacesContext.getCurrentInstance().addMessage(null, error);
       return "";
          }
          else{
            System.out.println("avant indertion");
        Publication p= pubdao.insert(titre, new Integer(annee), m, note, cle, howpubB, adresseB, journal, new Integer(pagedebA), new Integer(pagefinA), v, n, editionI, chapitreI, serieI, booktitleC, organisationC, type, adresseB, "");
         System.out.println("titre "+titre);
        /*if(((Auteur)auteurs.get(auteurs.size()-1)).getNomAut().equals("") &&!nomAuteur.equals("") )
              //auteurs.remove(auteurs.size()-1);
             auteurs.set(auteurs.size()-1, autdao.AuteurPub(l,nomAuteur, prenomAuteur));*/
        autdao.ajoutNouveauAuteur(testauteur,l);
        if(nomed!=null&&prenomed!=null)
        {if(!eddao.EditeurPub(led, nomed, prenomed))
         eddao.ajoutNouveauEditeur(nomed, prenomed);
        }
            EcrireDao ecrdao=new EcrireDao();
            ecrdao.ajout(testauteur, p);
        ListePublicationController listpub =new ListePublicationController();
        listpub.liste();
        FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_INFO, "La publication a été enregistré ", "La publication a été enregistré");
                FacesContext.getCurrentInstance().addMessage(null, error);
    return "";
                // return "Succes";
          }
    }
    public void autrechamps()
    {
       for(int i=0;i<champssup.size();i++)
       {
           System.out.println(champssup.get(i));
       }
       for(int i=0;i<champssup1.size();i++)
       {
           System.out.println(champssup1.get(i));
       }
       for(int i=0;i<champssup2.size();i++)
       {
           System.out.println(champssup2.get(i));
       }
    }
    
    
}
