package br.com.fatec.ies.crud.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import br.com.fatec.ies.crud.Endereco.TiposResidenciaEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listarItensTiposResidenciaServlet")
public class ListarItensTiposResidenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> itensTipoResidencia = TiposResidenciaEnum.listarTiposResidencia();
		
		Gson gson = new Gson();
		String json = gson.toJson(itensTipoResidencia);
		
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    
	    response.setContentType("application/json");
	    
	    response.getWriter().append(json);
	    response.getWriter().close();
	    response.flushBuffer();
	}

}
