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
public class ListaCursos {

    public ArrayList<Curso> lista;

    public ListaCursos(){
        this.lista=cargarUsuarios();
    }
    
    
        private ArrayList<Curso> cargarUsuarios() {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        ConectorDB conn = new ConectorDB();
        String sql = "SELECT * FROM cursos";

        try {
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Curso cur = new Curso(
                        rs.getString("idcursos"),
                        rs.getString("materia"),
                        rs.getString("profesor"),
                        rs.getString("turno")
                );
                lista.add(cur);
            }
            rs.close();
            st.close();
            conn.desconectar();

        } catch (Exception e) {

        }
        return lista;
    }
}
