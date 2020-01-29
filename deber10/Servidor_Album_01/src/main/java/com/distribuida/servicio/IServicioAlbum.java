package com.distribuida.servicio;

import java.util.List;

import com.distribuida.modelo.Album;



public interface IServicioAlbum {
	List<Album> listarAlbum();
	
	Album getAlbum(Integer idAlbum);
	
	Album insertar(Album Album);
	
	Album editar(Album Album);
	
	void eliminar(Integer idAlbum);
}
