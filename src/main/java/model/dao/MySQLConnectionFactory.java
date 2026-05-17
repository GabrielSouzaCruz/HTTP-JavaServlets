package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.ModelException;

public class MySQLConnectionFactory {

	// Versão atualizada do Driver para o MySQL 8+
	private static final String JDBC_DRIVER_NAME = 
			"com.mysql.cj.jdbc.Driver";
	
	// Rota real para o servidor do MySQL rodando localmente na porta 3306
	private static final String DATABASE_URL = 
			"jdbc:mysql://localhost:3306/atividade_http?useTimezone=true&serverTimezone=UTC&useSSL=false";

	// Credenciais padrão (ajuste a password se a sua não for vazia)
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static Connection getConnection() throws ModelException {
		try {
			// Carrega o driver na memória
			Class.forName(JDBC_DRIVER_NAME);

			// Solicita e retorna a conexão com o banco atividade_http
			return DriverManager.getConnection(
					DATABASE_URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new ModelException("Driver não encontrado no projeto", e);
		} catch (SQLException e) {
			throw new ModelException("Falha na conexão com o BD. Verifique se o MySQL está ativo.", e);
		}
	}
}