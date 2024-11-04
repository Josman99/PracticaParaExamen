package unu.ProyectoPractica.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import unu.ProyectoPractica.beans.Autor;
import unu.ProyectoPractica.beans.Editorial;
import unu.ProyectoPractica.models.EditorialModel;

import java.io.IOException;
import java.util.Iterator;

/**
 * Servlet implementation class EditorialesController
 */
public class EditorialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EditorialModel modelo = new EditorialModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialesController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		if(request.getParameter("op") == null) {
        		listar(request, response);
        		return;
        	}
		} catch (Exception e) {
			System.out.println("ERROR EN EL PROCESS: "+e.getMessage());
		}
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		request.setAttribute("listaEditorial", modelo.listaEditorial());
    		Iterator<Editorial> it = modelo.listaEditorial().iterator();
    		while (it.hasNext()) {
				Editorial e = it.next();
				System.out.println(e.getId()+" "+e.getNombreEdit()+" "+e.getContactoEdit()+" "+e.getTelefonoEdit());
			}
			request.getRequestDispatcher("/editorial/listaEditorial.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Error al mostrar desde el controlador: "+e.getMessage());
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
