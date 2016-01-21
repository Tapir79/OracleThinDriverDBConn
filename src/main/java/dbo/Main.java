/*
 * TNSNAMES.ORA 

    MYDB =
  
    (DESCRIPTION =
  
      (ADDRESS = (PROTOCOL = TCP)(HOST = YOUR.HOST.IP.XX)(PORT = PORTNUMBER))
  
      (CONNECT_DATA = (SID = DBSID)
      )
  
    )
 */
package dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Saara
 */
public class Main {
  
    public static void main(String[] args) throws Exception {  
    
   Class.forName("oracle.jdbc.driver.OracleDriver");
        String jdbcUrl = "jdbc:oracle:thin:@YOUR.HOST.IP.XX:PORTNUMBER:DBSID";
        String username = "username";
        String password = "password";
 
    Connection connection = null;

    try {
        System.out.println("Connecting database...");
        connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Database connected!");
        String result = query(connection);
        System.out.println(result);

        } catch ( SQLException e ) {
            throw new RuntimeException("Cannot connect the database!", e);
        } finally {
            System.out.println("Closing the connection.");
            if ( connection != null ) try { connection.close(); } catch ( SQLException ignore ) {}
        }   

    }    
    
    /**
     * 
     * @param connection
     * @return
     * @throws SQLException 
     */
    
    private static String query(Connection connection) throws SQLException{
 
        String query="";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT 1 FROM dual");
 
        while( resultSet.next() ) {
            
            int id = resultSet.getInt("1");
            query = query + id + "\t" + id + "\n";
        }
        return query;
    }

}

  

