package com.krakedev.inventarios.entidades;

public class Categoria {
	private int CodeCat;
	private String detalles;
	private Categoria Cat_Padre;
	
	
	public Categoria() {
		super();
	}
	public Categoria(int codeCat, String detalles) {
		super();
		CodeCat = codeCat;
		this.detalles = detalles;
	}
	public Categoria(int codeCat, String detalles, Categoria cat_Padre) {
		super();
		CodeCat = codeCat;
		this.detalles = detalles;
		Cat_Padre = cat_Padre;
	}
	@Override
	public String toString() {
		return "Categoria [CodeCat=" + CodeCat + ", detalles=" + detalles + ", Cat_Padre=" + Cat_Padre + "]";
	}
	public int getCodeCat() {
		return CodeCat;
	}
	public void setCodeCat(int codeCat) {
		CodeCat = codeCat;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public Categoria getCat_Padre() {
		return Cat_Padre;
	}
	public void setCat_Padre(Categoria cat_Padre) {
		Cat_Padre = cat_Padre;
	}
	
	
	
}
