package com.distribuida.helidon;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.entidades.Singer;
import com.distribuida.servicio.ISinger;

@ApplicationScoped
@Path("/singers")
public class SingerRest {
	
	@Inject ISinger singerService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> listarTodos(){
		List<Singer> singers = singerService.listarSinger();
		return singers;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Singer getSinger(@PathParam("id") Integer idsinger){
		Singer singers = singerService.getSinger(idsinger);
		return singers;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Singer insertarSinger(Singer singer) {
		Singer sing = singerService.insertar(singer);
		return sing;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Singer updateSinger(Singer singer) {
		Singer sing = singerService.editar(singer);
		return sing;
	}	
	
	@DELETE
	@Path("/{id}")
	public void eliminarSinger(@PathParam("id") Integer idSinger) {
		singerService.eliminar(idSinger);		
	}
	
	
	
}
