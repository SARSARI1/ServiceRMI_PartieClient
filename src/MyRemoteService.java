import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyRemoteService extends Remote {
    boolean ajouterLivre(Livre livre)throws RemoteException;

    Livre RechercheLivre(String nom)throws RemoteException;
    List<Livre> ListerLivres()throws RemoteException;
}