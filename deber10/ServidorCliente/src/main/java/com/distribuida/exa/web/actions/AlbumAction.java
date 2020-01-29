package com.distribuida.exa.web.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.exa.web.dto.AlbumDto;
import com.distribuida.exa.web.servicios.ServicioAlbum;

import lombok.Getter;

@SessionScoped @Named("albumAction")
public class AlbumAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject private ServicioAlbum servicio;
	
	@Getter private List<AlbumDto> albums;
	@Getter private AlbumDto albumSeleccionado;
	
	public String iniciar( ) {
		
		albums = servicio.listar();
		
		return "albums";
	}
	
	public String detalle( AlbumDto dto ) {
		
		albumSeleccionado = servicio.buscar( dto.getId() );
		
		return "album-detalle";
	}
}
