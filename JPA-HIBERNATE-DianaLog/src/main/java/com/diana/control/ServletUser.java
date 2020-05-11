package com.diana.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diana.DAO.HistorialDao;
import com.diana.DAO.UsuaDao;
import com.dianaE.model.TbHisto;
import com.dianaE.model.TbUsu;

/**
 * Servlet implementation class ServletUser
 */
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String usu = request.getParameter("usuario");
		String contra = request.getParameter("contra");
		String cerrarsesion = request.getParameter("btncerrar");
		
		
		if (cerrarsesion!=null) {
			if (cerrarsesion.equals("CERRAR SESION")) {
				
				HttpSession cerrarsesiones = (HttpSession) request.getSession();
				cerrarsesiones.invalidate();
				
				response.sendRedirect("loginvista.jsp");
			}
		}
		else {
		
		TbUsu usuario = new TbUsu();
		UsuaDao usuDao = new UsuaDao();
		
		usuario.setUsuario(usu);
		usuario.setPass(contra);
		
		int verificarusuario = usuDao.ingresoUsuario(usuario).size();
		if(verificarusuario ==1) {
			TbHisto histo = new TbHisto();
			HistorialDao histodao = new HistorialDao();
			Date fecha = new Date();
			
			histo.setFechaHisto(fecha);
			usuario.setId_usu(usuario.getId_usu());
			histo.setTbUsu(usuario);
			histodao.agregarDatosHistorial(histo);
			
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("usuario", usu);
			response.sendRedirect("Principal.jsp");
			
		}else {
			System.out.println("ERROR");
		}
		
		}
		
	}

}
