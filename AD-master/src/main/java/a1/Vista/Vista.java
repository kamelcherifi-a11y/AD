package a1.Vista;

import java.util.ArrayList;
import java.util.Scanner;

import a1.Modelo.Alumno;
import a1.Modelo.Modelo;

public class Vista {

	private Modelo modelo = new Modelo();
	private Scanner sc = new Scanner(System.in);

	public void iniciar() {
		int opcion;
		do {
			mostrarMenu();
			opcion = leerOpcion();
			switch (opcion) {
				case 1: listarAlumnos(); break;
				case 2: buscarAlumnoPorId(); break;
				case 3: agregarAlumno(); break;
				case 4: actualizarAlumno(); break;
				case 5: eliminarAlumno(); break;
				case 0: System.out.println("Saliendo..."); break;
				default: System.out.println("Opción no válida.");
			}
		} while (opcion != 0);
		sc.close();
	}

	private void mostrarMenu() {
		System.out.println("\n===== GESTIÓN DE ALUMNOS =====");
		System.out.println("1. Listar todos los alumnos");
		System.out.println("2. Buscar alumno por ID");
		System.out.println("3. Añadir nuevo alumno");
		System.out.println("4. Actualizar alumno");
		System.out.println("5. Eliminar alumno");
		System.out.println("0. Salir");
		System.out.print("Seleccione una opción: ");
	}

	private int leerOpcion() {
		try {
			return Integer.parseInt(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private void listarAlumnos() {
		ArrayList<Alumno> alumnos = modelo.getAll();
		if (alumnos.isEmpty()) {
			System.out.println("No hay alumnos registrados.");
			return;
		}
		System.out.println("\n--- Lista de alumnos ---");
		for (Alumno a : alumnos) {
			System.out.println(a);
		}
	}

	private void buscarAlumnoPorId() {
		System.out.print("Introduce el ID del alumno: ");
		int id = leerEntero();
		Alumno alumno = modelo.getAlumnoById(id);
		if (alumno != null) {
			System.out.println("Alumno encontrado: " + alumno);
		} else {
			System.out.println("No se encontró ningún alumno con ese ID.");
		}
	}

	private void agregarAlumno() {
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Primer apellido: ");
		String apellido1 = sc.nextLine();
		System.out.print("Segundo apellido: ");
		String apellido2 = sc.nextLine();
		System.out.print("Teléfono: ");
		int telefono = leerEntero();

		Alumno nuevoAlumno = new Alumno(nombre, apellido1, apellido2, telefono);
		int exito = modelo.addAlumno(nuevoAlumno);
		if(exito==1) {
			System.out.println("Alumno añadido correctamente.");
		}
		else {
			System.out.println("Error al añadir el alumno.");
		}
		
	}

	private void actualizarAlumno() {
		System.out.print("Introduce el ID del alumno a actualizar: ");
		int id = leerEntero();
		Alumno alumnoExistente = modelo.getAlumnoById(id);
		if (alumnoExistente == null) {
			System.out.println("No existe ningún alumno con ese ID.");
			return;
		}

		System.out.print("Nuevo nombre (" + alumnoExistente.getNombre() + "), deja en blanco para no cambiar: ");
		String nombre = sc.nextLine();
		System.out.print("Nuevo primer apellido (" + alumnoExistente.getApellido1() + "): ");
		String apellido1 = sc.nextLine();
		System.out.print("Nuevo segundo apellido (" + alumnoExistente.getApellido2() + "): ");
		String apellido2 = sc.nextLine();
		System.out.print("Nuevo teléfono (" + alumnoExistente.getTelefono() + "): ");
		String telefonoStr = sc.nextLine();

		if (!nombre.isEmpty()) alumnoExistente.setNombre(nombre);
		if (!apellido1.isBlank()) alumnoExistente.setApellido1(apellido1);
		if (!apellido2.isBlank()) alumnoExistente.setApellido2(apellido2);
		if (!telefonoStr.isBlank()) {
			try {
				alumnoExistente.setTelefono(Integer.parseInt(telefonoStr));
			} catch (NumberFormatException e) {
				System.out.println("Teléfono no válido, se mantiene el anterior.");
			}
		}

		boolean exito = modelo.updateAlumnoById(id, alumnoExistente);
		System.out.println(exito ? "Alumno actualizado correctamente." : "Error al actualizar el alumno.");
	}

	private void eliminarAlumno() {
		System.out.print("Introduce el ID del alumno a eliminar: ");
		int id = leerEntero();
		boolean exito = modelo.deleteAlumno(id);
		System.out.println(exito ? "Alumno eliminado correctamente." : "Error al eliminar el alumno.");
	}

	private int leerEntero() {
		try {
			return Integer.parseInt(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Valor no válido, se usará -1.");
			return -1;
		}
	}
}