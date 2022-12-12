import org.apache.xmlrpc.webserver.ServletWebServer;
import org.apache.xmlrpc.webserver.XmlRpcServlet;

public class XmlRpcServer {
	public static void main(String[] args) throws Exception {
		XmlRpcServlet servlet = new XmlRpcServlet();
        ServletWebServer webServer = new ServletWebServer(servlet, 1000);
        webServer.start();		
		System.out.println("Server XML-RPC zapushen...");
		System.out.println("Ojidanie zaprosa klienta...");
	}
}