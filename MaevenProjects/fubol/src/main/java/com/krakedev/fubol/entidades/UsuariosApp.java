package com.krakedev.fubol.entidades;

public class UsuariosApp {
	private int codigo;
	private String cedula;
	private String nombre;
	private String apellido;
	
	public UsuariosApp() {
		super();
	}
	
	public UsuariosApp(int codigo) {
		super();
		this.codigo = codigo;
	}

	public UsuariosApp(int codigo, String cedula, String nombre, String apellido) {
		super();
		this.codigo = codigo;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "UsuariosApp [codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
