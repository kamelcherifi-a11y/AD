package a1.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo {
	
	String consulta = "";
	Connection conexion = Conexion.conectar();
	Alumno alumno=null;
	
	public ArrayList<Alumno> getAll() {
		Statement sentencia;
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		consulta = "SELECT * FROM alumnos";
		try {
			sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery(consulta);
			while(rs.next()) {
				alumno = new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getInt("telefono"));
				listaAlumnos.add(alumno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAlumnos;
	}
	
	public Alumno getAlumnoById(int id) {
		
		try {
			consulta = "SELECT * from alumnos where id=?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, id);
			ResultSet rs = sentencia.executeQuery();
			if(rs.next()) {
				alumno = new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getInt("telefono"));
				//System.out.println(alumno.toString());
				return alumno;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return alumno;
	}
	
	public int addAlumno(Alumno alumno) {
		consulta = "INSERT INTO alumnos(nombre, apellido1, apellido2, telefono) VALUES(?,?,?,?)";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, alumno.getNombre());
			sentencia.setString(2, alumno.getApellido1());
			sentencia.setString(3, alumno.getApellido2());
			sentencia.setInt(4, alumno.getTelefono());
			return sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}	
	}
	public boolean deleteAlumno(int id) {
		consulta="DELETE FROM alumnos WHERE ID=?";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			return sentencia.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateAlumnoById(int id, Alumno alumno) {
		consulta= "UPDATE alumnos SET nombre=?, apellido1=?, apellido2=?, telefono=? WHERE id=?";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, alumno.getNombre());
			sentencia.setString(2, alumno.getApellido1());
			sentencia.setString(3, alumno.getApellido2());
			sentencia.setInt(4, alumno.getTelefono());
			sentencia.setInt(5, id);
			return sentencia.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateAlumno(Alumno alumno) {
		consulta= "UPDATE alumnos SET nombre=?, apellido1=?, apellido2=?, telefono=? WHERE id=?";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, alumno.getNombre());
			sentencia.setString(2, alumno.getApellido1());
			sentencia.setString(3, alumno.getApellido2());
			sentencia.setInt(4, alumno.getTelefono());
			sentencia.setInt(5, alumno.getCodigo());
			return sentencia.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateAlumnoCUIDADIIIIN(Alumno alumno) {
		consulta= "UPDATE alumnos SET codigo=?, nombre=?, apellido1=?, apellido2=?, telefono=? WHERE id=?";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, alumno.getCodigo());
			sentencia.setString(2, alumno.getNombre());
			sentencia.setString(3, alumno.getApellido1());
			sentencia.setString(4, alumno.getApellido2());
			sentencia.setInt(5, alumno.getTelefono());
			sentencia.setInt(6, alumno.getCodigo());
			return sentencia.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
