package br.com.projetoWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_chamados")
public class Chamados extends GenericModel {

	
	public static String strUsuario = "usuario";
	public static String strDescChamado = "descChamado";
	
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Usuario usuario;
	
	@Column(name="desc_chamado",nullable=false,length =255)
	private String descChamado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescChamado() {
		return descChamado;
	}

	public void setDescChamado(String descChamado) {
		this.descChamado = descChamado;
	}
	
	
}
