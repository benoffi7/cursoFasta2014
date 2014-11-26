package com.example.cursoandroidfasta.listas;

import android.graphics.drawable.Drawable;

public class Equipo
{
	String nombre;
	int puntos;
	Drawable bandera;
	
	/**
	 * @param nombre
	 * @param puntos
	 * @param bandera
	 */
	public Equipo(String nombre, int puntos, Drawable bandera)
	{
		super();
		this.nombre = nombre;
		this.puntos = puntos;
		this.bandera = bandera;
	}
	
	public Equipo()
	{
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the nombre
	 */
	public String getNombre()
	{
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	/**
	 * @return the puntos
	 */
	public int getPuntos()
	{
		return puntos;
	}
	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos)
	{
		this.puntos = puntos;
	}
	/**
	 * @return the bandera
	 */
	public Drawable getBandera()
	{
		return bandera;
	}
	/**
	 * @param bandera the bandera to set
	 */
	public void setBandera(Drawable bandera)
	{
		this.bandera = bandera;
	}
}
