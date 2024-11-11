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
import com.krakedev.inventarios.entidades.DetalleVenta;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Venta;
import com.krakedev.inventarios.exception.krakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class VentasBDD {
	public void RegistrarCompra(Venta pv) throws krakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psD = null;
		PreparedStatement psDH = null;
		PreparedStatement psDP = null;
		Venta pvComprobacion = recuperarVenta(pv.getCodecabv());
		if (pvComprobacion != null) {
			try {
				con = ConexionBDD.obtenerConexion();
				ps = con.prepareStatement(
						"Update CabeceraVentas set total_sin_iva = ?, iva = ?, total = ? where codecabv = ? ");
				BigDecimal subtotal = new BigDecimal(0);
				BigDecimal subtotalIVA = new BigDecimal(0);

				ArrayList<DetalleVenta> dvL = pv.getDetalles();
				ArrayList<DetalleVenta> dvLC = recuperarDetalleVentas(pv.getCodecabv());
				DetalleVenta dv;
				DetalleVenta dvC;
				DetalleVenta dvLCC;

				boolean codigosRevisados = false;
				for (int i = 0; i < pv.getDetalles().size(); i++) {
					dv = dvL.get(i);
					dvC = recuperarDetalleVenta(dv.getCodedetventa());
					if (dvC.getCode_cabv().getCodecabv() == pv.getCodecabv()) {
						codigosRevisados = true;
					} else {
						codigosRevisados = false;
						throw new krakedevException(
								"Quiza un codigo de detalle no corresponde al codigo de la solicitud venta ");

					}
				}

				if (codigosRevisados == true) {
					for (int a = 0; a < dvLC.size(); a++) {
						dvLCC = dvLC.get(a);
						subtotal = subtotal.add(dvLCC.getSubtotal());
						subtotalIVA = subtotalIVA.add(dvLCC.getSubtotalIVA());
					}

					ps.setBigDecimal(1, subtotal);
					ps.setBigDecimal(2, subtotalIVA);
					ps.setBigDecimal(3, subtotalIVA);
					ps.setInt(4, pv.getCodecabv());
					ps.executeUpdate();
					System.out.println("Cabecera Venta actualizada");
					
					
					for (int i = 0; i < pv.getDetalles().size(); i++) {

						dv = dvL.get(i);
						Date D=new Date();
						Timestamp TS=new Timestamp(D.getTime());
						String idP=Integer.toString(pv.getCodecabv());
						psD=con.prepareStatement("INSERT INTO HistorialStock (fecha, referencia, Code_Producto, cantidad) "
								+ "values(?,?,?,?)");
						psD.setTimestamp(1, TS);
						psD.setString(2, "Venta "+idP);
						psD.setInt(3, dv.getCode_producto().getCodeProducto());
						psD.setInt(4, dv.getCantidad()*-1);
						psD.executeUpdate();
						
						ProductosBDD pbdd=new ProductosBDD();
						Producto P=pbdd.BuscarProducto(dv.getCode_producto().getCodeProducto());
						int stock=P.getStock()-dv.getCantidad();
						
						psDP=con.prepareStatement("Update Productos set stock = ? where CodeProducto = ? ");
						psDP.setInt(1, stock);
						psDP.setInt(2, P.getCodeProducto());
						psDP.executeUpdate();
						System.out.println("Stock Producto actualizado");
				
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
		} else {
			throw new krakedevException("Cabecera de Venta inexistente");
		}
	}

	public DetalleVenta recuperarDetalleVenta(int ID) throws krakedevException {
		Connection CON = null;
		PreparedStatement PS = null;
		DetalleVenta pv = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("Select * from DetallesVentas where codedetventas = ? ");
			PS.setInt(1, ID);
			ResultSet RS = PS.executeQuery();
			while (RS.next()) {
				pv = new DetalleVenta();
				int codecabp = RS.getInt("codedetventas");
				int codecabpD = RS.getInt("code_cabv");
				int codeProduct = RS.getInt("code_producto");
				BigDecimal subtotal = RS.getBigDecimal("subtotal");
				BigDecimal subtotalIVA = RS.getBigDecimal("subtotal_con_iva");

				Venta p = new Venta();
				p.setCodecabv(codecabpD);

				pv.setCodedetventa(codecabp);
				pv.setCode_cabv(p);
				pv.setSubtotal(subtotal);
				pv.setSubtotalIVA(subtotalIVA);

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

	public ArrayList<DetalleVenta> recuperarDetalleVentas(int ID) throws krakedevException {
		Connection CON = null;
		PreparedStatement PS = null;
		ArrayList<DetalleVenta> pvL = new ArrayList<DetalleVenta>();
		DetalleVenta pv = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("Select * from DetallesVentas where code_cabv = ? ");
			PS.setInt(1, ID);
			ResultSet RS = PS.executeQuery();
			while (RS.next()) {
				pv = new DetalleVenta();
				int codecabp = RS.getInt("codedetventas");
				int codecabpD = RS.getInt("code_cabv");
				int codeProduct = RS.getInt("code_producto");
				BigDecimal subtotal = RS.getBigDecimal("subtotal");
				BigDecimal subtotalIVA = RS.getBigDecimal("subtotal_con_iva");

				Venta p = new Venta();
				p.setCodecabv(codecabpD);

				pv.setCodedetventa(codecabp);
				pv.setCode_cabv(p);
				pv.setSubtotal(subtotal);
				pv.setSubtotalIVA(subtotalIVA);

				pvL.add(pv);
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

		return pvL;
	}

	public Venta recuperarVenta(int ID) throws krakedevException {
		Connection CON = null;
		PreparedStatement PS = null;
		Venta pv = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("Select * from CabeceraVentas where codecabv = ? ");
			PS.setInt(1, ID);
			ResultSet RS = PS.executeQuery();
			if (RS.next()) {
				pv = new Venta();
				int CodeI = RS.getInt("codecabv");
				pv.setCodecabv(CodeI);
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

	public void SolicitarCompra(Venta pv) throws krakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psD = null;
		ResultSet rs = null;
		Date fecha = new Date();
		Timestamp ts = new Timestamp(fecha.getTime());
		int CodigoCabecera = 0;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"INSERT INTO CabeceraVentas (fecha, total_sin_iva, iva, total) " + " values(?,?,?,?) ",
					Statement.RETURN_GENERATED_KEYS);
			ps.setTimestamp(1, ts);
			ps.setBigDecimal(2, new BigDecimal(0));
			ps.setBigDecimal(3, new BigDecimal(0));
			ps.setBigDecimal(4, new BigDecimal(0));

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			System.out.println("CodigoCabeceraVenta obtenido: " + CodigoCabecera);

			if (rs.next()) {
				CodigoCabecera = rs.getInt(1);
				ArrayList<DetalleVenta> pvL = pv.getDetalles();
				DetalleVenta pvD;
				for (int i = 0; i < pv.getDetalles().size(); i++) {
					pvD = pvL.get(i);
					psD = con.prepareStatement(
							"INSERT INTO DetallesVentas (Code_CabV, Code_Producto, cantidad, precio_venta, subtotal, subtotal_con_iva) "
									+ " values (?,?,?,?,?,?) ");
					psD.setInt(1, CodigoCabecera);
					psD.setInt(2, pvD.getCode_producto().getCodeProducto());
					psD.setInt(3, pvD.getCantidad());
					BigDecimal precioProdc = pvD.getCode_producto().getPrecio_venta();
					BigDecimal cantidad = new BigDecimal(pvD.getCantidad());
					psD.setBigDecimal(4, precioProdc);
					BigDecimal subtotal = precioProdc.multiply(cantidad);
					if (pvD.getCode_producto().isIVA() != true) {
						psD.setBigDecimal(5, subtotal);
						psD.setBigDecimal(6, subtotal);
					} else {
						psD.setBigDecimal(5, subtotal);
						BigDecimal subtotalIva = subtotal.multiply(new BigDecimal(1.12));
						psD.setBigDecimal(6, subtotalIva);
						psD.executeUpdate();
					}

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
