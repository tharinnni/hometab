package aatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class MysqlConnector_Test {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/sys", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		if (conn != null) {
			System.out.println("Connected to the database!");
		} else {
			System.out.println("Failed to make connection!");
		}



		//			String sqlStatement = "select name,admintype from sr_admins_tbl where admintype='B'";
		//			
		//			PreparedStatement stat  = conn.prepareStatement(sqlStatement);
		//			ResultSet result = stat.executeQuery();
		//			
		//			while(result.next()) {
		//				String name = result.getString("name");
		//				String type = result.getString("admintype");
		//				System.out.println(name+"  "+type);
		//			}


	}

}
