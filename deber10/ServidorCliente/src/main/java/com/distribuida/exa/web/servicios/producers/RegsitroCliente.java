package com.distribuida.exa.web.servicios.producers;

import com.ecwid.consul.v1.ConsulClient;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;

@ApplicationScoped
public class RegsitroCliente {
	
	public static final String NAME = "singer";
	
	

	@Produces
	public String urls() {
		ConsulClient client = new ConsulClient("127.0.0.1");
		Response<Map<String, Service>> ss = client.getAgentServices();
		Map<String, Service> services = ss.getValue();
		List<Service> lista = services.values()
		.stream()
		.filter( s->NAME.equals(s.getService()) )
		.collect( Collectors.toList());
		
		if(lista.isEmpty())
		{
			System.err.println("No existe ningun servicio registrado con el nombre " + NAME);
			
		}
		
		//-- imprimir todos los servidores
		System.out.println( "------------------------------------" );
		System.out.println( "-- Lista de servidores" );
		for( String key:services.keySet() ) {
		Service s = services.get( key );
		String url = String.format( "http:// %s: %d/hola", s.getAddress(),
		s.getPort() );
		System.out.println( key + "-->" + url );
		}
		//-- generar un numero aleatorio
		System.out.println( "------------------------------------" );
		System.out.println( "-- Invocar a un servidor" );
		int size = lista.size();
		Random rd = new Random();
		int index = rd.nextInt() % size;
		Service servidor = lista.get( index );
		String url = String.format( "http:// %s: %d/hola", servidor.getAddress(),
		servidor.getPort() );
		System.out.println( url );
		return url;
	}

}
