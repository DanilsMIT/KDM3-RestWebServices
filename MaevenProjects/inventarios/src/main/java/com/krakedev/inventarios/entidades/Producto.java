package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class Producto {
	private int CodeProducto;
	private String nombre;
	private UDM Code_UDM;
	private BigDecimal precio_venta;
	private boolean IVA;
	private BigDecimal costo;
	private Categoria Code_Cat;
	private int stock;
	
	public Producto() {
		super();
	}
	public Producto(int codeProducto, String nombre, UDM code_UDM, BigDecimal precio_venta, boolean iVA,
			BigDecimal costo, Categoria code_Cat, int stock) {
		super();
		CodeProducto = codeProducto;
		this.nombre = nombre;
		Code_UDM = code_UDM;
		this.precio_venta = precio_venta;
		IVA = iVA;
		this.costo = costo;
		Code_Cat = code_Cat;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [CodeProducto=" + CodeProducto + ", nombre=" + nombre + ", Code_UDM=" + Code_UDM
				+ ", precio_venta=" + precio_venta + ", IVA=" + IVA + ", costo=" + costo + ", Code_Cat=" + Code_Cat
				+ ", stock=" + stock + "]";
	}
	public int getCodeProducto() {
		return CodeProducto;
	}
	public void setCodeProducto(int codeProducto) {
		CodeProducto = codeProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UDM getCode_UDM() {
		return Code_UDM;
	}
	public void setCode_UDM(UDM code_UDM) {
		Code_UDM = code_UDM;
	}
	public BigDecimal getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(BigDecimal precio_venta) {
		this.precio_venta = precio_venta;
	}
	public boolean isIVA() {
		return IVA;
	}
	public void setIVA(boolean iVA) {
		IVA = iVA;
	}
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	public Categoria getCode_Cat() {
		return Code_Cat;
	}
	public void setCode_Cat(Categoria code_Cat) {
		Code_Cat = code_Cat;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
