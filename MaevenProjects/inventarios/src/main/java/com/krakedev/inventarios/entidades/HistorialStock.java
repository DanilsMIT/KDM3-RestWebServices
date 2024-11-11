package com.krakedev.inventarios.entidades;

public class HistorialStock {
	private int code;
	private String fechaMovimiento;
	private String referencia;
	private Producto code_product;
	private int cantidad;
	
	public HistorialStock() {
		super();
	}
	public HistorialStock(int code, String fechaMovimiento, String referencia, Producto code_product, int cantidad) {
		super();
		this.code = code;
		this.fechaMovimiento = fechaMovimiento;
		this.referencia = referencia;
		this.code_product = code_product;
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "HistorialStock [code=" + code + ", fechaMovimiento=" + fechaMovimiento + ", referencia=" + referencia
				+ ", code_product=" + code_product + ", cantidad=" + cantidad + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Producto getCode_product() {
		return code_product;
	}
	public void setCode_product(Producto code_product) {
		this.code_product = code_product;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
