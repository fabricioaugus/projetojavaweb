package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Aviao;
import model.Companhia;

public class AviaoDao {
	
	public void adiciona(Aviao a) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO aviao(marca,modelo,anodefabricacao,capacidade,cor,idCompanhia2) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, a.getMarca());
		comandoSql.setString(2,  a.getModelo());
		comandoSql.setInt(3, a.getAnodefabricacao());
		comandoSql.setInt(4, a.getCapacidade());
		comandoSql.setString(5, a.getCor());
		comandoSql.setInt(6, a.getCompanhia().getId());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void atualiza(Aviao a) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE aviao SET marca=?,modelo=?,anodefabricacao=?,capacidade=?,cor=?,idCompanhia2 =? WHERE idAviao = ?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, a.getMarca());
		comandoSql.setString(2,  a.getModelo());
		comandoSql.setInt(3, a.getAnodefabricacao());
		comandoSql.setInt(4, a.getCapacidade());
		comandoSql.setString(5, a.getCor());
		comandoSql.setInt(6, a.getCompanhia().getId());
		comandoSql.setInt(7, a.getId());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public void remove(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM aviao WHERE idAviao=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public Aviao listaPorId(int id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM aviao WHERE idAviao=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		ResultSet rs = comandoSql.executeQuery();
		
		Aviao a = null;
		
		if (rs.next()) {
			a = new Aviao();
			a.setId(rs.getInt("idAviao"));
			a.setMarca(rs.getString("marca"));
			a.setModelo(rs.getString("modelo"));
			a.setAnodefabricacao(rs.getInt("anodefabricacao"));
			a.setCapacidade(rs.getInt("capacidade"));
		}
		
		return a;
	}

	public List<Aviao> listaTodos() throws ClassNotFoundException, SQLException{ {
	List<Aviao> lista = new LinkedList<Aviao>();
		
		String sql = "SELECT * FROM aviao INNER JOIN companhiaaerea ON "
				+"aviao.idCompanhia2 = companhiaaerea.idCompanhia";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Aviao a = new Aviao();
			a.setId(rs.getInt("idAviao"));
			a.setMarca(rs.getString("marca"));
			a.setModelo(rs.getString("modelo"));
			a.setAnodefabricacao(rs.getInt("anodefabricacao"));
			a.setCapacidade(rs.getInt("capacidade"));
			a.setCor(rs.getString("cor"));
			lista.add(a);

			Companhia s = new Companhia();
			s.setId(rs.getInt("idCompanhia"));
			s.setNome(rs.getString("nomeCompanhia"));
			a.setCompanhia(s);
			
		}
		
		return lista;
	}
	
	}

	
}
