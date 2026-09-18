package a1.Modelo;

public class Alumno {
	private int codigo, telefono;
	private String nombre, apellido1, apellido2;
	
	public Alumno(String nombre, String apellido1, String apellido2, int telefono) {
		super();
		this.codigo = codigo;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	
	
	public Alumno(int codigo, String nombre, String apellido1, String apellido2, int telefono) {
		super();
		this.codigo = codigo;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	
	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", telefono=" + telefono + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + "]";
	}
	
	

}
