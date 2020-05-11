package com.dianaE.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_usu database table.
 * 
 */
@Entity
@Table(name="tb_usu")
@NamedQuery(name="TbUsu.findAll", query="SELECT t FROM TbUsu t")
public class TbUsu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_usu;

	private String apellido_usu;

	private String nombre_usu;

	private String pass;

	private String usuario;

	//bi-directional many-to-one association to TbHisto
	@OneToMany(mappedBy="tbUsu")
	private List<TbHisto> tbHistos;

	public TbUsu() {
	}

	public int getId_usu() {
		return this.id_usu;
	}

	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}

	public String getApellido_usu() {
		return this.apellido_usu;
	}

	public void setApellido_usu(String apellido_usu) {
		this.apellido_usu = apellido_usu;
	}

	public String getNombre_usu() {
		return this.nombre_usu;
	}

	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<TbHisto> getTbHistos() {
		return this.tbHistos;
	}

	public void setTbHistos(List<TbHisto> tbHistos) {
		this.tbHistos = tbHistos;
	}

	public TbHisto addTbHisto(TbHisto tbHisto) {
		getTbHistos().add(tbHisto);
		tbHisto.setTbUsu(this);

		return tbHisto;
	}

	public TbHisto removeTbHisto(TbHisto tbHisto) {
		getTbHistos().remove(tbHisto);
		tbHisto.setTbUsu(null);

		return tbHisto;
	}

}