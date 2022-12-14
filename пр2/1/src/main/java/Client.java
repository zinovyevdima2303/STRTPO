import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

public class Client {
    private Vector<String> list = null;
    private XmlRpcClient client = null;

    public Client() throws MalformedURLException {
        client = new XmlRpcClient("http://localhost:3000/RPC");
        list = new Vector<String>();
    }

    void inputData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = in.nextLine();
        System.out.println("Введите телефон: ");
        String phone = in.nextLine();

        list.add(name);
        list.add(surname);
        list.add(phone);

        try {
            client.execute("4pr.insertImp", list);
        }
        catch (XmlRpcException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        list = null;
    }

    public static void main(String[] args) throws MalformedURLException {
        Client client = new Client();
        client.inputData();
    }
}
