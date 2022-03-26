package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("AutorizacaoFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoLogado = (sessao.getAttribute("usuario") == null);
		boolean ehUmaUmaContaProtegida = !(paramAcao.equals("Login") || paramAcao.equals("FormularioLogin"));
		if(ehUmaUmaContaProtegida && usuarioNaoLogado) {
			response.sendRedirect("entrada?acao=FormularioLogin") ;
			return;
		}
		
		chain.doFilter(request, response);
	}

	

}
