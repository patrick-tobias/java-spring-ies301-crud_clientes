package br.com.fatec.ies.crud.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import br.com.fatec.ies.crud.Endereco.EnderecoTransferenciaDeDados;
import br.com.fatec.ies.crud.Endereco.EnderecoTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/enderecoListarEnderecosServlet")
public class EnderecoListarEnderecosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String clienteId = request.getParameter("cliente");
			
			EnderecoTransferenciaDeDadosDAO enderecoTransferenciaDeDadosDAO = new EnderecoTransferenciaDeDadosDAO();
			ArrayList<EnderecoTransferenciaDeDados> enderecos = enderecoTransferenciaDeDadosDAO.listarEnderecos(Integer.valueOf(clienteId));
			
			Gson gson = new Gson();
			String json = gson.toJson(enderecos);
			
			response.addHeader("Access-Control-Allow-Origin", "*");
		    response.addHeader("Access-Control-Allow-Methods", "GET");
		    
		    response.setContentType("application/json");
		    
		    response.getWriter().append(json);
		    response.getWriter().close();
		    response.flushBuffer();
		    
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
