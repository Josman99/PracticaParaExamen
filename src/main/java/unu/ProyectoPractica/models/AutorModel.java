package unu.ProyectoPractica.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import unu.ProyectoPractica.beans.Autor;
import unu.ProyectoPractica.controller.AutoresController;

public class AutorModel extends Conexion{
	
	CallableStatement cs;
	ResultSet rs;
	
	public List<Autor> listaAutores() throws SQLException{
		try {
			List<Autor> lista = new ArrayList<>();
			String sql= "Call sp_listarAutor()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("id_autor"));
				autor.setNombreAutor(rs.getString("nombre_autor"));
				autor.setNacionalidad(rs.getString("nacionalidad_autor"));
				lista.add(autor);
			}
			this.cerrarConexion();
			return lista;
			
		} catch (SQLException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			this.cerrarConexion();
			return null;
		}
	}
	
	public int insertarAutor(Autor autor) throws SQLException{
		try {
			int filasAfectadas=0; 
			String sql = "CALL sp_insertarAutor(?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, autor.getNombreAutor());
			cs.setString(2, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			return filasAfectadas;
		} catch (Exception e) {
			System.out.println("error al insertar en el modelo: "+e.getMessage());
			return 0;
		}
	}
	public Autor obtenerAutor(int idAutor) throws SQLException{
		Autor miautor = new Autor();
		try {
			String sql ="CALL sp_obtenerAutor(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idAutor);
			rs = cs.executeQuery();
			if (rs.next()) {
				miautor.setIdAutor(rs.getInt("id_autor"));
				miautor.setNombreAutor(rs.getString("nombre_autor"));
				miautor.setNacionalidad(rs.getString("nacionalidad_autor"));
				this.cerrarConexion();
				return miautor;
			}
		} catch (Exception e) {
			System.out.println("error al obtener desde el modelo: "+e.getMessage());
			this.cerrarConexion();
			return null;
		}
		return miautor;
		
	}
	
	public int modificarAutor(Autor autor) throws SQLException{
		try {
			int filasAfectadas=0; 
			String sql = "CALL sp_modificarAutor(?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, autor.getIdAutor());;
			cs.setString(2, autor.getNombreAutor());
			cs.setString(3, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			return filasAfectadas;
		} catch (Exception e) {
			System.out.println("error al insertar en el modelo: "+e.getMessage());
			return 0;
		}
	}
	
	public int eliminarAutor(int idAutor) throws SQLException{
		try {
			int filasAfectadas=0;
			String sql ="CALL sp_eliminarAutor(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idAutor);
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			System.out.println("error al obtener desde el modelo: "+e.getMessage());
			return 0;
		}
		
	}
	
	
	
	
	
	
}
