package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println("logando" + login);
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("usuario existe");
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}else {
			System.out.println("usuario não existe.");
			return "redirect:entrada?acao=FormularioLogin";
		}
		
		
	}

}
