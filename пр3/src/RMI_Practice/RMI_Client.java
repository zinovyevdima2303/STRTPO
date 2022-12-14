package RMI_Practice;

import java.rmi.Naming;

public class RMI_Client {

	public static void main(String[] args) {
		try {
			RMI_Interface RMIpractice = (RMI_Interface) Naming.lookup("rmi://localhost:7777/RMIPractice");
			String multiplyResult = RMIpractice.GetData();
	        System.out.println("Результат запроса со склада: \n" + multiplyResult);
		} catch (Exception e) {
			System.out.println("ERROR: RMI Server is not running");
			e.printStackTrace();
		}
	}

}
