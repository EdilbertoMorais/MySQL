package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperaConexao();

		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (id, nome, descricao) VALUES ('2', 'GELADEIRA', 'GELADEIRA BRASTEMP')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);

		}
		rst.close();
		stm.close();
		connection.close();
	}
}
