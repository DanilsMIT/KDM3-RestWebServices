package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetalleVenta {
	private int codedetventa;
	private Venta code_cabv;
	private Producto code_producto;
	private int cantidad;
	private BigDecimal precio_venta;
	private BigDecimal subtotal;
	private BigDecimal subtotalIVA;
	
	
	public DetalleVenta() {
		super();
	}
	public DetalleVenta(int codedetventa, Venta code_cabv, Producto code_producto, int cantidad,
			BigDecimal precio_venta, BigDecimal subtotal, BigDecimal subtotalIVA) {
		super();
		this.codedetventa = codedetventa;
		this.code_cabv = code_cabv;
		this.code_producto = code_producto;
		this.cantidad = cantidad;
		this.precio_venta = precio_venta;
		this.subtotal = subtotal;
		this.subtotalIVA = subtotalIVA;
	}
	@Override
	public String toString() {
		return "DetalleVenta [codedetventa=" + codedetventa + ", code_cabv=" + code_cabv + ", code_producto="
				+ code_producto + ", cantidad=" + cantidad + ", precio_venta=" + precio_venta + ", subtotal=" + subtotal
				+ ", subtotalIVA=" + subtotalIVA + "]";
	}
	public int getCodedetventa() {
		return codedetventa;
	}
	public void setCodedetventa(int codedetventa) {
		this.codedetventa = codedetventa;
	}
	public Venta getCode_cabv() {
		return code_cabv;
	}
	public void setCode_cabv(Venta code_cabv) {
		this.code_cabv = code_cabv;
	}
	public Producto getCode_producto() {
		return code_producto;
	}
	public void setCode_producto(Producto code_producto) {
		this.code_producto = code_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(BigDecimal precio_venta) {
		this.precio_venta = precio_venta;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getSubtotalIVA() {
		return subtotalIVA;
	}
	public void setSubtotalIVA(BigDecimal subtotalIVA) {
		this.subtotalIVA = subtotalIVA;
	}
	
	
	
	
	
}
