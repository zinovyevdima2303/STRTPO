import java.rmi.Remote;
import java.rmi.RemoteException;

interface Sklad extends Remote {
    String getData() throws RemoteException;
}