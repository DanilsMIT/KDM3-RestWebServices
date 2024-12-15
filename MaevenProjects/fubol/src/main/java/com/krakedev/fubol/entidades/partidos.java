package com.krakedev.fubol.entidades;

import java.sql.Date;
import java.sql.Time;

public class partidos {
	private int codigo;
	private String encuentro;
	private Date fecha;
	private Time hora;
	
	public partidos() {
		super();
	}
	
	public partidos(int codigo) {
		super();
		this.codigo = codigo;
	}

	public partidos(int codigo, String encuentro, Date fecha, Time hora) {
		super();
		this.codigo = codigo;
		this.encuentro = encuentro;
		this.fecha = fecha;
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "partidos [codigo=" + codigo + ", encuentro=" + encuentro + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getEncuentro() {
		return encuentro;
	}
	public void setEncuentro(String encuentro) {
		this.encuentro = encuentro;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
}
