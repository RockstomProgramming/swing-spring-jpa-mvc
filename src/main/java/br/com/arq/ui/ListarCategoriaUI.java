package br.com.arq.ui;

import javax.annotation.PostConstruct;
import javax.swing.JDialog;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

import org.springframework.stereotype.Component;

import br.com.arq.model.Categoria;
import br.com.arq.util.AppTable;
import br.com.arq.util.BindingUtil;
import br.com.arq.util.BindingUtil.ColumnBinding;

@Component
public class ListarCategoriaUI extends AppUI<Categoria> {

	private static final String TITULO_FRAME = "Cadastro de Categoria";
	private AppTable<Categoria> tabela;
	private JDialog modal;
	
	@Override
	public void iniciarDados() {
		// TODO Auto-generated method stub
	}
	
	@PostConstruct
	private void init() {
		tabela = new AppTable<Categoria>();
		
		modal = new JDialog();
		modal.getContentPane().setLayout(new MigLayout());
		modal.setModal(true);
		modal.setTitle(TITULO_FRAME);
		modal.add(tabela.getComponente(), "wrap, grow, push");
		modal.pack();
		
		ColumnBinding clBinding = tabela.bind(getBinding());
		clBinding.addColumnBinding(0, "${descricao}", "Descrição");
		
		BindingUtil binding = clBinding.close();
		JTable table = tabela.getTabela();
		binding.add(table, "${selectedElement != null}", tabela.getBtnEditar(), "enabled");
		binding.add(table, "${selectedElement != null}", tabela.getBtnExcluir(), "enabled");
		binding.getBindingGroup().bind();
	}
	
	public AppTable<Categoria> getTabela() {
		return tabela;
	}

	@Override
	public Categoria getEntidade() {
		return null;
	}

	@Override
	public JDialog getFrame() {
		return modal;
	}
}
