package br.com.projetoWeb.dao;

import java.util.List;

public interface DAO<Entidade> {
	public void salvar(Entidade entidade);

	public void editar(Entidade entidade);

	public void excluir(Long codigo);

	public List<Entidade> listar();
}
