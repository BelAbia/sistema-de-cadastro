package br.com.classes;

public class Respostas {

	private int idRespostas;
	private int idQuestao;
	private String resposta;
	
	public Respostas(){
		
	}
	
	public Respostas(String resposta){
		this.resposta = resposta;
	}
	
	public Respostas(String resposta, int idQuestao){
		this.resposta = resposta;
		this.idQuestao = idQuestao;
	}
	
	
	
	
	public int getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}

	public int getIdRespostas() {
		return idRespostas;
	}
	public void setIdRespostas(int idRespostas) {
		this.idRespostas = idRespostas;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	@Override
	public String toString() {
		return "Respostas [idResposta=" + idRespostas + ", questao=" + idQuestao + ", resposta=" + resposta + "]";
	}
	
	
	
}
