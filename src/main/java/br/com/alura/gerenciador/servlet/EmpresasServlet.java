package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class EmpresasServlet
 */
@WebServlet("/empresas")
public class EmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cabecario = request.getHeader("Accept");
		
		Banco banco = new Banco();
		List<Empresa> empresa = banco.getEmpresa();
		if(cabecario.contains("xml")) {//se esse cabeçario temina com xml
			XStream xStream = new XStream(); 
			xStream.alias("empresa", Empresa.class);
			String xml = xStream.toXML(empresa);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}else if(cabecario.endsWith("json")){
			Gson gson = new Gson();
			
			String json = gson.toJson(empresa);
			response.setContentType("application/json");
			response.getWriter().print(json);
		}else {
			response.setContentType("application/json");
			response.getWriter().print("{'message:'no contet'}");
			
		}
		
		
		
	}

}
