package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.BDD.PedidoBDD;
import com.krakedev.inventarios.entidades.CabeceraPedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.exception.krakedevException;

@Path("pedidos")
public class ServicioPedidos {
	
	@Path("buscarPorProveedor/{identificadorProveedor}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Buscar(@PathParam("identificadorProveedor") String buscador) {
		ArrayList<CabeceraPedido> pvL = new ArrayList<CabeceraPedido>();
		PedidoBDD pvBDD = new PedidoBDD();
		try {
			pvL = pvBDD.recuperarPedidoProveedor(buscador);
			return Response.ok(pvL).build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@Path("recibido")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Actualizar(Pedido pv){
		PedidoBDD pvBDD= new PedidoBDD();
		try {
			pvBDD.PedidoRecibido(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Insertar(Pedido pv){
		PedidoBDD pvBDD= new PedidoBDD();
		try {
			pvBDD.RegistrarPedido(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
}
