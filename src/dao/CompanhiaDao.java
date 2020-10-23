package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Companhia;



public class CompanhiaDao {
	
	public List<Companhia> listaTodos() throws ClassNotFoundException, SQLException{
		List<Companhia> lista = new LinkedList<Companhia>();
		
		String sql = "SELECT * FROM companhiaaerea";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Companhia t = new Companhia();
			t.setId(rs.getInt("idCompanhia"));
			t.setNome(rs.getNString("nomeCompanhia"));
			
			lista.add(t);
		}
		
		return lista;
	}
	
	public Companhia listaPorId(int id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM companhiaaerea WHERE idCompanhia=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		ResultSet rs = comandoSql.executeQuery();
		
		Companhia t = null;
		
		if (rs.next()) {
			t = new Companhia();
			t.setId(rs.getInt("idCompanhia"));
			t.setNome(rs.getString("nomeCompanhia"));
		}
		
		return t;
	}

}
