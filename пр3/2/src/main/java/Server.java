import javax.naming.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, NamingException {
        LocateRegistry.createRegistry(3000);
        Sklad sklad = new SkladEmp();
        Context context = new InitialContext();
        context.bind("rmi://localhost:3000/sklad", sklad);
    }
}
