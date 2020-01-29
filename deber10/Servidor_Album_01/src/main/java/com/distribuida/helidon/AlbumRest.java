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

import com.distribuida.modelo.Album;
import com.distribuida.servicio.IServicioAlbum;

@Path("/Albums")
public class AlbumRest {
	
	@Inject IServicioAlbum servicioAlbum;
	
	@GET		
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Album> listarAlbum(){
		return servicioAlbum.listarAlbum();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Album getAlbum(@PathParam("id") int idAlbum) {
		return servicioAlbum.getAlbum(idAlbum);
	}

	@PUT	
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Album updateAlbum(Album Album) {
		servicioAlbum.editar(Album);
		return Album;
	}
	
	@DELETE
	@Path("/{id}")	
	public void deleteAlbum(@PathParam("id") int idAlbum) {
		servicioAlbum.eliminar(idAlbum);
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Album createAlbum(Album Album) {
		servicioAlbum.insertar(Album);
		return Album;
	}
	
}
