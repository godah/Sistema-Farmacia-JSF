package br.com.farmacia.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {
	
	public static void adicionarMensagemSucesso(String mensagem){
		//parametros FacesMessage
		//1 - tipo da mensagem
		//2 - titulo
		//3 - mensagem
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
	
	public static void adicionarMensagemErro(String mensagem){
		//parametros FacesMessage
		//1 - tipo da mensagem
		//2 - titulo
		//3 - mensagem
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR ,mensagem,mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
}
