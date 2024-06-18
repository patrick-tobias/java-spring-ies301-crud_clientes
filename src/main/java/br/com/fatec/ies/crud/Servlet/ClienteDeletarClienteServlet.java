package br.com.fatec.ies.crud.Servlet;

import java.io.IOException;

import br.com.fatec.ies.crud.Cliente.ClienteTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clienteDeletarClienteServlet")
public class ClienteDeletarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String clienteId = request.getParameter("cliente");
			
			ClienteTransferenciaDeDadosDAO clienteTransferenciaDeDadosDAO = new ClienteTransferenciaDeDadosDAO();
			clienteTransferenciaDeDadosDAO.removerCliente(Integer.valueOf(clienteId));
			
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "POST");
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
