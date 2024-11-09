package com.krakedev.inventarios.entidades;

public class UDM {
	private String UDM;
	private String descripcion;
	private CUDM CUDM;
	
	public UDM() {
		super();
	}
	

	public UDM(String uDM, String descripcion) {
		super();
		UDM = uDM;
		this.descripcion = descripcion;
	}


	public UDM(String uDM, String descripcion, com.krakedev.inventarios.entidades.CUDM cUDM) {
		super();
		UDM = uDM;
		this.descripcion = descripcion;
		CUDM = cUDM;
	}

	@Override
	public String toString() {
		return "UDM [UDM=" + UDM + ", descripcion=" + descripcion + ", CUDM=" + CUDM + "]";
	}

	public String getUDM() {
		return UDM;
	}

	public void setUDM(String uDM) {
		UDM = uDM;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CUDM getCUDM() {
		return CUDM;
	}

	public void setCUDM(CUDM cUDM) {
		CUDM = cUDM;
	}
	
	
}
