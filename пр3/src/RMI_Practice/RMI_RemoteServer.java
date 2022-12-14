package RMI_Practice;

import java.rmi.RemoteException;

public class RMI_RemoteServer implements RMI_Interface {
	
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
}
