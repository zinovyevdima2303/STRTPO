import org.apache.xmlrpc.WebServer;

public class Main {
    public static void main(String[] args) {
        WebServer webServer = new WebServer(3000);
        webServer.addHandler("4pr", new Connect());
        webServer.start();
    }
}