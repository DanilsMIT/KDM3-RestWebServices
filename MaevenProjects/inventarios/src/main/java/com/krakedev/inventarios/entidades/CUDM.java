package com.krakedev.inventarios.entidades;

public class CUDM {
	private String CUDM;
	private String detalles;
	
	public CUDM() {
		super();
	}
	public CUDM(String cUDM, String detalles) {
		super();
		CUDM = cUDM;
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "CategoriaUDM [CUDM=" + CUDM + ", detalles=" + detalles + "]";
	}
	public String getCUDM() {
		return CUDM;
	}
	public void setCUDM(String cUDM) {
		CUDM = cUDM;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	
}
