package com.distribuida;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import com.distribuida.entidades.Singer;
import com.distribuida.servicio.ISinger;

public class TEST {

	public static void main(String[] args) {
		// Inicializacion del contenedor
		SeContainer container = SeContainerInitializer
								.newInstance()
								.initialize();
		
		//Busca el objeto de tipo operaciones
		Instance<ISinger> obj = container.select(ISinger.class);
		ISinger servicio = obj.get();
		
		
		Singer sing = servicio.getSinger(1);
		System.out.println(sing);
		System.out.println("LLLLLLLLLLLLLLLLLLLL");
		List<Singer> lista = new ArrayList<>();
		lista = servicio.listarSinger();
		for (Singer s : lista) {
			System.out.println(s);
		}
	}

}
