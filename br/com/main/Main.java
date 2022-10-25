package br.com.main;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.classes.Questoes;
import br.com.classes.Respostas;
import br.com.metodos.QuestoesDAO;
import br.com.metodos.RespostasDAO;

public class Main {

	public static void main(String[] args) {
	
		Scanner entrada = new Scanner(System.in);
		int escolha;
		int escolha2;
		String pegar;
		int id;

		Questoes questao = new Questoes();

		QuestoesDAO qdao = new QuestoesDAO();
		
		Respostas respostas = new Respostas();
		RespostasDAO rdao = new RespostasDAO();
		
		try {
			escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a operacao desejada? \n"
					+ "1- Inserir; \n"
					+ "2- Atualizar; \n"
					+ "3- Ler. \n"  ));
			 
			if (escolha >= 4) {
				JOptionPane.showMessageDialog( null, "Op��o inv�lida." , "Erro" , JOptionPane.ERROR_MESSAGE );
			}
		
		
			switch (escolha) {
			
			case 1:
				
				pegar = JOptionPane.showInputDialog("Digite o enunciado da quest�o:  ");
				questao.setEnunciado(pegar);
				qdao.saveQuestao(questao);
				
				pegar =JOptionPane.showInputDialog("Digite a resposta CORRETA da quest�o  ");
				respostas.setResposta(pegar);
				
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o C�DIGO da quest�o desta resposta. "));
				respostas.setIdQuestao(id);
				
				rdao.saveResposta(respostas);
				
				JOptionPane.showMessageDialog(null, "Quest�o cadastrada com sucesso!");
				JOptionPane.showMessageDialog(null," Enunciado da Quest�o: " + "\n" + questao.getEnunciado());
				JOptionPane.showMessageDialog(null," Resposta correta cadastrada: " + "\n" + respostas.getResposta());
				
				break;
				
			case 2:
				escolha2 = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - para atualizar o ENUNCIADO; \n"
						+ "2 - para atualizar a RESPOSTA. " ));
				if (escolha2 == 1) {
					pegar = JOptionPane.showInputDialog("Digite o enunciado da quest�o:  ");
					questao.setEnunciado(pegar);
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo da quest�o que deseja atualizar:  "));
					questao.setIdQuestao(id);
					
					qdao.updateQuestao(questao);
					JOptionPane.showMessageDialog(null, "Quest�o atualizada com sucesso!");
					
				}else if (escolha2 == 2) {
					pegar = JOptionPane.showInputDialog("Digite a resposta correta:  ");
					respostas.setResposta(pegar);
					id = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo da resposta que deseja atualizar:  "));
					respostas.setIdRespostas(id);
					
					rdao.updateResposta(respostas);
					JOptionPane.showMessageDialog(null, "Quest�o atualizada com sucesso!");
					
				} else {
					JOptionPane.showMessageDialog( null, "Op��o inv�lida." , "Erro" , JOptionPane.ERROR_MESSAGE );
				}
				
				break;
				
				
			case 3:
				qdao.join();
					
				break;
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			
			
		}
		
		entrada.close();
		
		
		
	}
}
