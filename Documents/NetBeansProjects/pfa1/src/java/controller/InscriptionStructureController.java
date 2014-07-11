/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChercheurDao;
import dao.EtablissementDao;
import dao.InscriptionDao;
import dao.StructureRechercheDao;
import dao.UniversiteDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import modele.Chercheur;
import modele.Etablissement;
import modele.Structurerecherche;
import modele.User;
import org.primefaces.context.RequestContext;

/**
 *
 * @author USER1
 */
@Named(value = "inscriptionStructureController")
@SessionScoped
public class InscriptionStructureController implements Serializable {

    
    
    
    
    /**
     * Creates a new instance of InscriptionStructureController
     */
     private ArrayList universites;
    private ArrayList etablissements1;
    private ArrayList etablissements2;
    private ArrayList etablissements3;
    private  UniversiteDao univdao =new UniversiteDao();
    private EtablissementDao etabdao= new EtablissementDao();
 private String email;
 private String tel;
  Chercheur ch;
   Structurerecherche sr;
    Etablissement  etf;
     Etablissement  etg;
     int av;
     int an;
     ChercheurDao chdao= new ChercheurDao();
private String univlib;
private String etablib;
private String univlibg;
private String etablibg;
private String univlibi;
private String etablibi;
     private String sexe;
      private ArrayList etablissements;
private String denomination;
private String type;
private String structure;
private String responsable;
private String libuniv;
private String labounite;
private String nomprenom;
private Date datenais;
private String lieudenais;
private String cin;
private String numpasport;
private String fonction;
private String grade=new String("");;
private String foncuniv;
private String foncetab;
private String gradeuniv;
private String gradeetab;
private String sujet;
private String avancement;
private String anneeinscri;
private String univinscri;
private String etabinscri;
private String nomprenomdirecteurthese;
private String nomjeunefille;

    public String getNomjeunefille() {
        return nomjeunefille;
    }

    public void setNomjeunefille(String nomjeunefille) {
        this.nomjeunefille = nomjeunefille;
    }

    public ArrayList getEtablissements() {
        return etablissements;
    }

    public void setEtablissements(ArrayList etablissements) {
        this.etablissements = etablissements;
    }




    public String getNomprenom() {
        return nomprenom;
    }

    public Date getDatenais() {
        return datenais;
    }

    public String getLieudenais() {
        return lieudenais;
    }

    public String getCin() {
        return cin;
    }

    public String getNumpasport() {
        return numpasport;
    }

    public String getFonction() {
        return fonction;
    }

    public String getGrade() {
        return grade;
    }

    public String getFoncuniv() {
        return foncuniv;
    }

    public String getFoncetab() {
        return foncetab;
    }

    public String getGradeuniv() {
        return gradeuniv;
    }

    public String getGradeetab() {
        return gradeetab;
    }

    public String getSujet() {
        return sujet;
    }

    public String getAvancement() {
        return avancement;
    }

    public String getAnneeinscri() {
        return anneeinscri;
    }

    public String getUnivinscri() {
        return univinscri;
    }

    public String getEtabinscri() {
        return etabinscri;
    }

    public String getNomprenomdirecteurthese() {
        return nomprenomdirecteurthese;
    }

    public void setNomprenom(String nomprenom) {
        this.nomprenom = nomprenom;
    }

    public void setDatenais(Date datenais) {
        this.datenais = datenais;
    }

    public void setLieudenais(String lieudenais) {
        this.lieudenais = lieudenais;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNumpasport(String numpasport) {
        this.numpasport = numpasport;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setFoncuniv(String foncuniv) {
        this.foncuniv = foncuniv;
    }

    public void setFoncetab(String foncetab) {
        this.foncetab = foncetab;
    }

    public void setGradeuniv(String gradeuniv) {
        this.gradeuniv = gradeuniv;
    }

    public void setGradeetab(String gradeetab) {
        this.gradeetab = gradeetab;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setAvancement(String avancement) {
        this.avancement = avancement;
    }

    public void setAnneeinscri(String anneeinscri) {
        this.anneeinscri = anneeinscri;
    }

    public void setUnivinscri(String univinscri) {
        this.univinscri = univinscri;
    }

    public void setEtabinscri(String etabinscri) {
        this.etabinscri = etabinscri;
    }

    public void setNomprenomdirecteurthese(String nomprenomdirecteurthese) {
        this.nomprenomdirecteurthese = nomprenomdirecteurthese;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }






    public String getLabounite() {
        return labounite;
    }

    public void setLabounite(String labounite) {
        this.labounite = labounite;
    }




    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setLibuniv(String libuniv) {
        this.libuniv = libuniv;
    }

    public void setLibetab(String libetab) {
        this.libetab = libetab;
    }


    public String getResponsable() {
        return responsable;
    }

    public String getLibuniv() {
        return libuniv;
    }

    public String getLibetab() {
        return libetab;
    }
private String libetab;




    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }



    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setEtablissements2(ArrayList etablissements2) {
        this.etablissements2 = etablissements2;
    }

    public void setEtablissements3(ArrayList etablissements3) {
        this.etablissements3 = etablissements3;
    }

    public void setUnivlibg(String univlibg) {
        this.univlibg = univlibg;
    }

    public void setEtablibg(String etablibg) {
        this.etablibg = etablibg;
    }

    public void setUnivlibi(String univlibi) {
        this.univlibi = univlibi;
    }

    public void setEtablibi(String etablibi) {
        this.etablibi = etablibi;
    }

    public ArrayList getEtablissements2() {
        return etablissements2;
    }

    public ArrayList getEtablissements3() {
        return etablissements3;
    }

    public String getUnivlibg() {
        return univlibg;
    }

    public String getEtablibg() {
        return etablibg;
    }

    public String getUnivlibi() {
        return univlibi;
    }

    public String getEtablibi() {
        return etablibi;
    }

    public ArrayList getUniversites() {
        return universites;
    }

    public ArrayList getEtablissements1() {
        return etablissements1;
    }

    public UniversiteDao getUnivdao() {
        return univdao;
    }

    public EtablissementDao getEtabdao() {
        return etabdao;
    }

    public String getUnivlib() {
        return univlib;
    }

    public String getEtablib() {
        return etablib;
    }

    public void setUniversites(ArrayList universites) {
        this.universites = universites;
    }

    public void setEtablissements1(ArrayList etablissements1) {
        this.etablissements1 = etablissements1;
    }

    public void setUnivdao(UniversiteDao univdao) {
        this.univdao = univdao;
    }

    public void setEtabdao(EtablissementDao etabdao) {
        this.etabdao = etabdao;
    }

    public void setUnivlib(String univlib) {
        this.univlib = univlib;
    }

    public void setEtablib(String etablib) {
        this.etablib = etablib;
    }
     public void findEtablissementByCodeUniv()
    {
        if(!univlib.equals("Université"))
        {
         ArrayList l= etabdao.listEtablissement(univlib);
    
       //  System.out.println(l);
         etablissements1=l;
        }
        else
        {
            etablissements1=new ArrayList();
        }
        if(!univlibg.equals("Université"))
        {
         ArrayList l= etabdao.listEtablissement(univlibg);
       //  System.out.println(l);
         etablissements2=l;
        }
        else
        {
            etablissements2=new ArrayList();
        }
        if(!univlibi.equals("Université"))
        {
         ArrayList l= etabdao.listEtablissement(univlibi);
        // System.out.println(l);
         etablissements3=l;
        }
        else
        {
            etablissements3=new ArrayList();
        }
        //return "";
    }
    
    public boolean displaypanel()
    { if(sexe==null)
        return false;
       // System.out.println(sexe);
        if(sexe.equals("Femme"))
        {   //System.out.println("activer ");
        return true;}
        else
            return false;
    }
    public boolean displaypanelstructure()
    { if(denomination==null||labounite==null)
        return false;
       // System.out.println(denomination);
        if(!denomination.equals("")&&!labounite.equals(""))
        {  StructureRechercheDao stdao=new StructureRechercheDao();
          sr= stdao.find(denomination, labounite);
          
          if( sr!=null)
          {  libetab=  stdao.getLibetab();
         libuniv=   stdao.getLiuniv();
          responsable= stdao.getResponsable();
          //System.out.println(responsable);
          }
         /* else
          {  RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false; 
              loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Structure de recherche inexistante", "Structure de recherche inexistante");
	
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
          }*/
            return true;}
        else
        {         
        

            return false;
        
        }
    }
    
    public boolean displaypanelType()
    { if(type==null)
        return false;
       
        if(type.equals("Etudiant en Master")||type.equals("Doctorant"))
        {  return true;}
        else
            return false;
    }
    
    public String inscription()
    { boolean loggedIn = true; String nomch=new String();String prenomch =new String();
     FacesMessage msg = null;  
      RequestContext context = RequestContext.getCurrentInstance();  
        
    
        //System.out.println(structure);
        System.out.println("bouton");
        System.out.println("cin "+cin);
        if(cin.equals("")&&numpasport.equals(""))
        {
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquez le CIN ou n°passport ", "Vous devez indiquez le CIN ou n°passport ");
	
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
        }
       if(sr==null)
       {
            System.out.println("structure null");
              loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Structure de recherche inexistante", "Structure de recherche inexistante");
	
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
       }
          StringTokenizer st=new StringTokenizer(nomprenom," ");
     try{
         
         nomch=  st.nextToken();
       prenomch =st.nextToken();
     }catch(Exception e)
     
      {
          loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Entrer le nom et prenom", "Entrer le nom et prenom ");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
      }
     try{
         System.out.println("mail "+email);        
         UIComponent component=null;
         EmailValidator em= new EmailValidator();
                              em.validate( FacesContext.getCurrentInstance(),  component, email) ;  
}catch(ValidatorException e)
                    {
                       loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Email invalide", "Email invalide");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
       
                    }
     try{
         System.out.println("tel "+tel);
         int t=Integer.parseInt(tel);
     }catch(NumberFormatException e)
     {
           loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Telephone invalide", "Telephone invalide");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
       
     }
     System.out.println("cond "+loggedIn);
      if(univlib==null)
          univlib=new String ();
      if(etablib==null)
          etablib=new String();
     if(fonction==null)
       fonction =new String("");
    
         
     else{
     if(!fonction.equals(""))
     {System.out.println("cond "+loggedIn);
         if(univlib.equals("")||etablib.equals(""))
         {loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez indiquer l'université et l'etablissement de la fonction", "Veuillez indiquer l'etablissement");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
       
         }
     else
          etf=  etabdao.codeetab(etablib);
     }
     }
     if(univlibg==null)
      univlibg= new String ();
      if(etablibg==null)
          etablibg=new String();  
     if(grade==null)
      grade =new String("");
     else{
        if(!grade.equals(""))
     { System.out.println("cond "+loggedIn);
         if(univlibg.equals("")||etablibg.equals(""))
     { loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez indiquer l'université et l'etablissement de la grade", "Veuillez indiquer l'etablissement");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
       
     }
     else
         etg=  etabdao.codeetab(etablibg);
     }
     }
   if( type.equals("Etudiant en Master")||type.equals("Doctorant"))
   {   StringTokenizer std=new StringTokenizer(nomprenomdirecteurthese," ");
     try{
         
         String nom=  std.nextToken();
      String prenom =std.nextToken();
       
        ch=chdao.findChercheurbyNomPrenom(nom, prenom);
       if(ch==null)
      {
          System.out.println("nom "+nom);
          loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Directeur inexistant", "Directeur inexistant");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
      }
        
     }catch(Exception e)
     
      {
          loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Entrer le nom et prenom du directeur", "Entrer le nom et prenom du directeur");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
      }
   
           av=Integer.parseInt(avancement);
           an=Integer.parseInt(anneeinscri);
    
   }
    System.out.println("cond "+loggedIn);
      if(loggedIn)
      { System.out.println("insertion");
           Etablissement  eti=etabdao.codeetab(etablibi);
          InscriptionDao insdao=new InscriptionDao();
          User u=  UserController.u;
          System.out.println("user "+u);
      Chercheur res=    chdao.insert( ch,  sr,etf, etg, eti, nomch, prenomch, datenais, lieudenais, sexe, nomjeunefille, cin, numpasport, tel, email, grade, type, sujet, av, fonction,an , "non valide",u);
      
      if(res!=null)
          { if(insdao.insert(sr, "non valide", res).equals("saved")) 
              { msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inscription enregistrée ", "Inscription enregistrée");
		
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
             }
          }
           System.out.println("structure "+ sr);
      }
        return "";
}
    
    
    public InscriptionStructureController() {
        labounite=new String();
        /*EtablissementDao etabdao=new EtablissementDao();
         etablissements= etabdao.listetablissement();*/
        universites= univdao.listUniv();
       univlibg=new String("Université");
       univlibi=new String("Université");
       responsable=new String();
        univlib=new String("Université");
        fonction=new String("");
        grade=new String("");
        nomprenomdirecteurthese=new String();
    }
}
