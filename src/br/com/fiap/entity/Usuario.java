package br.com.fiap.entity;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String email;
	private int numeroReservas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumeroReservas() {
		return numeroReservas;
	}
	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}
}
