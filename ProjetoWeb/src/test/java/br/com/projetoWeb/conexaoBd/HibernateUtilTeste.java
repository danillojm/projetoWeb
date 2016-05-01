package br.com.projetoWeb.conexaoBd;

import org.hibernate.Session;

public class HibernateUtilTeste {

	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		
		
	}
	
}
