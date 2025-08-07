package com.spring.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
public class Auto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String modelo;
	
	private String marca;
	
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Auto(String modelo, String marca, String tipo) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.tipo = tipo;
	}
	
	public Auto() {
		
	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", tipo=" + tipo + "]";
	}
	
	
	
}
