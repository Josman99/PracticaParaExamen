package unu.ProyectoPractica.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import unu.ProyectoPractica.beans.Autor;
import unu.ProyectoPractica.models.AutorModel;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	AutorModel modelo = new AutorModel();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoresController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException{
    	try {
    		if(request.getParameter("op") == null) {
        		listar(request, response);
        		return;
        	}
    		String operacion = request.getParameter("op");
    		switch(operacion) {
    		case "listar":
    			listar(request, response);
    			break;
    		case "nuevo":
    			request.getRequestDispatcher("/autor/nuevoAutor.jsp").forward(request, response);
    			break;
    		case "ingresar":
    			ingresar(request, response);
    			break;
    		case "obtener":
    			obtener(request, response);
    			break;
    		case "modificar":
    			modificar(request, response);
    			break;
    		case "eliminar":
    			eliminar(request, response);
    			break;
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	try {
			request.setAttribute("listaAutores", modelo.listaAutores());
	    	Iterator<Autor> it = modelo.listaAutores().iterator();
	    	while (it.hasNext()) {
				Autor a = it.next();
				System.out.println(a.getIdAutor()+" "+a.getNombreAutor()+" "+a.getNacionalidad());
			}
    	request.getRequestDispatcher("/autor/listaAutores.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    public void ingresar(HttpServletRequest request, HttpServletResponse response) throws SQLException{
    	Autor miautor = new Autor();
    	try {
			//miautor.setIdAutor(Integer.parseInt(request.getParameter("id")));
			miautor.setNombreAutor(request.getParameter("nombre"));
			miautor.setNacionalidad(request.getParameter("nacionalidad"));
			if(modelo.insertarAutor(miautor)>0) {
				request.getSession().setAttribute("exito", "Autor registrado exitosamente");
				response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
			} else {
				request.getSession().setAttribute("Fracaso", "Autor no registrado ya que hay otro autor con ese codigo ");
				response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
			}
			
			response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
		} catch (Exception e) {
			System.out.println("error al ingrese desde el contyrolador: "+e.getMessage());
		}
    }
    
    public void obtener(HttpServletRequest request, HttpServletResponse response) throws SQLException{
    	try {
    		String id = request.getParameter("id");
			Autor autor = modelo.obtenerAutor(Integer.parseInt(id));
			if(autor != null) {
				request.setAttribute("autor", autor);
				request.getRequestDispatcher("/autor/modificarAutor.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
			response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
		} catch (Exception e) {
			System.out.println("error al obtener desde el controlador: "+e.getMessage());
		}
    }
    public void modificar(HttpServletRequest request, HttpServletResponse response) throws SQLException{
    	Autor miautor = new Autor();
    	try {
			miautor.setIdAutor(Integer.parseInt(request.getParameter("id")));
			miautor.setNombreAutor(request.getParameter("nombre"));
			miautor.setNacionalidad(request.getParameter("nacionalidad"));
			if(modelo.insertarAutor(miautor)>0) {
				request.getSession().setAttribute("exito", "Autor registrado exitosamente");
				response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
			} else {
				request.getSession().setAttribute("Fracaso", "Autor no registrado ya que hay otro autor con ese codigo ");
				response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
			}
			
			response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
		} catch (Exception e) {
			System.out.println("error al ingrese desde el contyrolador: "+e.getMessage());
		}
    }
    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException{
    	try {
    		int id = Integer.parseInt(request.getParameter("id"));//aqui falta modificar
			
			if(modelo.eliminarAutor(id)>0) {
				request.setAttribute("Exito", "Autor eliminado");
			}else {
				request.setAttribute("Fracaso", "No se puede eliminar este autor");
			}
			request.getRequestDispatcher("/AutoresController?op=listar").forward(request, response);
		} catch (Exception e) {
			System.out.println("error al obtener desde el controlador: "+e.getMessage());
		}
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
