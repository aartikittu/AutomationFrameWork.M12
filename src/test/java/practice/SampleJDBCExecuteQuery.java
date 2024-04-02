package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Throwable 
	{
		Driver driverRef=new Driver();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m11db", "root", "tiger");
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("Select * from candidate_info");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		con.close();
	}

}
