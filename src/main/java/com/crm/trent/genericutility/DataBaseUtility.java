package com.crm.trent.genericutility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Database Utility is implemented using JDBC , which is used to connect to any database using java code
 * @author User
 *
 */
public class DataBaseUtility {
 
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	
	/**
	 * This method will perform the mysql database connection
	 * @throws SQLException
	 */
	public void connectDB()
	{
		try {
			driver = new Driver() {
				
				public boolean jdbcCompliant() {
					// TODO Auto-generated method stub
					return false;
				}
				
				public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}
				
				public Logger getParentLogger() throws SQLFeatureNotSupportedException {
					// TODO Auto-generated method stub
					return null;
				}
				
				public int getMinorVersion() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				public int getMajorVersion() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				public Connection connect(String url, Properties info) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}
				
				public boolean acceptsURL(String url) throws SQLException {
					// TODO Auto-generated method stub
					return false;
				}
			};
			DriverManager.registerDriver(driver);
			DriverManager.getConnection(IConstants.JDBC_URL_String , IConstants.JDBC_USERNAME , IConstants.JDBC_PASSWORD);
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This Method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB()
	{
		try
		{
			connection.close();
		}
		catch(Exception e)
		{
			
		}
	}
	/**
	 * This method will execute the query
	 * @param query
	 * @return
	 * @throws SQLException 
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query) throws SQLException
	{
		result = connection.createStatement().executeQuery(query);
		return result;
	}
	/**
	 * This method will execute the query based on query and it will verify the data
	 * @param query
	 * @param columnName
	 * @param @expectedData
	 * @return
	 * @throws SQLException 
	 * @throws Throwable
	 */
	public boolean executeQueryAndVerify(String query , int columnIndex, String expectedData) throws SQLException
	{
		boolean flag = false;
		result = connection.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnIndex).equals(expectedData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expectedData+"==>Data is verifield in the database table");
			return flag;
		}
		else
		{
			System.out.println(expectedData+"==>Data is not verified in the database");
			return flag;
		}
	}
}
