package br.com.fatec.ies.crud.Servlet;

import java.io.IOException;

import br.com.fatec.ies.crud.Cartao.CartaoTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cartaoDeletarCartaoServlet")
public class CartaoDeletarCartaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String cartaoId = request.getParameter("id");
			
			CartaoTransferenciaDeDadosDAO cartaoTransferenciaDeDadosDAO = new CartaoTransferenciaDeDadosDAO();
			cartaoTransferenciaDeDadosDAO.removerCartao(Integer.valueOf(cartaoId));
			
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "POST");			
		} catch (Exception e){
			System.out.println(e);
		}
	}

}
