/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Juan Luis
 */
public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/el_lavadero";
    private static final String USER = "juanl";
    private static final String PASSWORD = "juanl";

    public static Connection getConnection() throws SQLException {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        //Class.forName("com.mysql.jdbc.Driver");
        //return DriverManager.getConnection(URL, USER, PASSWORD);
        return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
