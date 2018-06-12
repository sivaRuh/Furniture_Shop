package Common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBconnection {
    
    public Statement stmt;
    public ResultSet res;
    public Connection con;
    
    public DBconnection(){
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/furniture_shop","root","");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
         return con;
        
    }
     
     
}
