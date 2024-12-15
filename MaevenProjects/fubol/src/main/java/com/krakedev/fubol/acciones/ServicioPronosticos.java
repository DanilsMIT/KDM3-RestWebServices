package com.krakedev.fubol.acciones;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.fubol.entidades.pronosticos;
import com.krakedev.fubol.servicios.PronosticosBDD;
import com.krakedev.inventarios.utils.krakedevException;

@Path("pronosticos")
public class ServicioPronosticos {
	
	@Path("registrarPronostico")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarPronostico(pronosticos p) {
		PronosticosBDD pbdd=new PronosticosBDD();
		try {
			pbdd.registrarPronostico(p);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("codigo_user/{codeu}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPronosticobyUser(@PathParam("codeu") int codeU) {
		ArrayList<pronosticos> pL=new ArrayList<pronosticos>();
		PronosticosBDD pbdd=new PronosticosBDD();
		try {
			pL=pbdd.recuperarPronosticos(codeU);
			return Response.ok(pL).build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
