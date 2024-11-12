package com.krakedev.inventarios.BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.exception.krakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class CategoriaBDD {
	public ArrayList<Categoria> recuperarCategorias() throws krakedevException {
		ArrayList<Categoria> pvL = new ArrayList<Categoria>();
		Connection CON = null;
		PreparedStatement PS = null;
		Categoria pv = null;
		Categoria pvD = null;

		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement("Select * from Categorias");
			ResultSet RS = PS.executeQuery();
			while (RS.next()) {
				pv = new Categoria();
				int codeCat = RS.getInt("codecat");
				String detalle = RS.getString("nombre");
				int codePadre = RS.getInt("categoriapadre");

				pvD = new Categoria();
				pvD.setCodeCat(codePadre);

				pv.setCodeCat(codeCat);
				pv.setDetalles(detalle);
				pv.setCat_Padre(pvD);
				pvL.add(pv);
			}

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar categorias: " + e.getMessage());
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

	public void ActualizarCategoria(Categoria pv) throws krakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("UPDATE Categorias set nombre = ?, categoriapadre = ? where codecat = ? ");
			ps.setString(1, pv.getDetalles());
			if (pv.getCat_Padre().getCodeCat() != 0) {
				ps.setInt(2, pv.getCat_Padre().getCodeCat());
			} else {
				ps.setNull(2, pv.getCat_Padre().getCodeCat());
			}
			ps.setInt(3, pv.getCodeCat());
			ps.executeUpdate();
		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al Insertar categoria" + e.getMessage());
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

	public void CrearCategoria(Categoria pv) throws krakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("INSERT INTO Categorias (nombre, CategoriaPadre) " + " values(?,?) ");
			ps.setString(1, pv.getDetalles());
			if (pv.getCat_Padre().getCodeCat() != 0) {
				ps.setInt(2, pv.getCat_Padre().getCodeCat());
				ps.executeUpdate();
			} else {
				ps.setNull(2, pv.getCat_Padre().getCodeCat());
				ps.executeUpdate();
			}
		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al Insertar categoria" + e.getMessage());
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
