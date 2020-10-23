package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao;
	//private String banco = "db_prova"; // nome do BD
	private String login = "root"; // login do mysql
	private String senha = ""; // senha do mysql

	public Conexao() throws ClassNotFoundException, SQLException  {
		// carrega o drive
		Class.forName("com.mysql.cj.jdbc.Driver");

		// estabelece conex�o: drive://servidor:porta/banco, login, senha
		conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_prova?useTimezone=true&serverTimezone=UTC", this.login, this.senha);

		// as modificac�es so s�o salvas no banco com o commit (explicito no c�digo)
		conexao.setAutoCommit(false);
	}

	// verifica se n�o existe conexao, sen�o houver cria uma nova conex�o
	public static Connection getInstance() throws ClassNotFoundException, SQLException {
		if (conexao == null)
			new Conexao();

		return conexao;
	}
}