package com.krakedev.inventarios.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	private int codigo;
	private Proveedor proveedor;
	private Date fechaPedido;
	private EstadoPedido estado;
	private ArrayList<DetallePedido> detalles;
	
	
	public Pedido() {
		super();
	}
	
	
	public Pedido(int codigo) {
		super();
		this.codigo = codigo;
	}


	public Pedido(Proveedor proveedor, Date fechaPedido, EstadoPedido estado, ArrayList<DetallePedido> detalles) {
		super();
		this.proveedor = proveedor;
		this.fechaPedido = fechaPedido;
		this.estado = estado;
		this.detalles = detalles;
	}
	
	public Pedido(int codigo, Proveedor proveedor, Date fechaPedido, EstadoPedido estado,
			ArrayList<DetallePedido> detalles) {
		super();
		this.codigo = codigo;
		this.proveedor = proveedor;
		this.fechaPedido = fechaPedido;
		this.estado = estado;
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", proveedor=" + proveedor + ", fechaPedido=" + fechaPedido + ", estado="
				+ estado + ", detalles=" + detalles + "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public EstadoPedido getEstado() {
		return estado;
	}
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	public ArrayList<DetallePedido> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetallePedido> detalles) {
		this.detalles = detalles;
	}
	
	
	
	
}
