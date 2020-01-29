package com.distribuida.helidon;

import java.util.List;

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

import com.distribuida.modelo.Singer;
import com.distribuida.servicio.IServicioSinger;

@Path("/singers")
public class SingerRest {
	
	@Inject IServicioSinger servicioSinger;
	
	@GET		
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Singer> listarSinger(){
		return servicioSinger.listarSinger();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Singer getSinger(@PathParam("id") int idSinger) {
		return servicioSinger.getSinger(idSinger);
	}

	@PUT	
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Singer updateSinger(Singer singer) {
		servicioSinger.editar(singer);
		return singer;
	}
	
	@DELETE
	@Path("/{id}")	
	public void deleteSinger(@PathParam("id") int idsinger) {
		servicioSinger.eliminar(idsinger);
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Singer createSinger(Singer singer) {
		servicioSinger.insertar(singer);
		return singer;
	}
	
}
