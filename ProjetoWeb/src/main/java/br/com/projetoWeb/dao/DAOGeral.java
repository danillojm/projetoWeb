package br.com.projetoWeb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoWeb.conexaoBd.HibernateUtil;

public class DAOGeral<Entidade> implements DAO<Entidade> {

	private Class<Entidade> classe;

	public DAOGeral() {

		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

	}

	@Override
	public void salvar(Entidade entidade) {
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("");
		EntityManager et = ef.createEntityManager();

		// et.find(arg0, arg1)

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {

			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
		}

	}

	@Override
	public void editar(Entidade entidade) {

	}

	@Override
	public void excluir(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(codigo);
			transacao.commit();

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			} else {
				throw e;
			}
		} finally {
			sessao.close();

		}

	}

	@Override
	public List<Entidade> listar() {

		return null;
	}

}
