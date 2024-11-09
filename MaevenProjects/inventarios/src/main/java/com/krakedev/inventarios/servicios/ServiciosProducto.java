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

import com.krakedev.inventarios.BDD.ProductosBDD;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.exception.krakedevException;

@Path("productos")
public class ServiciosProducto {
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Insertar(Producto pv){
		ProductosBDD pvBDD= new ProductosBDD();
		System.out.println(">>>"+pv);
		try {
			pvBDD.InsertarProducto(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("buscar/{subcadena}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Buscar(@PathParam("subcadena") String buscador) {
		ArrayList<Producto> pvL = new ArrayList<Producto>();
		ProductosBDD pvBDD = new ProductosBDD();
		try {
			pvL = pvBDD.BuscarProducto(buscador);
			return Response.ok(pvL).build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
