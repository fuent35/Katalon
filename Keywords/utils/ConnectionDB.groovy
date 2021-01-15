package utils

import java.sql.Connection
import java.sql.SQLException

import com.kms.katalon.core.annotation.Keyword
import com.microsoft.sqlserver.jdbc.SQLServerDataSource

public class ConnectionDB {
		private static Connection instance = null;

	public Connection getInstace(){
		if(instance == null){
			getConnection();
		}
		return instance;
	}

	private static void setInstance(Connection con){
		instance = con;
	}

	private void getConnection(){
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("test");
		ds.setPassword("te5t");
		ds.setServerName("10.2.1.15");
		ds.setDatabaseName("SampleDataDb");
		Connection con = null;

		try {
			setInstance(ds.getConnection());
			System.out.println("Communication with DB Successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		try {
			instance.close();
			instance = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
