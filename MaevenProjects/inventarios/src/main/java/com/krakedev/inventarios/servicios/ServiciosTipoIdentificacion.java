package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.BDD.TipoIdentificacionBDD;
import com.krakedev.inventarios.entidades.TipoIdentificacion;
import com.krakedev.inventarios.exception.krakedevException;

@Path("identifacion")
public class ServiciosTipoIdentificacion {
	
	@Path("recuperarTipos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Buscar(){
		ArrayList<TipoIdentificacion> pvL= new ArrayList<TipoIdentificacion>();
		TipoIdentificacionBDD pvBDD= new TipoIdentificacionBDD();
		try {
			pvL=pvBDD.recuperarTipos();
			return Response.ok(pvL).build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
}
