package a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import a1.Modelo.Alumno;
import a1.Modelo.Modelo;
import a1.Vista.Vista;

public class principal {

	public static void main(String[] args) {
		Vista vista = new Vista();
		vista.iniciar();
	}

}
