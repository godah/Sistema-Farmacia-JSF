package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	private Fornecedores fornecedores;
	private ArrayList<Fornecedores>itens;
	private ArrayList<Fornecedores>itensFiltrados;
	
	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public ArrayList<Fornecedores> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	//constroi metodo quando a pagina for iniciada
	@PostConstruct
	public void prepararPesquisa(){	
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			
			itens = fdao.listar();
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		} 
		
	}
	
	public void prepararNovo(){
		fornecedores = new Fornecedores();
	}
	
	public void novo(){
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			
			//executa salvamento
			fdao.salvar(fornecedores);
			
			//atualiza a lista
			itens = fdao.listar();
			
			//exibe confirmação
			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso!");
			
		} catch (Exception e) {
			//exiber erro
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
		
	public void excluir(){
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			//executa exclusao
			fdao.excluir(fornecedores);
			
			//atualiza lista
			itens = fdao.listar();
			
			//exibe confirmação
			JSFUtil.adicionarMensagemSucesso("Fornecedor excluido com sucesso!");
			
		} catch (Exception e) {
			//exibe erro
			JSFUtil.adicionarMensagemErro("N�o � poss�vel excluir Fornecedor que tenha um produto associado!");
			e.printStackTrace();
		}
	}
	
	
	public void editar(){
		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			//executa edição
			dao.editar(fornecedores);
			
			//atualiza lista
			itens = dao.listar();
			
			//exibe confirma��o
			JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso!");
			
		} catch (Exception e) {
			//exibe erro
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
}

