package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.BDD.PedidoBDD;
import com.krakedev.inventarios.BDD.ProveedoresBDD;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.exception.krakedevException;

@Path("pedidos")
public class ServicioPedidos {
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Insertar(Pedido pv){
		PedidoBDD pvBDD= new PedidoBDD();
		System.out.println(">>>"+pv);
		try {
			pvBDD.RegistrarPedido(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
}
