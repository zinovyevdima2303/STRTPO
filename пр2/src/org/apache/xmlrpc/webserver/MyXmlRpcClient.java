package org.apache.xmlrpc.webserver;


import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

public class MyXmlRpcClient {
	
	public static void main(String[] args) throws Exception {
	    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	    config.setServerURL(new URL("http://localhost:1000"));
	    XmlRpcClient client = new XmlRpcClient();
	    client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
	    client.setConfig(config);
	    
	    Object[] results = (Object[]) client.execute("Service.getItems", new Object[0]);
	    System.out.println("Tekushii spisok tovarov: ");
	    System.out.println(Arrays.deepToString(results));
	}

}
