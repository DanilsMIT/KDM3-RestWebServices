package com.krakedev.inventarios.BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.TipoIdentificacion;
import com.krakedev.inventarios.exception.krakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class TipoIdentificacionBDD {

	public void InsertarTipoIdentificacion(TipoIdentificacion ti) throws krakedevException {
		Connection CON = null;
		PreparedStatement PS = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("INSERT INTO TipoIdentificacion (CodeI,descripcion)" + "values (?,?)");
			PS.setString(1, ti.getCodeI());
			PS.setString(2, ti.getDescripcion());
			PS.executeUpdate();

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar identificacion: " + e.getMessage());
		} finally {
			if (CON != null) {
				try {
					CON.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public TipoIdentificacion recuperarTipo(String ID) throws krakedevException {
		Connection CON = null;
		PreparedStatement PS = null;
		TipoIdentificacion pv = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("Select * from TipoIdentificacion where CodeI = ? ");
			PS.setString(1, ID);
			ResultSet RS = PS.executeQuery();
			if (RS.next()) {
				String CodeI = RS.getString("CodeI");
				String descripcion = RS.getString("descripcion");
				pv = new TipoIdentificacion(CodeI, descripcion);
			}

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar identificacion: " + e.getMessage());
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

	public ArrayList<TipoIdentificacion> recuperarTipos() throws krakedevException {
		ArrayList<TipoIdentificacion> pvL = new ArrayList<TipoIdentificacion>();
		Connection CON = null;
		PreparedStatement PS = null;
		TipoIdentificacion pv = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("Select * from TipoIdentificacion");
			ResultSet RS = PS.executeQuery();
			while (RS.next()) {
				String CodeI = RS.getString("CodeI");
				String descripcion = RS.getString("descripcion");
				pv = new TipoIdentificacion(CodeI, descripcion);
				pvL.add(pv);
			}

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar tipos de identificacion: " + e.getMessage());
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
