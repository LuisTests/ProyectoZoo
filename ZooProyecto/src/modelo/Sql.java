/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author beatl
 */
public class Sql extends Conexion{
    private static String sql;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;
    
    public static boolean registrarVeterinario(Veterinario vet) {
        try {
            
            sql = "INSERT INTO veterinario (VET_cedula,VET_correo,VET_telefono,VET_nombre,VET_nombre2,VET_apellido1,VET_apellido2) VALUES (?,?,?,?,?,?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, vet.getCedulaProfesional());
            ps.setString(2, vet.getCorreo());
            ps.setString(3, vet.getTelefono());
            ps.setString(4, vet.getNombre());
            ps.setString(5, vet.getNombre2());
            ps.setString(6, vet.getApellido1());
            ps.setString(7, vet.getApellido2());
           
            ps.execute();
            return true;
        } catch (Exception e) {
               System.out.println(e);
            return false;
        }
    }
    
    public static boolean registrarAnimal(Animal ani){
         try {
            
            sql = "INSERT INTO animal (ANI_CuidadorID,ANI_HabitatID,ANI_Nombre,ANI_Alimentacion,ANI_Anyo_cautiverio,ANI_Especie,ANI_Sexo,ANI_Edad,ANI_Peso,ANI_Observaciones) VALUES (?,?,?,?,?,?,?,?,?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,ani.getIdCuidador());
            ps.setInt(2, ani.getIdHabitat());
            ps.setString(3, ani.getNombre());
            ps.setString(4, ani.getAlimentacion());
            ps.setInt(5,ani.getAnyoCautiverio());
            ps.setString(6, ani.getEspecie());
            ps.setString(7, ani.getSexo());
            ps.setInt(8, ani.getEdad());
            ps.setFloat(9, ani.getPeso());
            ps.setString(10, ani.getObservaciones());
            ps.execute();
            if(ani.getProcedencia() == 1){
                sql = "INSERT INTO Procedencia_Local () values";
            }
           
            
            return true;
        } catch (Exception e) {
               System.out.println(e);
            return false;
        }
    }
    public static ArrayList<Cuidador> verCuidadores(){
        ArrayList<Cuidador> cuidadores = new ArrayList<>();
        Cuidador c = new Cuidador();
        try {
            sql = "SELECT * FROM cuidador";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                c = new Cuidador();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setNombre2(rs.getString(3));
                c.setApellido1(rs.getString(4));
                c.setApellido2(rs.getString(5));
                c.setSueldo(rs.getFloat(6));
                cuidadores.add(c);
            
               
            }
            
            return cuidadores;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
            System.out.println(e);
            return cuidadores;
        }
    }

    public static ArrayList<Veterinario> verVeterinarios() {
        ArrayList<Veterinario> veterinarios = new ArrayList<>();
        Veterinario v = new Veterinario();
        try {
            sql = "SELECT * FROM veterinario";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                v = new Veterinario();
                v.setId(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setNombre2(rs.getString(3));
                v.setApellido1(rs.getString(4));
                v.setApellido2(rs.getString(5));
                v.setCorreo(rs.getString(6));
                v.setCedulaProfesional(rs.getString(7));
                v.setTelefono(rs.getString(8));
                veterinarios.add(v);
            }

            return veterinarios;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
            System.out.println(e);
            return veterinarios;
        }
    }

    public static ArrayList<Habitat> verHabitat() {
        ArrayList<Habitat> habitats = new ArrayList<>();
        Habitat h = new Habitat();
        try {
            sql = "SELECT * FROM Habitat";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                h = new Habitat();
                h.setId(rs.getInt(1));
                h.setClimaId(rs.getInt(2));
                h.setCuidadorId(rs.getInt(3));
                h.setNombre(rs.getString(4));
           
                habitats.add(h);
            }

            return habitats;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
            System.out.println(e);
            return habitats;
        }
    }
    public static ArrayList<RegistroONG> verActividades() {
        ArrayList<RegistroONG> actividades = new ArrayList<>();
        RegistroONG r = new RegistroONG();
        try {
            sql = "SELECT * FROM Registro_ONG";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                r = new RegistroONG();
                r.setActividadId(rs.getInt(1));
                r.setAprobacion(rs.getString(2));
                r.setOngNombre(rs.getString(3));
                r.setNombreActividad(rs.getString(4));
                r.setDescripcionActividad(rs.getString(5));
                r.setFechaSolicitud(rs.getDate(6));
                r.setHoraApertura(rs.getString(7));
                r.setHoraCierre(rs.getString(8));
                r.setHabitatId(rs.getInt(9));
           
                actividades.add(r);
            }

            return actividades;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de consulta");
            System.out.println(e);
            return actividades;
        }
    }
    
    public static boolean registrarActividad(RegistroONG rong,Habitat ht) {
        long d = rong.getFechaSolicitud().getTime();
        java.sql.Date FechaSolicitud = new java.sql.Date(d);
        
        if(verActividades().isEmpty()){
                rong.setActividadId(1);
        }else{
              rong.setActividadId((verActividades().get(verActividades().size()-1).getActividadId())+1);
        }
        
        try {
            //SE REALIZA LA INSERCION DE LOS DIFERENTES DATOS EN LA TABLA REGISTRO_ONG
            sql = "INSERT INTO Registro_ONG (REG_ActividadID,REG_Aprobacion,REG_Ong_nombre,REG_Nombre_actividad,REG_Desc_actividad,REG_Fecha_solicitud,REG_Hora_apertura,REG_Hora_cierre,REG_HabitatID) VALUES (?,?,?,?,?,?,?,?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, rong.getActividadId());
            ps.setString(2, rong.getAprobacion());
            ps.setString(3, rong.getOngNombre());
            ps.setString(4, rong.getNombreActividad());
            ps.setString(5, rong.getDescripcionActividad());
            ps.setDate(6, FechaSolicitud);
            ps.setString(7, rong.getHoraApertura());
            ps.setString(8, rong.getHoraCierre());
            ps.setInt(9, rong.getHabitatId()); 
            ps.execute();
            
            
            //REALIZANDO EL ALTA DE LOS DIAS DE LA ACTIVIDAD Y EL ID DE LA ACTIVIDAD
            //EN LA TABLA ONG_REALIZA
            sql = "INSERT INTO ONG_Realiza (REA_ActividadID,REA_Dia) VALUES (?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            
            for (int i = 0; i < ht.getDiasActividad().size(); i++) {
                ps.setInt(1, rong.getActividadId());
                ps.setString(2, ht.getDiasActividad().get(i));
                ps.execute();
            }
            
            return true;
        } catch (SQLException e) {
               System.out.println(e);
            return false;
        }
    }
}
