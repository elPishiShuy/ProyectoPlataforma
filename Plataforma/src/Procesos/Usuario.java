/*
 * ****PLATAFORMA SHUY VERSION****
 * -VALOR Y CONFIANZA-
 * Software desarrollado completamente en las poderosas manos de Jose Jesus Garcia Cuadra
 */
package Procesos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Chuy
 */
public class Usuario {

    private String idUsuario;
    private String nombre;
    private String pass;
    private String tipo;

    public Usuario(String idUsuario, String nombre, String pass, String tipo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.pass = pass;
        this.tipo = tipo;

    }

    public void setID(String ID) {
        this.idUsuario = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(char[] pass) {
        this.pass = String.valueOf(pass);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getID() {
        return this.idUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPass() {
        return this.pass;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void agregarDB() {
        ConectorDB puente = new ConectorDB();

        ListaUsuarios lista = new ListaUsuarios();

        if (lista.alreadyExist(this.idUsuario)) {

            JOptionPane.showMessageDialog(null, "El usuario que intenta crear ya existe, intente con uno nuev", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            try {

                PreparedStatement stmt = puente.conn.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?)");

                stmt.setString(1, getID());
                stmt.setString(2, getNombre());
                stmt.setString(3, getPass());
                stmt.setString(4, getTipo());

                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Se ha registrado el usuario");

                puente.conn.close();
                puente.desconectar();

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "No se registro la persona " + e);
                System.out.println(e);

            }
        }
    }
}
