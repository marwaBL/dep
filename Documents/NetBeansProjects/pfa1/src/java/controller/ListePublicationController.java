/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AuteurDao;
import dao.EcrireDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import modele.Auteur;
import modele.Ecrire;
import modele.Publication;

/**
 *
 * @author USER1
 */
@Named(value = "listePublicationController")
@SessionScoped
public class ListePublicationController implements Serializable {

    ArrayList listtype=new ArrayList();
    AuteurDao autdao=new AuteurDao(); 
    EcrireDao ecdao=new EcrireDao();
   private  String nomaut;
   private ArrayList<Publication> listpub= new ArrayList<Publication>() ;
 private ArrayList<Auteur> listaut= new ArrayList<Auteur>() ;
    ArrayList listlist =new ArrayList() ;
     ArrayList listec;
     ArrayList typeimage=new ArrayList();

    public ArrayList getListtype() {
        return listtype;
    }

    public void setListtype(ArrayList listtype) {
        this.listtype = listtype;
    }

     
     
     
     
     
     
    public ArrayList getTypeimage() {
        return typeimage;
    }

    public void setTypeimage(ArrayList typeimage) {
        this.typeimage = typeimage;
    }

     
     
    public ArrayList getListlist() {
        return listlist;
    }

    public void setListlist(ArrayList listlist) {
        this.listlist = listlist;
    }
    
    
    
    
    
    public ArrayList<Auteur> getListaut() {
        return listaut;
    }

    public void setListaut(ArrayList<Auteur> listaut) {
        this.listaut = listaut;
    }
 
 
 
 
 
    public ArrayList<Publication> getListpub() {
        return listpub;
    }

    public void setListpub(ArrayList<Publication> listpub) {
        this.listpub = listpub;
    }

   
   
    
   
   
   
   
   
    public String getNomaut() {
        return nomaut;
    }

    public void setNomaut(String nomaut) {
        this.nomaut = nomaut;
    }
   
   
   
  public void liste()
  {
      Auteur a=  autdao.findAuteurByChercheur(ProfilController.ch.getIdCh());
       if(a!=null)
       { System.out.println("auteur "+a.getNomAut());
        nomaut=a.getNomAut();
       listec=ecdao.findListPublicationByAuteur(a);
           //System.out.println("test pub "+ ecdao.findListPublicationtest(listec));
       // System.out.println("listeec"+listec); 
               // a.setEcrires((Set<Ecrire>) listec);
       /* listpub=ecdao.findListPublication(listec);*/
           listpub=ecdao.findListPublicationtest(listec);
           int k=0;
           while(k<listpub.size())
           {
               int j=k+1;
               while(j<listpub.size()&&((Publication)listpub.get(k)).getAnnee().equals(((Publication)listpub.get(j)).getAnnee()))
               {
                   ((Publication)listpub.get(j)).setNombre(0);
                   j++;
               }
               k=j;
           }
       /* System.out.println("titre "+ ((Publication)  ecdao.findListPublication(listec).get(0)). getTitre());
       ArrayList le= autdao.findListEcrireByPublication((Publication)  ecdao.findListPublication(listec).get(0));
     ArrayList laut=  ecdao.findListAuteur(le);
     listaut=laut;
       System.out.println("auteur "+laut);
        for(int i=0;i<listpub.size();i++)
        { ArrayList lec= autdao.findListEcrireByPublication((Publication)  ecdao.findListPublication(listec).get(i));
     ArrayList laute=  ecdao.findListAuteur(lec);
     listlist.add(laute);
    // listaut=laut;
        }
        
           System.out.println("list auteur "+ listlist);*/
            ArrayList le= autdao.findListEcrireByPublication((Publication)  listpub.get(0));
            //System.out.println(" le "+le);
     ArrayList laut=  ecdao.findListAuteur(le);
     listaut=laut;
     for (int i=0;i<listpub.size();i++)
           System.out.println("pub "+listpub.get(i).getIdPub());
           System.out.println(" list aut "+laut);
      // System.out.println("auteur "+laut);
        for(int i=0;i<listpub.size();i++)
        { ArrayList lec= autdao.findListEcrireByPublication((Publication)  listpub.get(i));
     ArrayList laute=  ecdao.findListAuteur(lec);
     listlist.add(laute);
        }
           
         String or,ad,booktitle;
        for(int i=0;i<listpub.size();i++)
        {
            if(((Publication)listpub.get(i)).getType().equals("Article"))
            { typeimage.add("violetcarres.png");
            listtype.add(((Publication)listpub.get(i)).getJournal()+"   "+((Publication)listpub.get(i)).getPagedeb()+"-"+((Publication)listpub.get(i)).getPagefin());
            }
            
            if(((Publication)listpub.get(i)).getType().equals("Conference"))
            { typeimage.add("rougecarres.jpg");
            if(((Publication)listpub.get(i)).getOrganisation()==null)
               or="";
            else
             or=((Publication)listpub.get(i)).getOrganisation();
            if(((Publication)listpub.get(i)).getAdresse()==null)
               ad="";
            else
             ad=((Publication)listpub.get(i)).getAdresse();
            if(((Publication)listpub.get(i)).getBooktitle()==null)
               booktitle="";
            else
             booktitle=((Publication)listpub.get(i)).getBooktitle();
             listtype.add(or+"  "+booktitle+"  "+ad+" "+((Publication)listpub.get(i)).getPagedeb()+"-"+((Publication)listpub.get(i)).getPagefin());
            
            }
        }
      
       }
  }
   
   
    
    
    public ListePublicationController() {
  Auteur a=  autdao.findAuteurByChercheur(ProfilController.ch.getIdCh());
       if(a!=null)
       { System.out.println("auteur "+a.getNomAut());
        nomaut=a.getNomAut();
       listec=ecdao.findListPublicationByAuteur(a);
           //System.out.println("test pub "+ ecdao.findListPublicationtest(listec));
       // System.out.println("listeec"+listec); 
               // a.setEcrires((Set<Ecrire>) listec);
       /* listpub=ecdao.findListPublication(listec);*/
           listpub=ecdao.findListPublicationtest(listec);
           int k=0;
           while(k<listpub.size())
           {
               int j=k+1;
               while(j<listpub.size()&&((Publication)listpub.get(k)).getAnnee().equals(((Publication)listpub.get(j)).getAnnee()))
               {
                   ((Publication)listpub.get(j)).setNombre(0);
                   j++;
               }
               k=j;
           }
       /* System.out.println("titre "+ ((Publication)  ecdao.findListPublication(listec).get(0)). getTitre());
       ArrayList le= autdao.findListEcrireByPublication((Publication)  ecdao.findListPublication(listec).get(0));
     ArrayList laut=  ecdao.findListAuteur(le);
     listaut=laut;
       System.out.println("auteur "+laut);
        for(int i=0;i<listpub.size();i++)
        { ArrayList lec= autdao.findListEcrireByPublication((Publication)  ecdao.findListPublication(listec).get(i));
     ArrayList laute=  ecdao.findListAuteur(lec);
     listlist.add(laute);
    // listaut=laut;
        }
        
           System.out.println("list auteur "+ listlist);*/
            ArrayList le= autdao.findListEcrireByPublication((Publication)  listpub.get(0));
            //System.out.println(" le "+le);
     ArrayList laut=  ecdao.findListAuteur(le);
     listaut=laut;
     for (int i=0;i<listpub.size();i++)
           System.out.println("pub "+listpub.get(i).getIdPub());
           System.out.println(" list aut "+laut);
      // System.out.println("auteur "+laut);
        for(int i=0;i<listpub.size();i++)
        { ArrayList lec= autdao.findListEcrireByPublication((Publication)  listpub.get(i));
     ArrayList laute=  ecdao.findListAuteur(lec);
     listlist.add(laute);
        }
           
         String or,ad,booktitle;
        for(int i=0;i<listpub.size();i++)
        {
            if(((Publication)listpub.get(i)).getType().equals("Article"))
            { typeimage.add("violetcarres.png");
            listtype.add(((Publication)listpub.get(i)).getJournal()+"   "+((Publication)listpub.get(i)).getPagedeb()+"-"+((Publication)listpub.get(i)).getPagefin());
            }
            
            if(((Publication)listpub.get(i)).getType().equals("Conference"))
            { typeimage.add("rougecarres.jpg");
            if(((Publication)listpub.get(i)).getOrganisation()==null)
               or="";
            else
             or=((Publication)listpub.get(i)).getOrganisation();
            if(((Publication)listpub.get(i)).getAdresse()==null)
               ad="";
            else
             ad=((Publication)listpub.get(i)).getAdresse();
            if(((Publication)listpub.get(i)).getBooktitle()==null)
               booktitle="";
            else
             booktitle=((Publication)listpub.get(i)).getBooktitle();
             listtype.add(or+"  "+booktitle+"  "+ad+" "+((Publication)listpub.get(i)).getPagedeb()+"-"+((Publication)listpub.get(i)).getPagefin());
            
            }
        }
      
       }
       
    }
    
    public ArrayList listauteur(int i)
    {
        System.out.println("i "+i);
        ArrayList laut=new ArrayList();
        ArrayList le= autdao.findListEcrireByPublication((Publication)  ecdao.findListPublication(listec).get(i));
      laut=  ecdao.findListAuteur(le);
     listaut=laut;
     return laut;
    }
}
