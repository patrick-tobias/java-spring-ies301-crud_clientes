package br.com.fatec.ies.crud.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import br.com.fatec.ies.crud.Cliente.ClienteTransferenciaDeDados;
import br.com.fatec.ies.crud.Cliente.ClienteTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clienteListarClientesServlet")
public class ClienteListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			
			ClienteTransferenciaDeDadosDAO clienteTransferenciaDeDadosDAO = new ClienteTransferenciaDeDadosDAO();
			
			ArrayList<ClienteTransferenciaDeDados> clientes = clienteTransferenciaDeDadosDAO.listarClientes();
			
			Gson gson = new Gson();
			String json = gson.toJson(clientes);
			
			response.addHeader("Access-Control-Allow-Origin", "*");
		    response.addHeader("Access-Control-Allow-Methods", "GET");
		    
		    response.setContentType("application/json");
		    
		    response.getWriter().append(json);
		    response.getWriter().close();
		    response.flushBuffer();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
