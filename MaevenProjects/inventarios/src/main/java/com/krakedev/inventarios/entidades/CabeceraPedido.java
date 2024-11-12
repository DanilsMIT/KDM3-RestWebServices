package com.krakedev.inventarios.entidades;

import java.util.ArrayList;
import java.util.Date;

public class CabeceraPedido {
	private int codigo;
	private String proveedor;
	private Date fechaPedido;
	private String estado;
	private ArrayList<DetalleCabeceraPedido> pedidos;
	
	
	public CabeceraPedido() {
		super();
	}
	
	public CabeceraPedido(int codigo, String proveedor, Date fechaPedido, String estado) {
		super();
		this.codigo = codigo;
		this.proveedor = proveedor;
		this.fechaPedido = fechaPedido;
		this.estado = estado;
	}

	public CabeceraPedido(int codigo, String proveedor, Date fechaPedido, String estado,
			ArrayList<DetalleCabeceraPedido> pedidos) {
		super();
		this.codigo = codigo;
		this.proveedor = proveedor;
		this.fechaPedido = fechaPedido;
		this.estado = estado;
		this.pedidos = pedidos;
	}
	@Override
	public String toString() {
		return "CabeceraPedido [codigo=" + codigo + ", proveedor=" + proveedor + ", fechaPedido=" + fechaPedido
				+ ", estado=" + estado + ", pedidos=" + pedidos + "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ArrayList<DetalleCabeceraPedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<DetalleCabeceraPedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
	
}
