package RMI_Practice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_Interface extends Remote {
	String GetData() throws RemoteException;
}
