package model;
public class Aviao {
	private Integer id;
	private String marca;
	private String modelo; 
	private int anodefabricacao;
	private int capacidade;
	private String cor;
	private Companhia companhia;
	
	/*FUNCAO DE PARA E FUNCIONAR E EDITAR ,ESTA ADICIONADO NO MARIADB,EXCLUIR DANDO ERROR */
	public  Aviao() {
		
	} 
	/*public Aviao(String marca, String modelo,int anodefabricacao,int capacidade, String cor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anodefabricacao =anodefabricacao;
		this.capacidade =capacidade;
		this.cor = cor;
	}

	public Aviao(int id ,String marca, String modelo,int anodefabricacao,int capacidade, String cor) {
		super();
		this.id =id;
		this.marca = marca;
		this.modelo = modelo;
		this.anodefabricacao =anodefabricacao;
		this.capacidade =capacidade;
		this.cor = cor;
	}*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnodefabricacao() {
		return anodefabricacao;
	}
	public void setAnodefabricacao(int anodefabricacao) {
		this.anodefabricacao = anodefabricacao;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	@Override
	public String toString() {
		return "Aviao [id=" + id + ", Marca=" + marca + ", Modelo=" + modelo + ", ano de Fabricação=" + anodefabricacao + ", Capacidade="+capacidade+", cor=" + cor
				+ "]";
	}

	public Companhia getCompanhia() {
		return companhia;
	}

	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}
	
	

}
