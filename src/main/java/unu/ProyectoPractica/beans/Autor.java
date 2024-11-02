package unu.ProyectoPractica.beans;

public class Autor {
	
	private int idAutor;
	private String nombreAutor;
	private String nacionalidad;
	
	public Autor(int idAutor, String nombreAutor, String nacionalidad) {
		super();
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.nacionalidad = nacionalidad;
	}

	public Autor() {
		this(0,"","");
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	

}
