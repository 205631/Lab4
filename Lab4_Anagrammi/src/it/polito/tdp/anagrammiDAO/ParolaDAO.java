package it.polito.tdp.anagrammiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ParolaDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root";
	
	public boolean check(String parola){
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			String template = "select nome from parola where nome=?";
			
			PreparedStatement st = conn.prepareStatement(template);
			st.setString(1,parola);

			ResultSet res=st.executeQuery();
			
			if(res.next()){
				return true;
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
