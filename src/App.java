import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/training";
        String username = "root";
        String password = "kalaipriyan0007"; 
        // String dbname = "Newone";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL!");
            Statement stmt = conn.createStatement();
            // String query = "CREATE DATABASE IF NOT EXISTS " + dbname;
            // stmt.executeUpdate(query);
 String createTable = "CREATE TABLE IF NOT EXISTS newone ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100), "
                    + "age INT, "
                    + "mark INT, "
                    + "course_id INT)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully");
            String InsertQuery = ("insert into detail values(?,?,?,?,?)");
            PreparedStatement stmts = conn.prepareStatement(InsertQuery);
            stmts.setInt(1,1991);
            stmts.setString(2, "Moulee");
            stmts.setInt(3, 20);
            stmts.setInt(4, 90);
            stmts.setInt(5,100);
            int rowInserted = stmts.executeUpdate();
            System.out.println("Inserted"+rowInserted);
            ResultSet res = stmt.executeQuery("select * from detail");
            while(res.next()){
                System.out.println(res.getInt("id")+"  "+res.getString("name")+"  "+res.getInt("course_id")+"  "+res.getInt("mark")+"  "+res.getInt("age")+"  ");
            }
            // System.out.println("Database created or already exists.");\
            stmt.close();
            stmts.close();
            conn.close();
            res.close();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
    }
}
