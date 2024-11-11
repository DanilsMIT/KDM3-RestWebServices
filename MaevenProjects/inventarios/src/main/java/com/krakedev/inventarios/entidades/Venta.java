package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
public class Venta {
	private int codecabv;
	private String fecha;
	private BigDecimal total_sinIVA;
	private BigDecimal TotalConIVA;
	private BigDecimal TOTAL;
	private ArrayList<DetalleVenta> detalles;
	
	
	public Venta() {
		super();
	}
	public Venta(int codecabv, String fecha, BigDecimal total_sinIVA, BigDecimal totalConIVA, BigDecimal tOTAL,
			ArrayList<DetalleVenta> detalles) {
		super();
		this.codecabv = codecabv;
		this.fecha = fecha;
		this.total_sinIVA = total_sinIVA;
		TotalConIVA = totalConIVA;
		TOTAL = tOTAL;
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "Venta [codecabv=" + codecabv + ", fecha=" + fecha + ", total_sinIVA=" + total_sinIVA + ", TotalConIVA="
				+ TotalConIVA + ", TOTAL=" + TOTAL + ", detalles=" + detalles + "]";
	}
	public int getCodecabv() {
		return codecabv;
	}
	public void setCodecabv(int codecabv) {
		this.codecabv = codecabv;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getTotal_sinIVA() {
		return total_sinIVA;
	}
	public void setTotal_sinIVA(BigDecimal total_sinIVA) {
		this.total_sinIVA = total_sinIVA;
	}
	public BigDecimal getTotalConIVA() {
		return TotalConIVA;
	}
	public void setTotalConIVA(BigDecimal totalConIVA) {
		TotalConIVA = totalConIVA;
	}
	public BigDecimal getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(BigDecimal tOTAL) {
		TOTAL = tOTAL;
	}
	public ArrayList<DetalleVenta> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
	
	
	
}
