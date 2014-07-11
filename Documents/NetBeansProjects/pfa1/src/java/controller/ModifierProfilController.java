/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChercheurDao;
import dao.EtablissementDao;
import dao.UniversiteDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import modele.Chercheur;
import modele.Etablissement;
import modele.Universite;
import org.primefaces.context.RequestContext;

/**
 *
 * @author USER1
 */
@Named(value = "modifierProfilController")
@SessionScoped
public class ModifierProfilController implements Serializable {

    /**
     * Creates a new instance of ModifierProfilController
     */
    private boolean test=true;
private boolean pub;
private String index;
private boolean supp;
    private String sexe;
     private  String nom;
      private  String prenom;
     private ArrayList universites;
    private  String nomprenom;
    private String nomJF;
    private Date datenais;
    private String lieunais;
    private String cin;
    private String passport;
    private String tel;
    private String mail;
    private String type;
    private String fonction;
    private String grade;
    private String libunivfonction;
    private String libetabfonction;
    private String libunivgrade;
    private String libetabgrade;
    private ArrayList etablissements1;
     private ArrayList etablissements2;
      private ArrayList etablissements3;
    private Chercheur cher;
    private String sujet;
private String avancement;
private String anneeinscri;
private String univinscri;
private String etabinscri;
private String nomdirecteurthese;
private String prenomdirecteurthese;
private Etablissement etf;
private Etablissement etg;
private Etablissement eti;

    public ArrayList getEtablissements3() {
        return etablissements3;
    }

    public void setEtablissements3(ArrayList etablissements3) {
        this.etablissements3 = etablissements3;
    }





    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getAvancement() {
        return avancement;
    }

    public void setAvancement(String avancement) {
        this.avancement = avancement;
    }

    public String getAnneeinscri() {
        return anneeinscri;
    }

    public void setAnneeinscri(String anneeinscri) {
        this.anneeinscri = anneeinscri;
    }

    public String getUnivinscri() {
        return univinscri;
    }

    public void setUnivinscri(String univinscri) {
        this.univinscri = univinscri;
    }

    public String getEtabinscri() {
        return etabinscri;
    }

    public void setEtabinscri(String etabinscri) {
        this.etabinscri = etabinscri;
    }

    public String getNomdirecteurthese() {
        return nomdirecteurthese;
    }

    public void setNomdirecteurthese(String nomdirecteurthese) {
        this.nomdirecteurthese = nomdirecteurthese;
    }

    public String getPrenomdirecteurthese() {
        return prenomdirecteurthese;
    }

    public void setPrenomdirecteurthese(String prenomdirecteurthese) {
        this.prenomdirecteurthese = prenomdirecteurthese;
    }








    public ArrayList getEtablissements2() {
        return etablissements2;
    }

    public void setEtablissements2(ArrayList etablissements2) {
        this.etablissements2 = etablissements2;
    }

    public ArrayList getUniversites() {
        return universites;
    }

    public void setUniversites(ArrayList universites) {
        this.universites = universites;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    
    
    
    
    public ArrayList getEtablissements1() {
        return etablissements1;
    }

    public void setEtablissements1(ArrayList etablissements1) {
        this.etablissements1 = etablissements1;
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

    
    
    
    
    
    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getGrade() {
        return grade;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public boolean isPub() {
        return pub;
    }

    public void setPub(boolean pub) {
        this.pub = pub;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public boolean isSupp() {
        return supp;
    }

    public void setSupp(boolean supp) {
        this.supp = supp;
    }

   

    
    
    
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLibunivfonction() {
        return libunivfonction;
    }

    public void setLibunivfonction(String libunivfonction) {
        this.libunivfonction = libunivfonction;
    }

    public String getLibetabfonction() {
        return libetabfonction;
    }

    public void setLibetabfonction(String libetabfonction) {
        this.libetabfonction = libetabfonction;
    }

    public String getLibunivgrade() {
        return libunivgrade;
    }

    public void setLibunivgrade(String libunivgrade) {
        this.libunivgrade = libunivgrade;
    }

    public String getLibetabgrade() {
        return libetabgrade;
    }

    public void setLibetabgrade(String libetabgrade) {
        this.libetabgrade = libetabgrade;
    }

    
    
    
    
    
    
    
    
    public String getNomprenom() {
        return nomprenom;
    }

    public void setNomprenom(String nomprenom) {
        this.nomprenom = nomprenom;
    }

    public String getNomJF() {
        return nomJF;
    }

    public void setNomJF(String nomJF) {
        this.nomJF = nomJF;
    }

    public Date getDatenais() {
        return datenais;
    }

    public void setDatenais(Date datenais) {
        this.datenais = datenais;
    }

    public String getLieunais() {
        return lieunais;
    }

    public void setLieunais(String lieunais) {
        this.lieunais = lieunais;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
    
    
    
    
    
    public Chercheur getCher() {
        return cher;
    }

    public void setCher(Chercheur cher) {
        this.cher = cher;
    }
    
    public boolean genererpanelJF()
    {
       // if(ProfilController.ch==null)
            return false;
        //if(ProfilController.ch.getSexeCh().equals("Femme"))
           // return true;
        //return false;
    }
    public boolean displaypanel()
    { System.out.println("sexe "+sexe);
        if(sexe==null)
        return false;
       // System.out.println(sexe);
        if(sexe.equals("Femme"))
        {   //System.out.println("activer ");
        return true;}
        else
            return false;
    }
    
    public ModifierProfilController() {
       cher= ProfilController.ch;
      if(cher!=null)
      {  
          nom=cher.getNomCh();
               prenom=cher.getPrenomCh();
          cin=cher.getCinCh();
          if(cher.getSexeCh()!=null)
              sexe=cher.getSexeCh();
          else
              sexe="";
          System.out.println("sexe cons "+sexe);
          if(cher.getDateNaisCh()!=null)
              datenais=cher.getDateNaisCh();
          else
              datenais=new Date(30,0,1);
           if(cher.getLieuNaisCh()!=null)
          lieunais=cher.getLieuNaisCh();
           else
               lieunais="";
          mail=cher.getEmailCh();
           if(cher.getNomJfch()!=null)
          nomJF=cher.getNomJfch();
           else
               nomJF="";
           if(cher.getPassCh()!=null)
          passport=cher.getPassCh();
           else
               passport="";
           if(cher.getTelCh()!=null)
          tel=cher.getTelCh();
           else
               tel="";
            if(cher.getTypeCh()!=null)
          type=cher.getTypeCh();
            else
                type="";
            System.out.println("type "+cher.getTypeCh());
             if(cher.getFonctionCh()!=null)
          fonction=cher.getFonctionCh();
             else
                 fonction="";
              if(cher.getGradeCh()!=null)
          grade=cher.getGradeCh();
              else
                  grade="";
              etablissements1=new ArrayList();
              etablissements2=new ArrayList();
           EtablissementDao etabdao=new EtablissementDao();
    etf=     etabdao.findEtablissementByFonction(cher);
        UniversiteDao univdao= new UniversiteDao();
           if(etf==null)
           {libetabfonction="";libunivfonction="";  universites= univdao.listUniv();}
           else{
            libetabfonction=etf.getLibEtab();
           
           Universite univ= univdao.findUniversiteByEtablissement(etf);
           libunivfonction=univ.getLibUniv();
           }
      etg=     etabdao.findEtablissementByGrade(cher);
           if(etg==null)
           { libetabgrade="";libunivgrade=""; universites= univdao.listUniv();}
           else{
            libetabgrade=etg.getLibEtab();
          
           Universite univg= univdao.findUniversiteByEtablissement(etg);
           libunivgrade=univg.getLibUniv(); 
           }
         eti=     etabdao.findEtablissementByInscription(cher);
       
           if(eti==null)
           {etabinscri="";univinscri="";  universites= univdao.listUniv();}
           else{
            etabinscri=eti.getLibEtab();
           
           Universite univ= univdao.findUniversiteByEtablissement(eti);
           univinscri=univ.getLibUniv();
           }
      }
      
        
    }
     public void findEtablissementByCodeUniv()
    {EtablissementDao etabdao=new EtablissementDao();
        System.out.println("univ "+ libunivfonction);
        if(libunivfonction==null)
            etablissements1=new ArrayList();
        else{
        if(!libunivfonction.equals(""))
        {
            if(libunivfonction.equals("Université"))
                etablissements2=new ArrayList();
            else{
         ArrayList l= etabdao.listEtablissement(libunivfonction);
    
       //  System.out.println(l);
         etablissements1=l;
         System.out.println(etablissements1);
        }
        }
        else
        {
            etablissements1=new ArrayList();
        }
        }
        if(libunivgrade==null)
        {
            etablissements2=new ArrayList();
        }
        else{
        if(!libunivgrade.equals(""))
        { if(libetabgrade.equals("Université"))
            etablissements2=new ArrayList();
        else{
         ArrayList l= etabdao.listEtablissement(libunivgrade);
       //  System.out.println(l);
         etablissements2=l;
        }
        }
        else
        {
            etablissements2=new ArrayList();
        }
        }
        if(univinscri==null)
            etablissements3=new ArrayList();
        else{
       if(!univinscri.equals(""))
        {
            if(univinscri.equals("Université"))
                etablissements2=new ArrayList();
            else{
         ArrayList l= etabdao.listEtablissement(univinscri);
        // System.out.println(l);
         etablissements3=l;
        }
        }
        else
        {
            etablissements3=new ArrayList();
        }
        }
        //return "";
    }
     public boolean displaypanelType()
    { System.out.println("type "+type);
        if(type==null)
        return false;
       
        if(type.equals("Etudiant en Master")||type.equals("Doctorant"))
        {   index="2";   return true;}
        else
            return false;
    }
     public String modifier()
     {boolean loggedIn = true;     FacesMessage msg = null;  
      RequestContext context = RequestContext.getCurrentInstance();  
        Chercheur dir=null;
         ChercheurDao chdao= new ChercheurDao();
         if(nomdirecteurthese!=null&&prenomdirecteurthese!=null)
         {  dir=  chdao.findChercheurbyNomPrenom(nomdirecteurthese, prenomdirecteurthese);
       if(dir==null)
       {
           loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Directeur invalide ", "Directeur invalide ");
	
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
        return "";
       }
         }
       
       {
             try{
                    UIComponent component=null;
                         EmailValidator em= new EmailValidator();
                              em.validate( FacesContext.getCurrentInstance(),  component, mail) ; 
                              

           int a,av;
           if(anneeinscri!=null)
            a=Integer.parseInt(anneeinscri);
           else
                a=0;
           if(avancement!=null)
           av=Integer.parseInt(avancement);
           else
               av=0;
      cher=chdao.update(dir, etf, etg, eti, nom, prenom, datenais, lieunais, sexe, nomJF, cin, passport, tel, mail, grade, type, sujet, av, fonction,a ,cher);
       /* ProfilController.ch.setNomCh(nom);
        ProfilController.ch.setPrenomCh(prenom);
       ProfilController. ch.setTypeCh(type);*/
       System.out.println("date nais " +datenais);   
      System.out.println("libunivfonc " +libunivfonction);
          System.out.println("libunivinsc " +univinscri);
           }catch(ValidatorException e)
                    {
                       loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur validation", "Email invalide");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
                    }
       }
             
         return "profil";
     }
      public void displayprofil()
   { System.out.println("pubclicked");
   index="0";
        test=true;
        pub=false;
        System.out.println("test"+test);
        System.out.println("pub"+pub);
       supp=false;
   }
      
       public void displaypublication() 
   { System.out.println("pubclicked");
   index="1";     
   test=false;
        pub=true;
        System.out.println("test"+test);
        System.out.println("pub"+pub);
    supp=false;
   }
        public void displaysupp() 
   { System.out.println("pubclicked");
   index="2";     
   test=false;
        pub=false;
       supp=true;
   }
    
}
