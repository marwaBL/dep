/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author USER1
 */

    import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;



public interface clientInterface extends Remote {
 public void afficher(Client e) throws RemoteException;
 public void ajouter(Client e) throws RemoteException;
public String callMeBack() throws RemoteException;
// public Client chercher (String nom,String bd) throws RemoteException;
 public ArrayList chercher (String nom) throws RemoteException;
// public void supprimer (String nom,String bd) throws RemoteException;
 public void supprimer (Client emp) throws RemoteException;
 public void MAJ (Client emp) throws RemoteException;


}
