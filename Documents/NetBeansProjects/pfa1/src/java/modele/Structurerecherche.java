package modele;
// Generated 1 juin 2014 14:56:19 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Structurerecherche generated by hbm2java
 */
@Entity
@Table(name="structurerecherche"
    ,catalog="pfa1"
)
public class Structurerecherche  implements java.io.Serializable {


     private String code;
     private Chercheur chercheur;
     private Etablissement etablissement;
     private String denomination;
     private String type;
     private String discipline;
     private String site;
     private Date dateDeb;
     private Date dateFin;
     private Set<Inscription> inscriptions = new HashSet<Inscription>(0);
     private Set<Chercheur> chercheurs = new HashSet<Chercheur>(0);

    public Structurerecherche() {
    }

	
    public Structurerecherche(String code, Chercheur chercheur, Etablissement etablissement, Date dateDeb, Date dateFin) {
        this.code = code;
        this.chercheur = chercheur;
        this.etablissement = etablissement;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }
    public Structurerecherche(String code, Chercheur chercheur, Etablissement etablissement, String denomination, String type, String discipline, String site, Date dateDeb, Date dateFin, Set<Inscription> inscriptions, Set<Chercheur> chercheurs) {
       this.code = code;
       this.chercheur = chercheur;
       this.etablissement = etablissement;
       this.denomination = denomination;
       this.type = type;
       this.discipline = discipline;
       this.site = site;
       this.dateDeb = dateDeb;
       this.dateFin = dateFin;
       this.inscriptions = inscriptions;
       this.chercheurs = chercheurs;
    }
   
     @Id 
    
    @Column(name="Code", unique=true, nullable=false, length=254)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdCh", nullable=false)
    public Chercheur getChercheur() {
        return this.chercheur;
    }
    
    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CodeEtab", nullable=false)
    public Etablissement getEtablissement() {
        return this.etablissement;
    }
    
    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
    
    @Column(name="Denomination", length=254)
    public String getDenomination() {
        return this.denomination;
    }
    
    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }
    
    @Column(name="Type", length=254)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="Discipline", length=254)
    public String getDiscipline() {
        return this.discipline;
    }
    
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    
    @Column(name="Site", length=254)
    public String getSite() {
        return this.site;
    }
    
    public void setSite(String site) {
        this.site = site;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DateDeb", nullable=false, length=19)
    public Date getDateDeb() {
        return this.dateDeb;
    }
    
    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DateFin", nullable=false, length=19)
    public Date getDateFin() {
        return this.dateFin;
    }
    
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="structurerecherche")
    public Set<Inscription> getInscriptions() {
        return this.inscriptions;
    }
    
    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="structurerecherche")
    public Set<Chercheur> getChercheurs() {
        return this.chercheurs;
    }
    
    public void setChercheurs(Set<Chercheur> chercheurs) {
        this.chercheurs = chercheurs;
    }

    @Override
    public String toString() {
        return  denomination ;
    }




}


