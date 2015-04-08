package br.com.arq.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.arq.dao.FolhaDAO;
import br.com.arq.model.Folha;
import br.com.arq.ui.ListarFolhaUI;

@Component
public class ListarFolhaController extends AppController<Folha> {

	@Autowired
	private FolhaDAO dao;

	@Autowired
	private ListarFolhaUI ui;
	
	private PaginacaoController<Folha, FolhaDAO> pgController;
	
	@PostConstruct
	private void init() {
		pgController = new PaginacaoController<Folha, FolhaDAO>(dao, ui.getTabela());
	}
	
	public PaginacaoController<Folha, FolhaDAO> getPgController() {
		return pgController;
	}
	
	public ListarFolhaUI getUi() {
		return ui;
	}
	
	public FolhaDAO getDao() {
		return dao;
	}

}