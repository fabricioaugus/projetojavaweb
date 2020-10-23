package AviaoController;
import java.util.List;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.AviaoDao;
import dao.CompanhiaDao;
import model.Aviao;
import model.Companhia;

@ManagedBean
@ViewScoped
public class AviaoController {
	private Aviao aviao = new Aviao();
	private Integer idCompanhia;

public void adicionar() {
	 
	
	AviaoDao dao = new AviaoDao();
	try { 
	Companhia	t = new CompanhiaDao().listaPorId(idCompanhia);
	 aviao.setCompanhia(t);
		if(aviao.getId()==null) {
		dao.adiciona(aviao);
		}else {
			dao.atualiza(aviao);
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	aviao = new Aviao();
	//idAviao= null; 
}

public Aviao getAviao() {
	return aviao;
}
public void setAviao(Aviao aviao) {
	this.aviao = aviao;
}

public void carregar(Aviao a) {
	aviao = a;
idCompanhia =   a.getCompanhia().getId();
}


				/* LISTA  TODOS OS AVIAO NAO ESTA LISTANDO  */
public List<Aviao> getTodosAviao(){
	List<Aviao> lista =null;
	try {
		lista = new AviaoDao().listaTodos();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lista;
	
}

public List<Companhia> getTodosTipos(){
List <Companhia> lista = null;
try {
 lista = new CompanhiaDao().listaTodos();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return lista;
}
public Integer getIdCompanhia() {
	return idCompanhia;
}
public void setIdCompanhia(Integer idCompanhia) {
	this.idCompanhia = idCompanhia;
}
          //REMOVER  MA
public void remover(Aviao a){
	try {
		new AviaoDao().remove(a.getId());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
