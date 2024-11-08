package com.krakedev.inventarios.BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.exception.krakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProveedoresBDD {

	public ArrayList<Proveedor> BuscarProveedores(String subcadena) throws krakedevException {
		ArrayList<Proveedor> pvL = new ArrayList<Proveedor>();
		Connection CON = null;
		PreparedStatement PS = null;
		Proveedor pv = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("SELECT Identificador, TipoDocumento, nombre, telefono, correo, direccion "
					+ "FROM Proveedores " + "where upper (nombre) like ?");
			PS.setString(1, "%" + subcadena.toUpperCase() + "%");
			ResultSet RS = PS.executeQuery();
			while (RS.next()) {
				String Identificador = RS.getString("Identificador");
				String TipoDocumento = RS.getString("TipoDocumento");
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
			throw new krakedevException("Error al consultar: " + e.getMessage());
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
