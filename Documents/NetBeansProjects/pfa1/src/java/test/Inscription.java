package test;
// Generated 18 avr. 2014 00:52:28 by Hibernate Tools 3.2.1.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Inscription generated by hbm2java
 */
@Entity
@Table(name="inscription"
    ,catalog="pfa1"
)
public class Inscription  implements java.io.Serializable {


     private InscriptionId id;
     private Chercheur chercheur;
     private Structurerecherche structurerecherche;
     private String etat;

    public Inscription() {
    }

	
    public Inscription(InscriptionId id, Chercheur chercheur, Structurerecherche structurerecherche) {
        this.id = id;
        this.chercheur = chercheur;
        this.structurerecherche = structurerecherche;
    }
    public Inscription(InscriptionId id, Chercheur chercheur, Structurerecherche structurerecherche, String etat) {
       this.id = id;
       this.chercheur = chercheur;
       this.structurerecherche = structurerecherche;
       this.etat = etat;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idCh", column=@Column(name="IdCh", nullable=false) ), 
        @AttributeOverride(name="code", column=@Column(name="Code", nullable=false, length=254) ) } )
    public InscriptionId getId() {
        return this.id;
    }
    
    public void setId(InscriptionId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdCh", nullable=false, insertable=false, updatable=false)
    public Chercheur getChercheur() {
        return this.chercheur;
    }
    
    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Code", nullable=false, insertable=false, updatable=false)
    public Structurerecherche getStructurerecherche() {
        return this.structurerecherche;
    }
    
    public void setStructurerecherche(Structurerecherche structurerecherche) {
        this.structurerecherche = structurerecherche;
    }
    
    @Column(name="Etat", length=254)
    public String getEtat() {
        return this.etat;
    }
    
    public void setEtat(String etat) {
        this.etat = etat;
    }




}


