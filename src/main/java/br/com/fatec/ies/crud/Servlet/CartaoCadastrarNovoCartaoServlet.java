package br.com.fatec.ies.crud.Servlet;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;

import br.com.fatec.ies.crud.Cartao.CartaoTransferenciaDeDados;
import br.com.fatec.ies.crud.Cartao.CartaoTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cartaoCadastrarNovoCartaoServlet")
public class CartaoCadastrarNovoCartaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			BufferedReader reader = request.getReader();

			StringBuilder sb = new StringBuilder();
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append('\n');
				}
			} finally {
				reader.close();
			}
			
			Gson gson = new Gson();
			CartaoTransferenciaDeDados cartaoTransferido = gson.fromJson(sb.toString(), CartaoTransferenciaDeDados.class);
			
			CartaoTransferenciaDeDadosDAO cartaoTransferenciaDeDadosDAO = new CartaoTransferenciaDeDadosDAO();
			cartaoTransferenciaDeDadosDAO.adicionarCartao(cartaoTransferido);
			
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "POST");
			
			response.flushBuffer();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
