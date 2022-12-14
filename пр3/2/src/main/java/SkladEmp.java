import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class SkladEmp extends UnicastRemoteObject implements Sklad {

    public SkladEmp() throws RemoteException { }

    @Override
    public String getData() throws RemoteException {
        Connect connect = new Connect();
        return connect.getData();
    }
}