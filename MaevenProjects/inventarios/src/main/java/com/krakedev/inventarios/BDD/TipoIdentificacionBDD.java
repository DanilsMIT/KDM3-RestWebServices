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
				pv = new TipoIdentificacion(CodeI,descripcion);
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
	}}
