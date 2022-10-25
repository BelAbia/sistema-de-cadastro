package br.com.classes;

public class Questoes {
	
	private int idQuestao;
	private String enunciado;
	
	public Questoes(){
		
	}
	
	public Questoes( String enunciado ){
		this.enunciado = enunciado;
		
	}
	
	
	public int getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	@Override
	public String toString() {
		return "Questoes [idQuestao=" + idQuestao + ", enunciado=" + enunciado + "]";
	}
	
	

}
