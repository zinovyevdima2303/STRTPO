import javax.naming.*;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context context = new InitialContext();
        Sklad sklad = (Sklad)context.lookup("rmi://localhost:3000/sklad");
        System.out.println(sklad.getData());
    }
}
