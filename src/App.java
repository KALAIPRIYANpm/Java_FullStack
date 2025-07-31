
import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/training";
        String username = "root";
        String password = "kalaipriyan0007"; 

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL!");
            Statement name = conn.createStatement();
            String InsertQuery = ("insert into detail values(?,?,?,?,?)");
            PreparedStatement stmt = conn.prepareStatement(InsertQuery);
            stmt.setInt(1, 108);  
            stmt.setString(2, "Kalaipriyan");
            stmt.setInt(3, 12);
            stmt.setInt(4, 20);
            stmt.setInt(5, 20);
            int rowInserted = stmt.executeUpdate();
            System.out.println("inserted"+rowInserted);
            ResultSet res=name.executeQuery(" select * from detail");

            while(res.next()){
                System.out.println(res.getInt("id")+" "+ res.getString("name")+" "+res.getInt("course_id")+" "+res.getInt("mark")+" "+res.getInt("age"));
            }

            name.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection failed!");   
            e.printStackTrace();
        }
    }
}

