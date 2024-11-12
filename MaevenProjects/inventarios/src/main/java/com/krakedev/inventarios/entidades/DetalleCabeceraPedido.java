package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetalleCabeceraPedido {
	private int code;
	private int CodePedido;
	private Producto CodeProducto;
	private int cantidadSolicitada;
	private BigDecimal subtotal;
	private int cantidadEnviada;
	
	
	public DetalleCabeceraPedido() {
		super();
	}
	public DetalleCabeceraPedido(int code, int codePedido, Producto codeProducto, int cantidadSolicitada,
			BigDecimal subtotal, int cantidadEnviada) {
		super();
		this.code = code;
		CodePedido = codePedido;
		CodeProducto = codeProducto;
		this.cantidadSolicitada = cantidadSolicitada;
		this.subtotal = subtotal;
		this.cantidadEnviada = cantidadEnviada;
	}
	@Override
	public String toString() {
		return "DetalleCabeceraPedido [code=" + code + ", CodePedido=" + CodePedido + ", CodeProducto=" + CodeProducto
				+ ", cantidadSolicitada=" + cantidadSolicitada + ", subtotal=" + subtotal + ", cantidadEnviada="
				+ cantidadEnviada + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCodePedido() {
		return CodePedido;
	}
	public void setCodePedido(int codePedido) {
		CodePedido = codePedido;
	}
	public Producto getCodeProducto() {
		return CodeProducto;
	}
	public void setCodeProducto(Producto codeProducto) {
		CodeProducto = codeProducto;
	}
	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public int getCantidadEnviada() {
		return cantidadEnviada;
	}
	public void setCantidadEnviada(int cantidadEnviada) {
		this.cantidadEnviada = cantidadEnviada;
	}
	
	
	
	
	
}
