package com.in73j.taller.testing;

import java.util.List;

import com.in73j.taller.bd.IbatisManager;
import com.in73j.taller.bd.IbatisNameQueries;
import com.in73j.taller.entities.Jugador;

public class Testing {
	
	public static IbatisManager ibatisManager = new IbatisManager();
	
	public static void main(String[]args){
		testGetJugadores();
		
	}
	
	public static void testGetJugador(){
		Jugador j = (Jugador)ibatisManager.select(IbatisNameQueries.GET_JUGADOR, 1);
		log(j.getId()+" "+j.getNombre()+" "+j.getApellido()+" "+j.getEquipo()+" "+j.getPosicion());
	}
	
	@SuppressWarnings("unchecked")
	public static void testGetJugadores(){
		List<Jugador> jugadores = (List<Jugador>)ibatisManager.selectList(IbatisNameQueries.GET_JUGADORES, null);
		
		for(Jugador j:jugadores)
			log(j.getId()+" "+j.getNombre()+" "+j.getApellido()+" "+j.getEquipo()+" "+j.getPosicion());
	}
	
	public static void log(String text){
		System.out.println(text);
	}

}
