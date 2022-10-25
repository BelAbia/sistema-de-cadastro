package br.com.metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import br.com.classes.Questoes;
import br.com.connection.ConnectionFactory;

public class QuestoesDAO {
	
	public void saveQuestao(Questoes questoes) {

		String sql = "INSERT INTO questoes (enunciado) VALUES (?)";		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, questoes.getEnunciado());
			pstm.execute();
			
			}
		
		catch (Exception e) 
			{
			  e.printStackTrace();
			}
		
		finally
			{
			try 
				{
				if(pstm != null) {
					pstm.close();
					}
				
				if(conn != null) {
					conn.close();
					}
				
				}
			
			catch(Exception e)
				{
				  e.printStackTrace();
				}
		}
	}
	  
	
	public void updateQuestao (Questoes questoes) {
		
		String sql = "UPDATE questoes SET enunciado = ? WHERE idQuestao = ?;";
		Connection conn = null;
		PreparedStatement  pstm = null;
		
		try 
		{
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, questoes.getEnunciado());
			pstm.setInt(2, questoes.getIdQuestao());
			pstm.execute();
			
		}
		catch (Exception e) 
		{
		  e.printStackTrace();
		}
		
		finally
		{
			try {
				if(pstm != null) {
					pstm.close();
					}
				if(conn != null){
					conn.close();
					}
				} 
			
			catch (Exception e) 
				{
				  e.printStackTrace();
				}
		}
	}
	
	
	public void join() {
		
		Connection conn = null;
		java.sql.Statement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.createStatement();
			
			rset = pstm.executeQuery("SELECT q.enunciado, r.resposta FROM questoes q INNER JOIN respostas r on q.idQuestao = r.idQuestao;");
			
			
			while(rset.next()) 
			{
				System.out.println("ENUNCIADO: \n" +rset.getString(1));
				System.out.println("RESPOSTA: \n" + rset.getString(2));
				
				JOptionPane.showMessageDialog(null, "\"ENUNCIADO: \n" + rset.getString(1));
				JOptionPane.showMessageDialog(null, "RESPOSTA: \n" + rset.getString(2));	
			}		
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
		
		finally 
		{
		try {
			if(pstm != null) {
				pstm.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			}
			catch(Exception e) {
			e.printStackTrace();
			}

		}
	}
}
