/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psc.projetoa3;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author d4rkwav3
 */
public class BaseDeDados {
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "gefico_a3";
    private static String usuario = "root";
    private static String senha = "5481";
    
    public static Connection conectar() throws Exception {
        String url = String.format("jdbc:mysql://%s:%s/%s", host, porta, db);
        return DriverManager.getConnection(url, usuario, senha);
    }
}
