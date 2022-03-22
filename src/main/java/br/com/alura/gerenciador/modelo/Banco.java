package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static Integer chaveSequencial = 1;
	private static List<Empresa> listaEmpresa = new ArrayList<Empresa>();

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

	
}
