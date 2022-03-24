package br.com.alura.gerenciador.acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:formNovaEmpresa.jsp";
	}

}
