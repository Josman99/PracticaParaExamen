package unu.ProyectoPractica.beans;

public class Editorial {
	private int id;
	private String nombreEdit;
	private String contactoEdit;
	private String telefonoEdit;
	
	public Editorial(int id, String nombreEdit, String contactoEdit, String telefonoEdit) {
		super();
		this.id = id;
		this.nombreEdit = nombreEdit;
		this.contactoEdit = contactoEdit;
		this.telefonoEdit = telefonoEdit;
	}

	public Editorial() {
		this(0, "", "", "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEdit() {
		return nombreEdit;
	}

	public void setNombreEdit(String nombreEdit) {
		this.nombreEdit = nombreEdit;
	}

	public String getContactoEdit() {
		return contactoEdit;
	}

	public void setContactoEdit(String contactoEdit) {
		this.contactoEdit = contactoEdit;
	}

	public String getTelefonoEdit() {
		return telefonoEdit;
	}

	public void setTelefonoEdit(String telefonoEdit) {
		this.telefonoEdit = telefonoEdit;
	}
		
}
