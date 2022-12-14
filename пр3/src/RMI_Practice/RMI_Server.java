package RMI_Practice;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server extends UnicastRemoteObject implements RMI_Interface {

	public RMI_Server() throws RemoteException {
		super();
	}

	@Override
	public String GetData() throws RemoteException {
		DBReader DBReader = new DBReader();
		String result;
		try {
			result = DBReader.getItems();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
            return e.toString();
		}
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		try {
			Registry registry = LocateRegistry.createRegistry(7777);
			registry.bind("RMIPractice", new RMI_Server());
			System.out.println("RMI Server is running...");
		}
		catch (Exception e) {
			System.out.println("ERROR: RMI Server is not running");
		}
	}

}
