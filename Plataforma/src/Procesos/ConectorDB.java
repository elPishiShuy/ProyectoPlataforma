/*
 * ****PLATAFORMA SHUY VERSION****
 * -VALOR Y CONFIANZA-
 * Software desarrollado completamente en las poderosas manos de Jose Jesus Garcia Cuadra
 */
package Procesos;

/**
 *
 * @author Chuy
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class ConectorDB {
    
    static String bd = "db";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;
    
    Connection conn = null;

    public ConectorDB() {
    try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         
//obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
 
         if (conn == null){
            JOptionPane.showMessageDialog(null, "Error al abrir la BD" + bd);
         }else{
         }
      }
      catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Fue aqui: " + e);
      } catch(ClassNotFoundException e){
         JOptionPane.showMessageDialog(null, "Fue aca: " + e);
      } catch(Exception e){
         JOptionPane.showMessageDialog(null, "Fue aculla: " + e);
      }
    }
    
    // Método que devuelve la referencia a la conexión
    public Connection getConnection() {
        return conn;
    }
    
    public void desconectar() {
        conn = null;
    }
    
}
