package com.distribuida.exa.web.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.exa.web.dto.SingerDto;
import com.distribuida.exa.web.servicios.ServicioSinger;

import lombok.Getter;

@SessionScoped @Named("singerAction")
public class SingerAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject private ServicioSinger servicio;
	
	@Getter private List<SingerDto> singers;
	@Getter private SingerDto singerSeleccionado;
	
	public String iniciar( ) {
		singers = servicio.listar();
		
		return "singers";
	}
	
	public String detalle( SingerDto dto ) {
		
		singerSeleccionado = servicio.buscar( dto.getId());
		
		return "singer-detalle";
	}
}
