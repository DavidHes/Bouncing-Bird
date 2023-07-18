import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class OracleDsSingleton {
	
	private static OracleDsSingleton dss = null;

	private static OracleDataSource ds = null;
	private String url = "jdbc:oracle:thin:@//10.50.205.21:1521/dbk.hwr-berlin.de";
	private String password = "neuesPw";
	private String user = "OOP2_SS23_G1_P1";
	
	
	
	private OracleDsSingleton(){
		
		try {
			ds = new OracleDataSource();
			
			ds.setDataSourceName("HWROracleDataSource");
			ds.setURL(url);
			
			ds.setUser(user);
			ds.setPassword(password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static OracleDsSingleton getInstance() {
		if(dss == null) dss = new OracleDsSingleton();
		return dss;
	}
	
	public Connection getConnection() throws SQLException{
		Connection con = null;
		con = ds.getConnection();
		return con;
	}
	

}
