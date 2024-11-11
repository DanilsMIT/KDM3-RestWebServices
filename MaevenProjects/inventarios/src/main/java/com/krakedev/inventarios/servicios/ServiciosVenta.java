package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.BDD.PedidoBDD;
import com.krakedev.inventarios.BDD.VentasBDD;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Venta;
import com.krakedev.inventarios.exception.krakedevException;

@Path("comprar")
public class ServiciosVenta {
	@Path("confirmado")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Confirmar(Venta pv){
		VentasBDD pvBDD= new VentasBDD();
		try {
			pvBDD.RegistrarCompra(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("solicitar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Insertar(Venta pv){
		VentasBDD pvBDD= new VentasBDD();
		try {
			pvBDD.SolicitarCompra(pv);
			return Response.ok().build();
		} catch (krakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
}
