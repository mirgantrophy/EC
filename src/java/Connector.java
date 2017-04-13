/* TODO
 * Prepared Statements
 */
package test;

import java.sql.*;
import java.util.Calendar;

public class Connector
{
	private final String JDC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/clients";
	private final String USERNAME = "";
	private final String PASSWORD = "";
	private Connection conn;

	public Connector()
	{
		Connection conn = null;
	}

	public void addClient(Client object)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
			String query = "INSERT INTO clientData(firstName, lastName, address, email, phoneNumber, startDate)" + "values(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement prep = conn.prepareStatement(query);
			
			prep.setString(1, object.getfirstName());
			prep.setString(2, object.getlastName());
			prep.setString(3, object.getAddress());
			prep.setString(4, object.getEmail());
			prep.setLong(5, object.getPhone());
			prep.setString(6, object.getDate());
			prep.execute();
			
			System.out.println("closing SQL connection");
			conn.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}