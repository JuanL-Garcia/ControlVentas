/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import DBConfiguration.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Juan Luis
 */
public class LoginProcess {
    
    private String passString;
    private boolean resultConnection;
    /*
    * Constructor de la clase
    */
    public LoginProcess(String username, char[] pass){
        this.passString = new String(pass);
        
        // ¡IMPORTANTE! Limpiar el arreglo de caracteres después de usarlo:
        for (int i = 0; i < pass.length; i++) {
            pass[i] = '\0'; // Reemplazar cada carácter con un carácter nulo
        }
        
        
        
        if (this.verificarUsuario(username, passString)) {
            resultConnection = true;
        } else {
            resultConnection = false;
        }
        
        
    }
    
    public static boolean verificarUsuario(String username, String password) {
        String query = "SELECT pass FROM users WHERE username = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("pass");
                return BCrypt.checkpw(password, hashedPassword); // Verifica la contraseña
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Usuario no encontrado o contraseña incorrecta
    }
    
    public boolean getResultConnection(){
        return this.resultConnection;
    }
}
