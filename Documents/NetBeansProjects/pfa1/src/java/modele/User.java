package modele;
// Generated 1 juin 2014 14:56:19 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="pfa1"
)
public class User  implements java.io.Serializable {


     private UserId id;
     private String type;
     private Date dateinscription;
     private Set<Chercheur> chercheurs = new HashSet<Chercheur>(0);

    public User() {
    }

	
    public User(UserId id) {
        this.id = id;
    }
    public User(UserId id, String type, Date dateinscription, Set<Chercheur> chercheurs) {
       this.id = id;
       this.type = type;
       this.dateinscription = dateinscription;
       this.chercheurs = chercheurs;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="passwd", column=@Column(name="Passwd", nullable=false, length=254) ), 
        @AttributeOverride(name="login", column=@Column(name="Login", nullable=false, length=254) ) } )
    public UserId getId() {
        return this.id;
    }
    
    public void setId(UserId id) {
        this.id = id;
    }
    
    @Column(name="type", length=254)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="dateinscription", length=10)
    public Date getDateinscription() {
        return this.dateinscription;
    }
    
    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
    public Set<Chercheur> getChercheurs() {
        return this.chercheurs;
    }
    
    public void setChercheurs(Set<Chercheur> chercheurs) {
        this.chercheurs = chercheurs;
    }




}


