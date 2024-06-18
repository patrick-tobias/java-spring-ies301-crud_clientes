package br.com.fatec.ies.crud.Servlet;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;

import br.com.fatec.ies.crud.Endereco.EnderecoTransferenciaDeDados;
import br.com.fatec.ies.crud.Endereco.EnderecoTransferenciaDeDadosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/enderecoCadastrarNovoEndereco")
public class EnderecoCadastrarNovoEndereco extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String clienteId = request.getParameter("cliente");		
			
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
			
			System.out.println(sb.toString());
			
			Gson gson = new Gson();
			EnderecoTransferenciaDeDados enderecoTransferido = gson.fromJson(sb.toString(), EnderecoTransferenciaDeDados.class);
			
			EnderecoTransferenciaDeDadosDAO enderecoTransferenciaDeDadosDAO = new EnderecoTransferenciaDeDadosDAO();
			enderecoTransferenciaDeDadosDAO.adicionarEndereco(Integer.valueOf(clienteId), enderecoTransferido);
			
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "POST");
			
			response.flushBuffer();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
