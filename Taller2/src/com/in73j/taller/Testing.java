package com.in73j.taller;

import com.in73j.taller.controlador.ServicioFuga;
import com.in73j.taller.entitie.DatosConsultaFuga;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ServicioFuga sf = new ServicioFuga();
		System.out.println(sf.isFuga(1));
		

	}

}
