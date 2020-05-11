package com.dianaE.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_histo database table.
 * 
 */
@Entity
@Table(name="tb_histo")
@NamedQuery(name="TbHisto.findAll", query="SELECT t FROM TbHisto t")
public class TbHisto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_histo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_histo")
	private Date fechaHisto;

	//bi-directional many-to-one association to TbUsu
	@ManyToOne
	@JoinColumn(name="Id_usucod")
	private TbUsu tbUsu;

	public TbHisto() {
	}

	public int getId_histo() {
		return this.id_histo;
	}

	public void setId_histo(int id_histo) {
		this.id_histo = id_histo;
	}

	public Date getFechaHisto() {
		return this.fechaHisto;
	}

	public void setFechaHisto(Date fechaHisto) {
		this.fechaHisto = fechaHisto;
	}

	public TbUsu getTbUsu() {
		return this.tbUsu;
	}

	public void setTbUsu(TbUsu tbUsu) {
		this.tbUsu = tbUsu;
	}

}