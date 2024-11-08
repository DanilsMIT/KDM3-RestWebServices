package com.krakedev.inventarios.entidades;

public class TipoIdentificacion {
	private String CodeI;
	private String descripcion;
	
	public TipoIdentificacion() {
		super();
	}
	public TipoIdentificacion(String codeI, String descripcion) {
		super();
		CodeI = codeI;
		this.descripcion = descripcion;
	}
	public String getCodeI() {
		return CodeI;
	}
	public void setCodeI(String codeI) {
		CodeI = codeI;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "TipoIdentificacion [CodeI=" + CodeI + ", descripcion=" + descripcion + "]";
	}
	
}
