package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Pedido;

public class GestionPedido {
	ArrayList<Pedido> Pedidos=new ArrayList<>();
	
	public List<Pedido> recuperarPedidos() {
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendas", "root", "root");){
			String sql="select * from pedidos";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);			
			while(rs.next()) {
				Pedido c=new Pedido(rs.getString("producto"),rs.getString("ipCliente"),rs.getInt("unidades"),rs.getDate("fecha"));
				Pedidos.add(c);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return Pedidos;
	}
	
	public void registraProducto(String producto,int unidades) {
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendas", "root", "root");){
			String sql="insert into pedidos (pedidos,productos,unidades....) values ('producto','unidades')";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
