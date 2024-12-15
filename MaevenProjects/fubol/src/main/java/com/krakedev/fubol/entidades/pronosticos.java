package com.krakedev.fubol.entidades;

public class pronosticos {
	private int codigo_pronostico;
	private UsuariosApp codigo_usuario;
	private partidos codigo_partido;
	private EquiposParticipantes codigo_equipo1;
	private EquiposParticipantes codigo_equipo2;
	private int pronostico_e1;
	private int pronostico_e2;
	
	public pronosticos() {
		super();
	}
	public pronosticos(int codigo_pronostico, UsuariosApp codigo_usuario, partidos codigo_partido,
			EquiposParticipantes codigo_equipo1, EquiposParticipantes codigo_equipo2, int pronostico_e1,
			int pronostico_e2) {
		super();
		this.codigo_pronostico = codigo_pronostico;
		this.codigo_usuario = codigo_usuario;
		this.codigo_partido = codigo_partido;
		this.codigo_equipo1 = codigo_equipo1;
		this.codigo_equipo2 = codigo_equipo2;
		this.pronostico_e1 = pronostico_e1;
		this.pronostico_e2 = pronostico_e2;
	}
	@Override
	public String toString() {
		return "pronosticos [codigo_pronostico=" + codigo_pronostico + ", codigo_usuario=" + codigo_usuario
				+ ", codigo_partido=" + codigo_partido + ", codigo_equipo1=" + codigo_equipo1 + ", codigo_equipo2="
				+ codigo_equipo2 + ", pronostico_e1=" + pronostico_e1 + ", pronostico_e2=" + pronostico_e2 + "]";
	}
	public int getCodigo_pronostico() {
		return codigo_pronostico;
	}
	public void setCodigo_pronostico(int codigo_pronostico) {
		this.codigo_pronostico = codigo_pronostico;
	}
	public UsuariosApp getCodigo_usuario() {
		return codigo_usuario;
	}
	public void setCodigo_usuario(UsuariosApp codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	public partidos getCodigo_partido() {
		return codigo_partido;
	}
	public void setCodigo_partido(partidos codigo_partido) {
		this.codigo_partido = codigo_partido;
	}
	public EquiposParticipantes getCodigo_equipo1() {
		return codigo_equipo1;
	}
	public void setCodigo_equipo1(EquiposParticipantes codigo_equipo1) {
		this.codigo_equipo1 = codigo_equipo1;
	}
	public EquiposParticipantes getCodigo_equipo2() {
		return codigo_equipo2;
	}
	public void setCodigo_equipo2(EquiposParticipantes codigo_equipo2) {
		this.codigo_equipo2 = codigo_equipo2;
	}
	public int getPronostico_e1() {
		return pronostico_e1;
	}
	public void setPronostico_e1(int pronostico_e1) {
		this.pronostico_e1 = pronostico_e1;
	}
	public int getPronostico_e2() {
		return pronostico_e2;
	}
	public void setPronostico_e2(int pronostico_e2) {
		this.pronostico_e2 = pronostico_e2;
	}
}

