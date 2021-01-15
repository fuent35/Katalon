package querys

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

import javax.swing.ToolTipManager.insideTimerAction

import com.kms.katalon.core.annotation.Keyword

import utils.ConnectionDB

public class Sentences {
	public int getNextSecuence(Connection con, String secuence){
		Statement stmt = con.createStatement();
		String qry = "SELECT NEXT VALUE FOR dbo." + secuence + " as NextSecuence";
		ResultSet rs = stmt.executeQuery(qry);
		int nextSecuece = 0;

		if(rs.next()){
			nextSecuece = Integer.parseInt(rs.getString("NextSecuence").toString());
		} else {
			println "Error trying to get SpecimenID value from DB";
		}
		return nextSecuece;
	}
	
	@Keyword
	public String getNextSecuenceFormated(String secuence, String prefix){
		ConnectionDB conInstance = new ConnectionDB();
		Connection con = conInstance.getInstace();
		Statement stmt = con.createStatement();
		String qry = "SELECT NEXT VALUE FOR dbo." + secuence + " as NextSecuence";
		ResultSet rs = stmt.executeQuery(qry);
		String nextSecuece = "";

		if(rs.next()){
			nextSecuece = prefix + String.format("%010d", Integer.parseInt(rs.getString("NextSecuence").toString()));
		} else {
			println "Error trying to get " + secuence + " value from DB";
		}
		
		// Close connection
		conInstance.closeConnection();
		conInstance = null;
		return nextSecuece;
	}
}