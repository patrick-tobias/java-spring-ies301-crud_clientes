package br.com.fatec.ies.crud.Servlet;

import java.io.IOException;

import br.com.fatec.ies.crud.Endereco.EnderecoTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/enderecoDeletarEnderecoServlet")
public class EnderecoDeletarEnderecoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String enderecoId = request.getParameter("id");
			System.out.println(enderecoId);
			
			EnderecoTransferenciaDeDadosDAO enderecoTransferenciaDeDadosDAO = new EnderecoTransferenciaDeDadosDAO();
			enderecoTransferenciaDeDadosDAO.removerEndereco(Integer.valueOf(enderecoId));
			
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "POST");
		} catch (Exception e){
			System.out.println(e);
		}
	}

}
