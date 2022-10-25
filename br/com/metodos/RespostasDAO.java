package br.com.metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.classes.Respostas;
import br.com.connection.ConnectionFactory;


public class RespostasDAO {

	public void saveResposta(Respostas resposta) {
		
		String sql = "INSERT INTO respostas (resposta, idQuestao) VALUES (?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, resposta.getResposta());
			pstm.setInt(2, resposta.getIdQuestao());
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
				
				if(conn != null) {
					conn.close();
				}
				}
				catch(Exception e) {
				e.printStackTrace();
				}
		}
	}
	  
	
	public void updateResposta (Respostas respostas) {
		
		String sql = "UPDATE respostas SET resposta = ? WHERE idRespostas = ?;";
		Connection conn = null;
		PreparedStatement  pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, respostas.getResposta());
			pstm.setInt(2, respostas.getIdRespostas());
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
					
					if(conn != null) {
						conn.close();
						}
			
					} 
					catch (Exception e)
					{
					  e.printStackTrace();
					}
			}
	}
}


