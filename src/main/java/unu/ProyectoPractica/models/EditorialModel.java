package unu.ProyectoPractica.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import unu.ProyectoPractica.beans.Editorial;
import unu.ProyectoPractica.controller.EditorialesController;


public class EditorialModel extends Conexion{
	
	CallableStatement cs;
	ResultSet rs;
	
	
	public List<Editorial> listaEditorial() {
		try {
			List<Editorial> lista = new ArrayList<>();
			String sql = "CALL sp_listarEditorial()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Editorial editorial = new Editorial();
				editorial.setId(rs.getInt("id_editorial"));
				editorial.setNombreEdit(rs.getString("nombre_editorial"));
				editorial.setContactoEdit(rs.getString("contacto_editorial"));
				editorial.setTelefonoEdit(rs.getString("telefono"));
				lista.add(editorial);
			}
			this.cerrarConexion();
			return lista;
			
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(EditorialesController.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
			this.cerrarConexion();
			return null;
		}
		
	}
	
	
	
}
