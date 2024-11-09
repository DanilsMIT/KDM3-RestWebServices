package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Insertar(Proveedor pv){
		ProveedoresBDD pvBDD= new ProveedoresBDD();
		System.out.println(">>>"+pv);
		try {
			pvBDD.InsertarProveedor(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
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
