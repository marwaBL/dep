package modele;
// Generated 1 juin 2014 14:56:19 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ObtenirId generated by hbm2java
 */
@Embeddable
public class ObtenirId  implements java.io.Serializable {


     private int idCh;
     private int idD;
     private int codeEtab;

    public ObtenirId() {
    }

    public ObtenirId(int idCh, int idD, int codeEtab) {
       this.idCh = idCh;
       this.idD = idD;
       this.codeEtab = codeEtab;
    }
   

    @Column(name="IdCh", nullable=false)
    public int getIdCh() {
        return this.idCh;
    }
    
    public void setIdCh(int idCh) {
        this.idCh = idCh;
    }

    @Column(name="Id_D", nullable=false)
    public int getIdD() {
        return this.idD;
    }
    
    public void setIdD(int idD) {
        this.idD = idD;
    }

    @Column(name="CodeEtab", nullable=false)
    public int getCodeEtab() {
        return this.codeEtab;
    }
    
    public void setCodeEtab(int codeEtab) {
        this.codeEtab = codeEtab;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ObtenirId) ) return false;
		 ObtenirId castOther = ( ObtenirId ) other; 
         
		 return (this.getIdCh()==castOther.getIdCh())
 && (this.getIdD()==castOther.getIdD())
 && (this.getCodeEtab()==castOther.getCodeEtab());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdCh();
         result = 37 * result + this.getIdD();
         result = 37 * result + this.getCodeEtab();
         return result;
   }   


}


