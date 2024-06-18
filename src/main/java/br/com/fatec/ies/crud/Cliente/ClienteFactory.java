package br.com.fatec.ies.crud.Cliente;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ClienteFactory {
	
	public static Cliente getCliente(ClienteTransferenciaDeDados clienteTransferenciaDeDados) throws Exception{
		System.out.println("criando cliente...");	
		
			GenerosEnum genero = (GenerosEnum) GenerosEnum.validarGenero(clienteTransferenciaDeDados.getGenero());
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/MM/YYYY");
			Date dataNascimento = simpleDateFormat.parse(clienteTransferenciaDeDados.getDataNascimento());
			
			Cliente cliente = new Cliente(clienteTransferenciaDeDados.getNome(), genero, dataNascimento, clienteTransferenciaDeDados.getCpf(), clienteTransferenciaDeDados.getTelefone(), clienteTransferenciaDeDados.getEmail(), clienteTransferenciaDeDados.getSenha());
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			
			Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
			
			for (ConstraintViolation violation : constraintViolations) {
				String msgViolation = violation.getMessage();
				throw new RuntimeException(msgViolation);
			}
			
			return cliente;
	}

	public static Cliente getClienteString(String factory_nome, String factory_genero, String factory_dataNascimento, String factory_cpf, String factory_telefone, String factory_email, String factory_senha) throws Exception{
		System.out.println("criando cliente...");	
		
			GenerosEnum genero = (GenerosEnum) GenerosEnum.validarGenero(factory_genero);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/MM/YYYY");
			Date dataNascimento = simpleDateFormat.parse(factory_dataNascimento);
			
			Cliente cliente = new Cliente(factory_nome, genero, dataNascimento, factory_cpf, factory_telefone, factory_email, factory_senha);
			
//			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//			Validator validator = factory.getValidator();
//			
//			Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
//			
//			for (ConstraintViolation violation : constraintViolations) {
//				String msgViolation = violation.getMessage();
//				throw new RuntimeException(msgViolation);
//			}
			
			return cliente;
	}
}
