import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static Connection conn = null;
    public static Connection connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/employee";
            String user = "root";
            String password = "1rn22is065@Rnsit";

            conn = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
