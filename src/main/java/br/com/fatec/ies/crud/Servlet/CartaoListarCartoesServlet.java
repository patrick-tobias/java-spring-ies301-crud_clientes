package br.com.fatec.ies.crud.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import br.com.fatec.ies.crud.Cartao.CartaoTransferenciaDeDados;
import br.com.fatec.ies.crud.Cartao.CartaoTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cartaoListarCartoesServlet")
public class CartaoListarCartoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET");
		
		try{
			String clienteId = request.getParameter("cliente");
			
			CartaoTransferenciaDeDadosDAO cartaoTransferenciaDeDadosDAO = new CartaoTransferenciaDeDadosDAO();
			ArrayList<CartaoTransferenciaDeDados> cartoes = cartaoTransferenciaDeDadosDAO.listarCartoes(Integer.valueOf(clienteId));
			
			Gson gson = new Gson();
			String json = gson.toJson(cartoes);
			
			response.setContentType("application/json");
			
			response.getWriter().append(json);
		    response.getWriter().close();
		    response.flushBuffer();
			
		} catch(SQLException e){
			System.out.println(e);
		}
	}


}
