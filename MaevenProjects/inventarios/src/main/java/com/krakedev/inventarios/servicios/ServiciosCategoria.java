package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.BDD.CategoriaBDD;
import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.exception.krakedevException;

@Path("categorias")
public class ServiciosCategoria {
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Actualizar(Categoria pv) {
		CategoriaBDD pvBDD = new CategoriaBDD();
		try {
			pvBDD.ActualizarCategoria(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Insertar(Categoria pv) {
		CategoriaBDD pvBDD = new CategoriaBDD();
		try {
			pvBDD.CrearCategoria(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Buscar() {
		ArrayList<Categoria> pvL = new ArrayList<Categoria>();
		CategoriaBDD pvBDD = new CategoriaBDD();
		try {
			pvL = pvBDD.recuperarCategorias();
			return Response.ok(pvL).build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}
}
