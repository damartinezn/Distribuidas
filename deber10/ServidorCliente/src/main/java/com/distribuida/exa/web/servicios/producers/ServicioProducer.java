package com.distribuida.exa.web.servicios.producers;

import java.util.Arrays;
import java.util.List;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.distribuida.exa.web.dto.AlbumDto;
import com.distribuida.exa.web.dto.SingerDto;
import com.distribuida.exa.web.servicios.HttpExaUtils;
import com.distribuida.exa.web.servicios.ServicioAlbum;
import com.distribuida.exa.web.servicios.ServicioSinger;

@ApplicationScoped
public class ServicioProducer {

	public static final String URL = "http://127.0.0.1:7050";
	public static final String URL2 = "http://127.0.0.1:7060";
	//@Inject URL URL;

	@Produces @ApplicationScoped
	public ServicioSinger servicioSinger( ) {
		
		return new ServicioSinger( ) {
			
			@Override
			public List<SingerDto> listar( ) {
				
				SingerDto[] dtos = HttpExaUtils.invoke( URL + "/singers", SingerDto[].class );
				
				return Arrays.asList( dtos );
			}

			@Override
			public SingerDto buscar( Integer id ) {
				return HttpExaUtils.invoke( URL + "/singers/" + id, SingerDto.class );
			}
		};
	}
	
	@Produces @ApplicationScoped
	public ServicioAlbum servicioAlbum( ) {
		
		return new ServicioAlbum( ) {
			
			@Override
			public List<AlbumDto> listar( ) {
				
				AlbumDto[] dtos = HttpExaUtils.invoke( URL2 + "/Albums", AlbumDto[].class );
				
				return Arrays.asList( dtos );
			}

			@Override
			public AlbumDto buscar(Integer id) {
				return HttpExaUtils.invoke( URL2 + "/Albums/" + id, AlbumDto.class );
			}
		};
	}
}
