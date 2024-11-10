package com.krakedev.inventarios.entidades;

public class EstadoPedido {
	private String CodeEstado;
	private String descripcion;
	
	public EstadoPedido() {
		super();
	}
	public EstadoPedido(String codeEstado, String descripcion) {
		super();
		CodeEstado = codeEstado;
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "EstadoPedido [CodeEstado=" + CodeEstado + ", descripcion=" + descripcion + "]";
	}
	public String getCodeEstado() {
		return CodeEstado;
	}
	public void setCodeEstado(String codeEstado) {
		CodeEstado = codeEstado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
