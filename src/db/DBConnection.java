package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dBConnection;
    private Connection connection;
    
    
    private  DBConnection ()throws  ClassNotFoundException,SQLException{
         Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "200202600942");
    }
    
    public static DBConnection getInstance()throws  ClassNotFoundException,SQLException{
        if(dBConnection == null){
            dBConnection=new DBConnection();
        }
        
        return dBConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
}
