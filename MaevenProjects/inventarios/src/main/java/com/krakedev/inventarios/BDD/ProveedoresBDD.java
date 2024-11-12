package com.krakedev.inventarios.BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.TipoIdentificacion;
import com.krakedev.inventarios.exception.krakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProveedoresBDD {
	public void InsertarProveedor(Proveedor pv) throws krakedevException{
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConexionBDD.obtenerConexion();
			ps=con.prepareStatement("INSERT INTO Proveedores (Identificador, TipoDocumento, nombre, telefono, correo, direccion) "
					+ " values(?,?,?,?,?,?) ");
			ps.setString(1, pv.getIdentificador());
			ps.setString(2, pv.getTipoDocumento().getCodeI());
			ps.setString(3, pv.getNombre());
			ps.setString(4, pv.getTelefono());
			ps.setString(5, pv.getCorreo());
			ps.setString(6, pv.getDireccion());
			ps.executeUpdate();
		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al Insertar proveedor"+e.getMessage());
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
	
	public Proveedor BuscarProveedor(String subcadena) throws krakedevException {
		Connection CON = null;
		PreparedStatement PS = null;
		Proveedor pv = null;
		TipoIdentificacionBDD tIBDD=new TipoIdentificacionBDD();
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("SELECT * FROM Proveedores where identificador = ?");
			PS.setString(1, subcadena);
			ResultSet RS = PS.executeQuery();
			if (RS.next()) {
				String Identificador = RS.getString("Identificador");
				TipoIdentificacion TipoDocumento = tIBDD.recuperarTipo(RS.getString("TipoDocumento"));
				String nombre = RS.getString("nombre");
				String telefono = RS.getString("telefono");
				String correo = RS.getString("correo");
				String direccion = RS.getString("direccion");
				pv = new Proveedor(Identificador, TipoDocumento, nombre, telefono, correo, direccion);
			}

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar proveedores: " + e.getMessage());
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
	public ArrayList<Proveedor> BuscarProveedores(String subcadena) throws krakedevException {
		ArrayList<Proveedor> pvL = new ArrayList<Proveedor>();
		Connection CON = null;
		PreparedStatement PS = null;
		Proveedor pv = null;
		TipoIdentificacionBDD tIBDD=new TipoIdentificacionBDD();
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("SELECT * FROM Proveedores where upper (nombre) like ?");
			PS.setString(1, "%" + subcadena.toUpperCase() + "%");
			ResultSet RS = PS.executeQuery();
			while (RS.next()) {
				String Identificador = RS.getString("Identificador");
				TipoIdentificacion TipoDocumento = tIBDD.recuperarTipo(RS.getString("TipoDocumento"));
				String nombre = RS.getString("nombre");
				String telefono = RS.getString("telefono");
				String correo = RS.getString("correo");
				String direccion = RS.getString("direccion");
				pv = new Proveedor(Identificador, TipoDocumento, nombre, telefono, correo, direccion);
				pvL.add(pv);
			}

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar proveedores: " + e.getMessage());
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
}
