package com.krakedev.inventarios.BDD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.exception.krakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidoBDD {

	public void PedidoRecibido(Pedido pv) throws krakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psD = null;
		PreparedStatement psDH = null;
		PreparedStatement psDP = null;

		Pedido pvComprobacion = recuperarPedido(pv.getCodigo());
		if (pvComprobacion != null) {
			try {
				con = ConexionBDD.obtenerConexion();
				ps = con.prepareStatement("Update CabeceraPedidos set estado = ? where codecabp = ? ");
				ArrayList<DetallePedido> pvL = pv.getDetalles();
				DetallePedido pvD;
				DetallePedido pvDC;
				for (int i = 0; i < pv.getDetalles().size(); i++) {
					pvD = pvL.get(i);
					pvDC = recuperarDetallePedido(pvD.getCode());
					
					if (pvDC.getCodePedido().getCodigo()==pv.getCodigo()) {
						psD = con.prepareStatement("Update DetallesPedidos set cantidadrecibida = ?, subtotal = ? "
								+ "where codedetpedido = ? and code_cabp = ? ");
						BigDecimal precioProdc = pvD.getCodeProducto().getPrecio_venta();
						BigDecimal cantidad = new BigDecimal(pvD.getCantidadEnviada());
						BigDecimal subtotal = precioProdc.multiply(cantidad);

						psD.setInt(1, pvD.getCantidadEnviada());
						psD.setBigDecimal(2, subtotal);
						psD.setInt(3, pvD.getCode());
						psD.setInt(4, pv.getCodigo());
						psD.executeUpdate();
						System.out.println("Detalle actualizado");
						
						Date D=new Date();
						Timestamp TS=new Timestamp(D.getTime());
						String idP=Integer.toString(pv.getCodigo());
						
						psDH=con.prepareStatement("INSERT INTO HistorialStock (fecha, referencia, Code_Producto, cantidad) "
								+ "values(?,?,?,?)");
						psDH.setTimestamp(1, TS);
						psDH.setString(2, "Pedido "+idP);
						psDH.setInt(3, pvD.getCodeProducto().getCodeProducto());
						psDH.setInt(4, pvD.getCantidadEnviada());
						psDH.executeUpdate();

						ProductosBDD pbdd=new ProductosBDD();
						Producto P=pbdd.BuscarProducto(pvD.getCodeProducto().getCodeProducto());
						int stock=P.getStock()+pvD.getCantidadEnviada();
						psDP=con.prepareStatement("Update Productos set stock = ? where CodeProducto = ? ");
						psDP.setInt(1, stock);
						psDP.setInt(2, P.getCodeProducto());
						psDP.executeUpdate();
						System.out.println("Stock Producto actualizado");

					}else {
						throw new krakedevException("Quiza un detalle no corresponde al codigo del pedido ");
					}

				}
				ps.setString(1, "R");
				ps.setInt(2, pv.getCodigo());
				ps.executeUpdate();
				System.out.println("Cabecera Pedido actualizado");

			} catch (

			krakedevException e) {
				e.printStackTrace();
				throw e;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new krakedevException("Error al Registrar Pedido " + e.getMessage());
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			throw new krakedevException("Cabecera de Pedido inexistente o algun detalle no corresponde al pedido");
		}
	}

	public Pedido recuperarPedido(int ID) throws krakedevException {
		Connection CON = null;
		PreparedStatement PS = null;
		Pedido pv = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("Select * from CabeceraPedidos where codecabp = ? ");
			PS.setInt(1, ID);
			ResultSet RS = PS.executeQuery();
			if (RS.next()) {
				pv = new Pedido();
				int CodeI = RS.getInt("codecabp");
				pv.setCodigo(CodeI);
			}

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("No existe el Pedido: " + e.getMessage());
		} finally {
			if (CON != null) {
				try {
					CON.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return pv;
	}

	public DetallePedido recuperarDetallePedido(int ID) throws krakedevException {
		Connection CON = null;
		PreparedStatement PS = null;
		DetallePedido pv = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("Select * from DetallesPedidos where codedetpedido = ? ");
			PS.setInt(1, ID);
			ResultSet RS = PS.executeQuery();
			if (RS.next()) {
				pv = new DetallePedido();
				int codecabp = RS.getInt("code_cabp");
				int codecabpD = RS.getInt("codedetpedido");

				Pedido p=new Pedido();
				p.setCodigo(codecabp);
				pv.setCode(codecabpD);
				pv.setCodePedido(p);
			}

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("No existe el detalle: " + e.getMessage());
		} finally {
			if (CON != null) {
				try {
					CON.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return pv;
	}

	public void RegistrarPedido(Pedido pv) throws krakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psD = null;
		ResultSet rs = null;
		Date fechaPedido = new Date();
		java.sql.Date fechaPedidoSQL = new java.sql.Date(fechaPedido.getTime());
		int CodigoCabecera = 0;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("INSERT INTO CabeceraPedidos (CodeProveedor, fecha, estado)" + " values(?,?,?) ",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pv.getProveedor().getIdentificador());
			ps.setDate(2, fechaPedidoSQL);
			ps.setString(3, "S");
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			System.out.println("CodigoCabecera obtenido: " + CodigoCabecera);

			if (rs.next()) {
				CodigoCabecera = rs.getInt(1);
				ArrayList<DetallePedido> pvL = pv.getDetalles();
				DetallePedido pvD;
				for (int i = 0; i < pv.getDetalles().size(); i++) {
					pvD = pvL.get(i);
					psD = con.prepareStatement(
							"INSERT INTO DetallesPedidos (Code_CabP, Code_Producto, cantidad, subtotal, cantidadRecibida)"
									+ " values (?,?,?,?,?) ");
					psD.setInt(1, CodigoCabecera);
					psD.setInt(2, pvD.getCodeProducto().getCodeProducto());
					psD.setInt(3, pvD.getCantidadSolicitada());
					BigDecimal precioProdc = pvD.getCodeProducto().getPrecio_venta();
					BigDecimal cantidad = new BigDecimal(pvD.getCantidadSolicitada());
					BigDecimal subtotal = precioProdc.multiply(cantidad);
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
			throw new krakedevException("Error al Registrar Pedido " + e.getMessage());
		} finally {
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
