package com.distribuida.exa.web.servicios;

import java.util.List;

import com.distribuida.exa.web.dto.SingerDto;

public interface ServicioSinger {

	public List<SingerDto> listar( );
	public SingerDto buscar( Integer id );
}
