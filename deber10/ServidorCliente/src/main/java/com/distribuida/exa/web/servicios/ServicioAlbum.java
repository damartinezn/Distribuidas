package com.distribuida.exa.web.servicios;

import java.util.List;

import com.distribuida.exa.web.dto.AlbumDto;

public interface ServicioAlbum {

	public List<AlbumDto> listar( );
	public AlbumDto buscar( Integer id );
}
