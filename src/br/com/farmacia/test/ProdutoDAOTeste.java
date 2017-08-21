package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Ignore;
import org.junit.Test;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutoDAOTeste {
    
	
	@Test
	@Ignore
	public void salvar()throws SQLException{
		//Instancia um novo produto com valores
		Produtos p1 = new Produtos();
		p1.setDescricao("DIPIRONA");
		p1.setPreco(2.99);
		p1.setQuantidade(12L);
		
		//Associa��o do fornecedor ao produto
		Fornecedores f = new Fornecedores();
		f.setCodigo(13L);
		p1.setFornecedores(f);
		
		//Instancia fdao e salva
		ProdutoDAO fdao = new ProdutoDAO();
		fdao.salvar(p1);
	}
	
	@Test
	@Ignore
	public void listar()throws SQLException{
		//instancia dao e recebe a lista de produtos
		ProdutoDAO fdao = new ProdutoDAO();
		ArrayList<Produtos> lista = fdao.listar();
		
		for(Produtos p : lista){
			System.out.println("===================================================");
			System.out.println("C�digo do Produto: " + p.getCodigo());
			System.out.println("Descri��o do Produto: " + p.getDescricao());
			System.out.println("Valor:  " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("C�digo do Fornecedor: " + p.getFornecedores().getCodigo());
			System.out.println("Descri��o do Fornecedor: " + p.getFornecedores().getDescricao());
		}
		System.out.println("===================================================");
	}
	
	@Test
	@Ignore
	public void excluir()throws SQLException{
		//intancia produto e seleciona um codigo
		Produtos p = new Produtos();
		p.setCodigo(3L);
		
		//exclui usando dao indicando o produto selecionado
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);
	}	
	
	@Test
	public void editar()throws SQLException{
		//instancia o produto e seleciona um c�digo
		Produtos p = new Produtos();
		p.setCodigo(4L);
		p.setDescricao("Cataflan");
		p.setPreco(99.99);
		p.setQuantidade(100L);
		
		//Instancia fornecedor para selecionar o codigo
		Fornecedores f = new Fornecedores();
		f.setCodigo(24L);
		p.setFornecedores(f);
		
		//Executa Ediçãoo no dao
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
		
		
	}
	
	
	
}
