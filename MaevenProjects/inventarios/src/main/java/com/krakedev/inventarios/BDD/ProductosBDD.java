package com.krakedev.inventarios.BDD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.UDM;
import com.krakedev.inventarios.exception.krakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProductosBDD {
	
	public void InsertarProducto(Producto pv) throws krakedevException{
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConexionBDD.obtenerConexion();
			ps=con.prepareStatement("INSERT INTO Productos (nombre, Code_UDM, Precio_Venta, IVA, costo, Code_Cat, stock) "
					+ " values(?,?,?,?,?,?,?) ");
			ps.setString(1, pv.getNombre());
			ps.setString(2, pv.getCode_UDM().getUDM());
			ps.setBigDecimal(3,pv.getPrecio_venta());
			ps.setBoolean(4, pv.isIVA());
			ps.setBigDecimal(5,pv.getCosto());
			ps.setInt(6, pv.getCode_Cat().getCodeCat());
			ps.setInt(7, pv.getStock());
			ps.executeUpdate();
		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al Insertar Producto "+e.getMessage());
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
	public ArrayList<Producto> BuscarProducto(String subcadena) throws krakedevException {
		ArrayList<Producto> pvL = new ArrayList<Producto>();
		Producto pv = null;
		UDM ud=null;
		Categoria cat=null;
		Connection CON = null;
		PreparedStatement PS = null;
		try {
			CON = ConexionBDD.obtenerConexion();
			PS = CON.prepareStatement(
					"Select prodc.codeproducto, prodc.nombre as nombre_producto, prodc.code_udm, udm.descripcion as nombre_UDM, "
					+ "cast(prodc.precio_venta as decimal(5,2)),prodc.iva,cast(prodc.costo as decimal(5,2)),prodc.code_cat,catg.nombre as nombre_categoria, prodc.stock "
					+ "FROM Productos prodc, UnidadesMedida UDM, Categorias catg "
					+ "Where prodc.code_udm = UDM.codeudm and prodc.code_cat = catg.codecat and upper(prodc.nombre) like ?");
			PS.setString(1, "%" + subcadena.toUpperCase() + "%");
			ResultSet RS = PS.executeQuery();
			while (RS.next()) {
				int CodeProdc=RS.getInt("codeproducto");
				String NombreProdc=RS.getString("nombre_producto");
				String CodeUDM=RS.getString("code_udm");
				String NombreUDM=RS.getString("nombre_udm");
				BigDecimal PrecioVenta=RS.getBigDecimal("precio_venta");
				boolean TieneIva=RS.getBoolean("iva");
				BigDecimal Costo=RS.getBigDecimal("costo");;
				int CodeCat=RS.getInt("code_cat");
				String NombreCodeCat=RS.getString("nombre_categoria");
				int stock=RS.getInt("stock");
				
				ud=new UDM(CodeUDM,NombreUDM);
				cat= new Categoria(CodeCat,NombreCodeCat);
				pv=new Producto(CodeProdc,NombreProdc,ud,PrecioVenta,TieneIva,Costo,cat,stock);
				pvL.add(pv);
			}

		} catch (krakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new krakedevException("Error al consultar Producto: " + e.getMessage());
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
