/*
 * ****PLATAFORMA SHUY VERSION****
 * -VALOR Y CONFIANZA-
 * Software desarrollado completamente en las poderosas manos de Jose Jesus Garcia Cuadra
 */
package Procesos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Chuy
 */
public class Curso {

    String idcurso;
    String materia;
    String profesor;
    String turno;
    Random ran = new Random();
    
    public Curso(String materia, String profesor, String turno) {
        this.idcurso= String.valueOf(ran.nextInt(1000));
        this.materia = materia;
        this.profesor = profesor;
        this.turno = turno;
    }

    public Curso(String idcurso, String materia, String profesor, String turno) {
        this.idcurso = idcurso;
        this.materia = materia;
        this.profesor = profesor;
        this.turno = turno;
    }

    public String[] getRow() {
        String a[] = {idcurso, materia, profesor, turno};
        return a;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getID(){
        return this.idcurso;
    }
    
    public String getMateria() {
        return this.materia;
    }

    public String getProfesor() {
        return this.profesor;
    }

    public String getTurno() {
        return this.turno;
    }

    public void agregarDB() {
        ConectorDB puente = new ConectorDB();

        // ListaUsuarios lista = new ListaUsuarios();
//        if (lista.alreadyExist(this.idUsuario)) {
//
//            JOptionPane.showMessageDialog(null, "El usuario que intenta crear ya existe, intente con uno nuev", "Error", JOptionPane.ERROR_MESSAGE);
//
//        } else {
        try {

            PreparedStatement stmt = puente.conn.prepareStatement("INSERT INTO cursos VALUES (?,?,?,?)");

            stmt.setString(1, getID());
            stmt.setString(2, getMateria());
            stmt.setString(3, getProfesor());
            stmt.setString(4, getTurno());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se ha registrado el curso");

            puente.conn.close();
            puente.desconectar();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se registro el curso " + e);
            System.out.println(e);

        }
        //}
    }
}
