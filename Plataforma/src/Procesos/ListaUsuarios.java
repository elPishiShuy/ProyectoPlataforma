/*
 * ****PLATAFORMA SHUY VERSION****
 * -VALOR Y CONFIANZA-
 * Software desarrollado completamente en las poderosas manos de Jose Jesus Garcia Cuadra
 */
package Procesos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chuy
 */
public class ListaUsuarios {

    ArrayList<Usuario> lista;

    public ListaUsuarios() {
        this.lista = cargarUsuarios();
        
        
    }

    private ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        ConectorDB conn = new ConectorDB();
        String sql = "SELECT * FROM usuarios";

        try {
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Usuario al = new Usuario(
                        rs.getString("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("password"),
                        rs.getString("tipo")
                );
                lista.add(al);
            }
            rs.close();
            st.close();
            conn.desconectar();

        } catch (Exception e) {

        }
        return lista;
    }

    public boolean alreadyExist(String ID) {

        ArrayList<Usuario> temp = this.lista;

        while (!temp.isEmpty()) {
            Usuario temporal = temp.remove(0);

            if (temporal.getID().equals(ID)) {
                return true;
            }

        }
        return false;
    }

    public void Update() {
        this.lista = null;
        this.lista = cargarUsuarios();
    }

}
