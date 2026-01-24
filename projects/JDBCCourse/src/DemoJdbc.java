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
        int cust_id = 8;
        String cust_name = "Lewis";
        String insertQuery = "INSERT INTO customers VALUES(?, ?)";
        String fetchQuery = "SELECT * FROM customers";
//      Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(url, uName, password)){
            System.out.println("Database connected successfully!\n");

            Statement st = con.createStatement();
            PreparedStatement prepSt = con.prepareStatement(insertQuery);

            prepSt.setInt(1, cust_id);
            prepSt.setString(2, cust_name);
            prepSt.execute();

            ResultSet rs = st.executeQuery(fetchQuery);

            System.out.println("cust_id - cust_name");
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
