package test;
// Generated 18 avr. 2014 00:52:28 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Publication generated by hbm2java
 */
@Entity
@Table(name="publication"
    ,catalog="pfa1"
)
public class Publication  implements java.io.Serializable {


     private Integer idPub;
     private String titre;
     private Integer annee;
     private Integer mois;
     private String note;
     private String cle;
     private String howpub;
     private String adresse;
     private String journal;
     private Integer pagedeb;
     private Integer pagefin;
     private Integer volume;
     private Integer nombre;
     private String edition;
     private String chapitre;
     private String serie;
     private String booktitle;
     private String organisation;
     private String type;
     private String etablissement;
     private String typeRapport;
     private Set<Ecrire> ecrires = new HashSet<Ecrire>(0);

    public Publication() {
    }

    public Publication(String titre, Integer annee, Integer mois, String note, String cle, String howpub, String adresse, String journal, Integer pagedeb, Integer pagefin, Integer volume, Integer nombre, String edition, String chapitre, String serie, String booktitle, String organisation, String type, String etablissement, String typeRapport, Set<Ecrire> ecrires) {
       this.titre = titre;
       this.annee = annee;
       this.mois = mois;
       this.note = note;
       this.cle = cle;
       this.howpub = howpub;
       this.adresse = adresse;
       this.journal = journal;
       this.pagedeb = pagedeb;
       this.pagefin = pagefin;
       this.volume = volume;
       this.nombre = nombre;
       this.edition = edition;
       this.chapitre = chapitre;
       this.serie = serie;
       this.booktitle = booktitle;
       this.organisation = organisation;
       this.type = type;
       this.etablissement = etablissement;
       this.typeRapport = typeRapport;
       this.ecrires = ecrires;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="IdPub", unique=true, nullable=false)
    public Integer getIdPub() {
        return this.idPub;
    }
    
    public void setIdPub(Integer idPub) {
        this.idPub = idPub;
    }
    
    @Column(name="Titre", length=254)
    public String getTitre() {
        return this.titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    @Column(name="annee")
    public Integer getAnnee() {
        return this.annee;
    }
    
    public void setAnnee(Integer annee) {
        this.annee = annee;
    }
    
    @Column(name="mois")
    public Integer getMois() {
        return this.mois;
    }
    
    public void setMois(Integer mois) {
        this.mois = mois;
    }
    
    @Column(name="note", length=254)
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    @Column(name="cle", length=254)
    public String getCle() {
        return this.cle;
    }
    
    public void setCle(String cle) {
        this.cle = cle;
    }
    
    @Column(name="howpub", length=254)
    public String getHowpub() {
        return this.howpub;
    }
    
    public void setHowpub(String howpub) {
        this.howpub = howpub;
    }
    
    @Column(name="adresse", length=254)
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    @Column(name="journal", length=254)
    public String getJournal() {
        return this.journal;
    }
    
    public void setJournal(String journal) {
        this.journal = journal;
    }
    
    @Column(name="pagedeb")
    public Integer getPagedeb() {
        return this.pagedeb;
    }
    
    public void setPagedeb(Integer pagedeb) {
        this.pagedeb = pagedeb;
    }
    
    @Column(name="pagefin")
    public Integer getPagefin() {
        return this.pagefin;
    }
    
    public void setPagefin(Integer pagefin) {
        this.pagefin = pagefin;
    }
    
    @Column(name="volume")
    public Integer getVolume() {
        return this.volume;
    }
    
    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    
    @Column(name="nombre")
    public Integer getNombre() {
        return this.nombre;
    }
    
    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="edition", length=254)
    public String getEdition() {
        return this.edition;
    }
    
    public void setEdition(String edition) {
        this.edition = edition;
    }
    
    @Column(name="chapitre", length=254)
    public String getChapitre() {
        return this.chapitre;
    }
    
    public void setChapitre(String chapitre) {
        this.chapitre = chapitre;
    }
    
    @Column(name="serie", length=254)
    public String getSerie() {
        return this.serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    @Column(name="booktitle", length=254)
    public String getBooktitle() {
        return this.booktitle;
    }
    
    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
    
    @Column(name="organisation", length=254)
    public String getOrganisation() {
        return this.organisation;
    }
    
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
    
    @Column(name="type", length=254)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="etablissement", length=254)
    public String getEtablissement() {
        return this.etablissement;
    }
    
    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }
    
    @Column(name="typeRapport", length=254)
    public String getTypeRapport() {
        return this.typeRapport;
    }
    
    public void setTypeRapport(String typeRapport) {
        this.typeRapport = typeRapport;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="publication")
    public Set<Ecrire> getEcrires() {
        return this.ecrires;
    }
    
    public void setEcrires(Set<Ecrire> ecrires) {
        this.ecrires = ecrires;
    }




}


