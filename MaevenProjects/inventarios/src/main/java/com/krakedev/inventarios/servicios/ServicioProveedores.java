package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.BDD.ProveedoresBDD;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.exception.krakedevException;

@Path("Proveedores")
public class ServicioProveedores {
	
	@Path("buscar/{subcadena}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Buscar(@PathParam("subcadena") String buscador){
		ArrayList<Proveedor> pvL= new ArrayList<Proveedor>();
		ProveedoresBDD pvBDD= new ProveedoresBDD();
		try {
			pvL=pvBDD.BuscarProveedores(buscador);
			return Response.ok(pvL).build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
}
