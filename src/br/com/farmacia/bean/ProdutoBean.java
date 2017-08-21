package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

	private Produtos produtos;
	private ArrayList<Produtos>itens;
	private ArrayList<Produtos>itensFiltrados;
	private ArrayList<Fornecedores>comboFornecedores;
	
	//teste permissao booleana funcionando no botao novo
	private boolean novo;
	
	public ProdutoBean(){
		this.novo = false;
	}
	public boolean isNovo() {
		return novo;
	}
	public void setNovo(boolean novo) {
		this.novo = novo;
	}
	
	
	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	
	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}

	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	//constroi metodo quando a pagina for iniciada
	@PostConstruct
	public void prepararPesquisa(){	
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			
			itens = fdao.listar(); 
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		} 
		
	}	
	
	public void prepararNovo(){
		
		try {
			produtos = new Produtos();
			FornecedoresDAO dao = new FornecedoresDAO();
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void novo(){
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			
			//executa salvamento
			fdao.salvar(produtos);
			
			//atualiza a lista
			itens = fdao.listar();
			
			//exibe confirmação
			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");
			
		} catch (Exception e) {
			//exiber erro
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void excluir(){
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			//executa exclusao
			fdao.excluir(produtos);
			
			//atualiza lista
			itens = fdao.listar();
			
			//exibe confirmação
			JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso!");
			
		} catch (Exception e) {
			//exibe erro
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	public void prepararEditar(){
		
		try {
			//gera lista de fornecedores para combobox
			FornecedoresDAO fdao = new FornecedoresDAO();
			comboFornecedores = fdao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	public void editar(){
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			//executa edição
			fdao.editar(produtos);
				
			//atualiza lista
			itens = fdao.listar();
			
			//exibe confirmação
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");
			
		} catch (Exception e) {
			//exibe erro
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
}
