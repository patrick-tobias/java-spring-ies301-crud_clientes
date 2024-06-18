package br.com.fatec.ies.crud.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import br.com.fatec.ies.crud.Cartao.CartaoTransferenciaDeDados;
import br.com.fatec.ies.crud.Cartao.CartaoTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cartaoAtualizarCartaoServlet")
public class CartaoAtualizarCartaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String cartaoId = request.getParameter("id");
			
			CartaoTransferenciaDeDadosDAO cartaoTransferenciaDeDadosDAO = new CartaoTransferenciaDeDadosDAO();
			ArrayList<CartaoTransferenciaDeDados> cartoes = cartaoTransferenciaDeDadosDAO.buscarCartao(Integer.valueOf(cartaoId));
			
			System.out.println(cartoes.size());
			System.out.println(cartoes.toString());
			
			Gson gson = new Gson();
			String json = gson.toJson(cartoes);
			
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET");
			
			response.getWriter().append(json);
			response.getWriter().close();
			response.flushBuffer();
			
		}catch(Exception e){
			System.out.println(e);
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
