package test;
// Generated 18 avr. 2014 00:52:28 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EcrireId generated by hbm2java
 */
@Embeddable
public class EcrireId  implements java.io.Serializable {


     private int idPub;
     private int idAut;

    public EcrireId() {
    }

    public EcrireId(int idPub, int idAut) {
       this.idPub = idPub;
       this.idAut = idAut;
    }
   

    @Column(name="IdPub", nullable=false)
    public int getIdPub() {
        return this.idPub;
    }
    
    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    @Column(name="IdAut", nullable=false)
    public int getIdAut() {
        return this.idAut;
    }
    
    public void setIdAut(int idAut) {
        this.idAut = idAut;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EcrireId) ) return false;
		 EcrireId castOther = ( EcrireId ) other; 
         
		 return (this.getIdPub()==castOther.getIdPub())
 && (this.getIdAut()==castOther.getIdAut());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPub();
         result = 37 * result + this.getIdAut();
         return result;
   }   


}


