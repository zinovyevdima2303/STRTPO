import java.sql.*;
import java.util.Vector;

public class WebService {
	public int add(int x, int y) {
		return x + y;
	}
	
	public Vector getItems() throws ClassNotFoundException{
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:database.db");
		}
		catch (SQLException e){
			System.out.println("Oshibka");
			e.printStackTrace();
			return null;
		}
		System.out.println("");
		
		Vector items = new Vector();
		try {
			Statement statment = con.createStatement();
			String query = "SELECT ID, Name, Price FROM Items";
			ResultSet rs = statment.executeQuery(query);
			while(rs.next())
			{
				items.addElement(new Object[] { rs.getString("ID"), rs.getString("Name"), rs.getString("Price") });
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
}
