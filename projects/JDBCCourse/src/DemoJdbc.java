import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) {
        /*
        Step 0 - Import and load packages
        Step 1 - Register driver class
        Step 2 - Create Connection
        Step 3 - Create Statement
        Step 4 - Execute Statement
        Step 5 - Close Connection
        */
        String url = "jdbc:postgresql://localhost:5432/store_db";
        String uName = "postgres";
        String password = "akstlm10";
//            Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection(url, uName, password)){
            System.out.println("Database connected successfully!\n");

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM customers";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int id = rs.getInt("cust_id");
                String name = rs.getString("cust_name");
                System.out.println(id + " - " + name + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
