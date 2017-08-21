package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	//Variaveis para conecção do banco de dados
	private static final String USUARIO = "root";
	private static final String SENHA = "cpd08";
	private static final String URL = "jdbc:mysql://localhost:3306/sistema";
	
	public static Connection conectar() throws SQLException{
		//Adiciona Driver para versoes mais antigas do java
		DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
		
		//Conecta ao Banco de dados
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		//metodo main para testar conecção com banco de dados
		try{
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conectado com sucesso!!");
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Conexão Falhou!!");
		}
	}
}
