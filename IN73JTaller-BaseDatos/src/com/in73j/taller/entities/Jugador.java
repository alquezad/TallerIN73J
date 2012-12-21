package com.in73j.taller.entities;

public class Jugador {

	public Integer id;
	public String nombre;
	public String apellido;
	public String equipo;
	public Integer posicion;
	
	public Jugador() {}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEquipo() {
		return equipo;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	
}
