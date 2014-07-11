/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChercheurDao;
import dao.EtablissementDao;
import dao.PublicationDao;
import dao.StructureRechercheDao;
import dao.UniversiteDao;
import dao.UserDao;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import modele.Chercheur;
import modele.Ecrire;
import modele.Etablissement;
import modele.Publication;
import modele.Structurerecherche;
import modele.Universite;
import modele.User;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author USER1
 */
@Named(value = "profilController")
@SessionScoped
public class ProfilController implements Serializable {

    /**
     * Creates a new instance of ProfilController
    
    */
    
    
    private boolean valider;
    private Etablissement etg;
    private String denomination;
    private String discpline;
    private String libuniv;
    private String libetab;
    private String typest;
    private String type;
    private String nom;
    private StreamedContent image;
   boolean changerphoto=false;
    private String path;
 static   Chercheur ch;
private ArrayList menu;
private boolean disabled;
private boolean test=true;
private boolean pub;
private String index;
private ArrayList auteurs;
 private String mois;
 private   ArrayList <Chercheur> listdem=new ArrayList <Chercheur>();
 private int nbdem;
private ArrayList <Publication> listpub=new  ArrayList<Publication>();
private ArrayList listlist=new ArrayList();
private   ArrayList <Chercheur> listrecuser=new ArrayList <Chercheur>();

    public ArrayList<Chercheur> getListrecuser() {
        return listrecuser;
    }

    public void setListrecuser(ArrayList<Chercheur> listrecuser) {
        this.listrecuser = listrecuser;
    }




    public ArrayList getListlist() {
        return listlist;
    }

    public void setListlist(ArrayList listlist) {
        this.listlist = listlist;
    }



    public ArrayList<Publication> getListpub() {
        return listpub;
    }

    public void setListpub(ArrayList<Publication> listpub) {
        this.listpub = listpub;
    }




public ArrayList<Chercheur> getListdem() {
        return listdem;
    }

    public void setListdem(ArrayList<Chercheur> listdem) {
        this.listdem = listdem;
    }

 
 
 
    public int getNbdem() {
        return nbdem;
    }

    public void setNbdem(int nbdem) {
        this.nbdem = nbdem;
    }

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }
 
 
 
 
 
 
    ArrayList <Chercheur> listsch;
    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }
 
 
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }




    public boolean isPub() {
        return pub;
    }

    public void setPub(boolean pub) {
        this.pub = pub;
    }

    public ArrayList getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(ArrayList auteurs) {
        this.auteurs = auteurs;
    }






    public ArrayList getMenu() {
        return menu;
    }

    public void setMenu(ArrayList menu) {
        this.menu = menu;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
   

 
 
 
 
 




    public String getTypest() {
        return typest;
    }

    public void setTypest(String typest) {
        this.typest = typest;
    }

     
     
     
     
     
    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getDiscpline() {
        return discpline;
    }

    public void setDiscpline(String discpline) {
        this.discpline = discpline;
    }

    public String getLibuniv() {
        return libuniv;
    }

    public void setLibuniv(String libuniv) {
        this.libuniv = libuniv;
    }

    public String getLibetab() {
        return libetab;
    }

    public void setLibetab(String libetab) {
        this.libetab = libetab;
    }
    
     
     
     
     
     
     
    public ProfilController() {
        
      User u=  UserController.u;
        test=true;
        index="0";
       // System.out.println("user "+ u.getType());
        ChercheurDao chdao=new ChercheurDao();
      ch=  chdao.findChercheurByUser(u);
     
     auteurs=new ArrayList();
     auteurs.add("rrr");
        if(ch==null)
        {
            System.out.println("ch null");
            nom=u.getId().getLogin();
            type="";
        }
        else
        { listsch=new ArrayList();
            listsch.add(ch);
        System.out.println("ch existe");
           nom=ch.getPrenomCh()+" "+ch.getNomCh();
           type=ch.getTypeCh();
           
           Structurerecherche st=  chdao.findstructureBychercheur(ch);
           menu=new ArrayList();
           ch.setStructurerecherche(st);
            typest=st.getType();
            denomination=st.getDenomination();
            System.out.println("ch st "+st.getChercheurs());
            for(int i=0;i<st.getChercheurs().size();i++)
            {
                System.out.println("chercheur "+((Chercheur)(st.getChercheurs()).toArray()[i]).getAuteurs());
            }
            
            PublicationDao  pub=new  PublicationDao();
            //pub.top10PublicationLabo(st);
            System.out.println("top 10 "+pub.top10());
            ArrayList lpub=pub.top10();
            for(int i=0;i<lpub.size();i++)
            {
                if(i<=4)
                {
                    Publication p=(Publication)lpub.get(i);
                    for(int j=0;j<p.getEcrires().toArray().length;j++)
                   listlist.add(((Ecrire)p.getEcrires().toArray()[j]).getAuteur().getPrenomAut()+((Ecrire)p.getEcrires().toArray()[j]).getAuteur().getNomAut());
                    listpub.add((Publication)lpub.get(i));
                }
                else
                    break;
                
            }
            UserDao userdao= new UserDao ();
            
        ArrayList listuser=    userdao.recentUser();
        
            System.out.println(" list user "+ ((User)listuser.get(0)).getChercheurs());
            
            for(int i=0;i<listuser.size();i++)
            {
                if(i<=5)
                {
                User uss=(User)listuser.get(i);
                    System.out.println("taille "+ uss.getChercheurs().toArray().length);
                    if(uss.getChercheurs().toArray().length!=0)
          listrecuser.add((Chercheur)((uss.getChercheurs())).toArray()[0]);
                }
            }
         /*listpub= pub.top10Publication(st);
            System.out.println("top pub = "+listpub);*/
           
            EtablissementDao etabdao=new EtablissementDao();
       Etablissement et=     etabdao.findEtablissementByStructure(st);
           
            libetab=et.getLibEtab();
            UniversiteDao univdao= new UniversiteDao();
           Universite univ= univdao.findUniversiteByEtablissement(et);
             libuniv=univ.getLibUniv();
            discpline=st.getDiscipline();
    if(chdao.findChercheurAdministrateur(ch,st))
    {
        System.out.println("nb dem "+chdao. nbdemande (ch));
        nbdem=chdao. nbdemande (ch);
        if(nbdem!=0)
        { disabled=true; valider=true;
  listdem=chdao.listdemande(ch);
            System.out.println("list dem "+ listdem);
        }
       test=true;
    }
    else{
        disabled=false;valider=false;
    }
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public StreamedContent getImage() {
       FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
    return new DefaultStreamedContent();
}
 String chemin;      
byte[] bytes=new byte[1024];
if(ch==null){ chemin="C:/Users/USER1/Desktop/images/profil.png";}
else { if(changerphoto)
    chemin=path;
     else
    chemin=ch.getPhoto();
}
        try {
            FileInputStream fis = new FileInputStream(new File(chemin));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);     
           //  System.out.println("read " + readNum + " bytes,");

            }
 bytes = bos.toByteArray();
        } catch (IOException ex) {

        }



    /*   String path=fc.getExternalContext().getRequestParameterMap().get("photo");
       byte[]photodata=org.apache.commons.io.FileUtils.readFileToByteArray(new File(path));*/
       return new DefaultStreamedContent(new ByteArrayInputStream(bytes));
        
    }

    public void setImage(StreamedContent image) {
        this.image = image;
    }
     public void handleFileUpload( FileUploadEvent event) {
    	    System.out.println("file upload");
    	 if(event!=null)
         {   // uploadedFile=event.getFile(); 
            
    	path= event.getFile().getFileName();
    		changerphoto=true;
       getImage();
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            
           
            
            File result = new File(path);
            System.out.println(path);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(result);

                byte[] buffer = new byte[1024];

                int bulk;
                InputStream inputStream = event.getFile().getInputstream();
                while (true) {
                    bulk = inputStream.read(buffer);
                    if (bulk < 0) {
                        break;
                    }
                    fileOutputStream.write(buffer, 0, bulk);
                    fileOutputStream.flush();
                }

                fileOutputStream.close();
                inputStream.close();
ChercheurDao chdao=new ChercheurDao();
chdao.updatephoto(ch, path);
                FacesMessage msg = 
                            new FacesMessage("File Uploaded", "photo changée");
                FacesContext.getCurrentInstance().addMessage(null, msg);
               // DaoUpload dao = new DaoUpload();
               // dao.savedatainDB();
                /*UploadController u = new UploadController();
                u.savedatainDB();*/

            } catch (IOException e) {
                e.printStackTrace();

                FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "The files were not uploaded!", "");
                FacesContext.getCurrentInstance().addMessage(null, error);
            }
    }
    }
    
    public boolean genererpanel()
    {
        if(ch==null)
            return true;
        else
            return false;
    }
    
    
   public boolean genererpanelinfo() 
   { displaystructure();
     return !genererpanel()&&!displaypanel();
   }
    public String dispatcher ()
    {
       /*try {
    ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest)context.getRequest()).getRequestDispatcher("inscriptionLabo.xhtml");
		dispatcher.forward((ServletRequest)context.getRequest(), (ServletResponse)context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
       }catch(Exception e)
       {
           System.out.println("exception");
           
       }*/
        //System.out.println("dispatcher");
        return "inscription";
		
    }
    public void displaystructure()
    {
        if(ch!=null)
            
        {   ChercheurDao chdao=new ChercheurDao();
            Structurerecherche st=  chdao.findstructureBychercheur(ch);
            //System.out.println("struc "+st);
            typest=st.getType();
            denomination=st.getDenomination();
            EtablissementDao etabdao=new EtablissementDao();
       Etablissement et=     etabdao.findEtablissementByStructure(st);
           
            libetab=et.getLibEtab();
            UniversiteDao univdao= new UniversiteDao();
           Universite univ= univdao.findUniversiteByEtablissement(et);
             libuniv=univ.getLibUniv();
            discpline=st.getDiscipline();
        }
    }
   public boolean displaypanel()
   {
       if(ch!=null)
       {
          if(ch.getEtat().equals("non valide"))
      {
          return true;
      }
      else return false;
       }
       else
           return false;
   }
   public String dispatcherModifierProfil()
   {
        return "inscriptionLabo";
   }
    public void displaypublication() throws NoSuchAlgorithmException
   { System.out.println("pubclicked");
   index="1";     
   test=false;
        pub=true;
        System.out.println("test"+test);
        System.out.println("pub"+pub);
     traiterPublication t=new traiterPublication();
          traiterPublication t1=new traiterPublication();

     t.setTitre("marwa Boulakbech if4");
     t1.setTitre("MARWA   Boulakbech IF4");
    
   
       System.out.println("test hash "+t.titreExiste( t.hash(),  t1.hash()));
   }
     public void displayprofil()
   { System.out.println("pubclicked");
   index="0";
        test=true;
        pub=false;
        System.out.println("test"+test);
        System.out.println("pub"+pub);
   }
     public void addPanelAuteur()
     {
         auteurs.add("rrr");
         System.out.println("size "+ auteurs.size());
     }
     public void removePanelAuteur()
     {
         auteurs.remove(auteurs.size()-1);
         if(auteurs.size()==0)
         { auteurs.add("hhh");
             FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquer un auteur", "Vous devez indiquer un auteur");
                FacesContext.getCurrentInstance().addMessage(null, error);
         }
         System.out.println("size "+ auteurs.size());
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
      public String nouvellePublication()
      {
          return "ajoutpub";
      }
       public String redirectionPublication()
      {

          ListePublicationController list=new ListePublicationController();
          list.liste();
          return "redirectpub";
      }
        public String redirectionModifierProfil()
      {
          return "redirectmodifierprofil";
      }
        
        public void genererFicheChercheur()
        {
            
            try {
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(listsch,false);
    String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("report1.jasper");
          
             HashMap hm=new HashMap();
           hm.put("Dénomination du  L.R / U.R",ch.getStructurerecherche().getDenomination() );
            hm.put("EtablissementStructure",libetab);
             hm.put("UniversiteStructure",libuniv );
           /* hm.put("Etablissement",ch.getStructurerecherche().getEtablissement() );*/
            // hm.put("Date de Naissance",ch.getDateNaisCh() );
                EtablissementDao etabdao=new EtablissementDao();
              etg=     etabdao.findEtablissementByGrade(ch);
              String libetabgrade;
           if(etg==null)
           { libetabgrade="";}
           else{
            libetabgrade=etg.getLibEtab();
           }
                System.out.println("etab grade "+libetabgrade);
               hm.put("Etablissement",libetabgrade);
               
          Etablissement     eti=     etabdao.findEtablissementByInscription(ch);
       String etabinscri; String inscuniv="";
           if(eti==null)
           {etabinscri="";}
           else{
            etabinscri=eti.getLibEtab();
           
            System.out.println("etab inscri "+etabinscri);
               hm.put("EtablissementInsc",etabinscri);
                UniversiteDao univdao= new UniversiteDao();
           Universite univ= univdao.findUniversiteByEtablissement(eti);
           
             inscuniv=univ.getLibUniv();
           }
             System.out.println("univ inscri "+inscuniv);
               hm.put("UniversitetInsc",inscuniv);
               String directeur="";
               if(ch.getChercheur()!=null)
               {
                   directeur=ch.getChercheur().getPrenomCh()+ch.getChercheur().getNomCh();
               }
               hm.put("directeurThese",directeur);
                //System.out.println("directeurlabo "+ch.getStructurerecherche().getChercheur().getNomCh());
               StructureRechercheDao stdao=new StructureRechercheDao();
             Chercheur dir=  stdao.findDirecteurStructure(ch.getStructurerecherche());
              hm.put("DirecteurLabo",dir.getPrenomCh()+" "+dir.getNomCh());
              String annee="";
              if(ch.getAnnee().intValue()!=0)
                  annee=ch.getAnnee()+"";
               hm.put("Annee",annee);
                hm.put("DirecteurLabo",dir.getPrenomCh()+" "+dir.getNomCh());
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
            
            
                System.out.println("labo "+ch.getDateNaisCh());
            HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
        // httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
        
        } catch (JRException ex) {
            Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur inputoutput"+ex);
        }
        
       
                
        
        }
        
      public String logout() {
   System.out.println("logout appelé");
   
   FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  
   return "logout";
  }  
       
        public void onHideDemande()
        {
            disabled=false;
           // valider=false;
        }
        
}
