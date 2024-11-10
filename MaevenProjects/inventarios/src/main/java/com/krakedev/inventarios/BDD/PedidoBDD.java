package com.krakedev.inventarios.BDD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.exception.krakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidoBDD {
	public void RegistrarPedido(Pedido pv) throws krakedevException{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement psD=null;
		ResultSet rs=null;
		Date fechaPedido= new Date();
		java.sql.Date fechaPedidoSQL =new java.sql.Date(fechaPedido.getTime());
		int CodigoCabecera=0;
		try {
			con=ConexionBDD.obtenerConexion();
			ps=con.prepareStatement("INSERT INTO CabeceraPedidos (CodeProveedor, fecha, estado)"
					+ " values(?,?,?) ", Statement.RETURN_GENERATED_KEYS) ;
			ps.setString(1, pv.getProveedor().getIdentificador());
			ps.setDate(2, fechaPedidoSQL);
			ps.setString(3, "S");
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			System.out.println("CodigoCabecera obtenido: "+CodigoCabecera);

			if(rs.next()) {
				CodigoCabecera=rs.getInt(1);
				ArrayList<DetallePedido> pvL =pv.getDetalles();
				DetallePedido pvD;
				for(int i=0;i<pv.getDetalles().size();i++) {
					pvD=pvL.get(i);
					psD=con.prepareStatement("INSERT INTO DetallesPedidos (Code_CabP, Code_Producto, cantidad, subtotal, cantidadRecibida)"
							+ " values (?,?,?,?,?) ");
					psD.setInt(1, CodigoCabecera);
					psD.setInt(2,pvD.getCodeProducto().getCodeProducto());
					psD.setInt(3, pvD.getCantidadSolicitada());
					BigDecimal precioProdc=pvD.getCodeProducto().getPrecio_venta();
					BigDecimal cantidad=new BigDecimal(pvD.getCantidadSolicitada());
					BigDecimal subtotal=precioProdc.multiply(cantidad);
					psD.setBigDecimal(4, subtotal);
					psD.setInt(5, 0);
					psD.executeUpdate();

				}
			}
			
		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al Registrar Pedido "+e.getMessage());
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
