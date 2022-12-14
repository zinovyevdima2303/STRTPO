import java.sql.*;

public class Connect {
    private Connection connect;

    public Connect() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:src/main/resources/organization.db");
        }
        catch (SQLException e) {
            System.out.println("Ошибка подключения БД: " + e.getMessage());
        }
    }

    public String insertImp(String name, String surname, String phone) {
        String SQLQuery = "INSERT INTO listEmp VALUES (null, ?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(SQLQuery);
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, phone);
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Новый сотрудник был добавлен";
    }

    public String getData() {
        String SQLQuery = "SELECT * FROM listEmp";
        String res = null;

        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(SQLQuery);

            while (rs.next()) {
                res += rs.getString("name") + " " + rs.getString("surname") + " Номер телефона: " + rs.getString("phone") + "\n";
            }

            st.close();
            rs.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return res;
    }
}
