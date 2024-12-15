package com.krakedev.fubol.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.fubol.entidades.EquiposParticipantes;
import com.krakedev.fubol.entidades.UsuariosApp;
import com.krakedev.fubol.entidades.partidos;
import com.krakedev.fubol.entidades.pronosticos;
import com.krakedev.inventarios.utils.ConexionBDD;
import com.krakedev.inventarios.utils.krakedevException;

public class PronosticosBDD {

	public void registrarPronostico(pronosticos p) throws krakedevException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con=ConexionBDD.obtenerConexion();
			ps=con.prepareStatement("insert into pronosticos (codigo_usuario, codigo_partido, codigo_equipo_1, marcador_asignado_e1, codigo_equipo_2, marcador_asignado_e2)"
					+ "values(?,?,?,?,?,?)");
			ps.setInt(1, p.getCodigo_usuario().getCodigo());
			ps.setInt(2, p.getCodigo_partido().getCodigo());
			ps.setString(3, p.getCodigo_equipo1().getCodigo());
			ps.setInt(4, p.getPronostico_e1());
			ps.setString(5, p.getCodigo_equipo2().getCodigo());
			ps.setInt(6, p.getPronostico_e2());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar los pronosticos: " + e.getMessage());
		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
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

	public ArrayList<pronosticos> recuperarPronosticos(int codeU) throws krakedevException {
		ArrayList<pronosticos> pL = new ArrayList<pronosticos>();
		pronosticos p = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from pronosticos where codigo_usuario = ?");
			ps.setInt(1, codeU);
			rs = ps.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("codigo_pronostico");
				UsuariosApp user = new UsuariosApp(rs.getInt("codigo_usuario"));
				partidos match = new partidos(rs.getInt("codigo_partido"));
				EquiposParticipantes e1 = new EquiposParticipantes(rs.getString("codigo_equipo_1"));
				EquiposParticipantes e2 = new EquiposParticipantes(rs.getString("codigo_equipo_2"));
				int marcadorE1 = rs.getInt("marcador_asignado_e1");
				int marcadorE2 = rs.getInt("marcador_asignado_e2");

				p = new pronosticos(code, user, match, e1, e2, marcadorE1, marcadorE2);
				pL.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar los pronosticos: " + e.getMessage());
		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return pL;
	}
}
