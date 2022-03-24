package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static Integer chaveSequencial = 1;
	private static List<Empresa> listaEmpresa = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuario = new ArrayList<Usuario>();
	
	static {
		Usuario usuario = new Usuario();
		usuario.setLogin("Edivan");
		usuario.setSenha("123");
		Banco.listaUsuario.add(usuario);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.listaEmpresa.add(empresa);
		
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.listaEmpresa;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = listaEmpresa.iterator();
		while(it.hasNext()) {
			if(it.next().getId() == id) {
				it.remove();
			}
		}
		
	}

	public Empresa buscaPorId(Integer id) {
		for (Empresa empresa : listaEmpresa)if(empresa.getId() == id) return empresa;
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuario) {
			if(usuario.ehIgual(login, senha))return usuario;
			}
		return null;
	}

	
}
