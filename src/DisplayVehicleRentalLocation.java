//import for sql Connection, DriverManager, ResultSet, Statement
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.*;	// For connecting to SQL Server

/**
* Abstract: Sample code for the Final Project
* @author Derrick Warren
* @since  2020
* @version 1.0
*/
public class DisplayVehicleRentalLocation
{
	//define the Connection
	private static Connection m_conAdministrator;
	//define the table, primary key, and column

	/** 
	 * Method: LoadListFromDatabase
	 * Abstract: This will load the list from the table.
	 * @param strTable table for location pickups
	 * @param strPrimaryKeyColumn primary key
	 * @param strNameColumn1 column 1 for data
	 * @param strNameColumn2 column 2 for data
	 * @param strNameColumn3 column 3 for data
	 * @param strNameColumn4 column 4 for data
	 * @return blnResult true or false
	 */
	public static boolean LoadListFromDatabase( String strTable, String strPrimaryKeyColumn, String strNameColumn1, String strNameColumn2, 
												String strNameColumn3, String strNameColumn4 ) 
	{
		
		//set flag to false
		boolean blnResult = false;
		
		try
		{
			String strSelect = "";
			Statement sqlCommand = null;
			ResultSet rstTSource = null;
			int intID = 0;
			String strName = "";
			String strAddress = "";
			String strCity = "";
			String strZip = "";
			
			// Build the SQL string
			strSelect = "SELECT " + strPrimaryKeyColumn + ", " + strNameColumn1 
					    + ", " + strNameColumn2
					    + ", " + strNameColumn3
					    + ", " + strNameColumn4
						+ " FROM " + strTable
						+ " ORDER BY " + strNameColumn1; 
					
			// Retrieve the all the records	
			sqlCommand = m_conAdministrator.createStatement( );
			rstTSource = sqlCommand.executeQuery( strSelect );
			// Loop through all the records
			System.out.println("Here are the pickup locations - we will call you with a location confirmation");
			while( rstTSource.next( ) == true )
			{
				// Get ID and Name from current row
				intID = rstTSource.getInt( 1 );
				strName = rstTSource.getString( 2 );
				strAddress = rstTSource.getString( 3 );
				strCity = rstTSource.getString( 4 );
				strZip = rstTSource.getString( 5 );
				// Print the list
			    //	System.out.println("Pick up ID: " + intID 
			    //			           + "\t Name: " + strName 
			    //			           + " Address: " + strAddress 
			    //			           + "\t City: " + strCity);
				System.out.printf( "ID: %-5d Name: %-14s Address: %-17s City: %-12s Zip: %-10s %n", 
									intID,
									strName,
									strAddress,
									strCity,
									strZip);
			}
			// Clean up
			rstTSource.close( );
			sqlCommand.close( );
			// Success
			blnResult = true;
		}
		catch 	(Exception e) {
			System.out.println( "Error loading table" );
			System.out.println( "Error is " + e );
		}
		
		return blnResult;
		}

		
		
		/** 
		 * method name: OpenDatabaseConnectionMSAccess
		 * The opens the database connection	
		 * This requires the following drivers: Use UCanAccess, an open-source JDBC driver.
		 * Include the following jar files in your code:
		 *		ucanaccess-2.0.7.jar
		 *		jackcess-2.0.4.jar
		 *		commons-lang-2.6.jar
		 *		commons-logging-1.1.3.jar
		 *		hsqldb.jar
		 *	To include those files select "Project / Properties / Java Build Path"
		 *	from the menu.  Click on the "Libraries" tab.  Click "Add External JARs".
		 *	Browse to the above jar files, which should be in a directory in your
		 * 	project (e.g. JDBC-to-MSAccess).  Select all five files and click "Open".  Click "OK".
		 *	
		 * Be sure to add the drivers to your program by selecting Project,  Properties, Java Build Path
		 * @return blnResult
		 */
		/*
		public static boolean OpenDatabaseConnectionMSAccess( )
		{
			boolean blnResult = false;
			
			try {
				String strConnectionString = "";
				
				// Server name/port, IP address/port or path for file based DB like MS Access
				// System.getProperty( "user.dir" ) => Current working directory from where
				// application was started
				strConnectionString = "jdbc:ucanaccess://" + System.getProperty( "user.dir" )
									+ "\\Database\\dbVehicleRental.accdb";
				// Open a connection to the database
				m_conAdministrator = DriverManager.getConnection( strConnectionString );
				// Success
				blnResult = true;
			}
			catch 	(Exception e) {
				System.out.println( "Try again - error in OpenDB ");
				System.out.println( "Error is " + e );
			}
			return blnResult;
		}*/
		
		
		/**
		 * OpenDatabaseConnectionSQLServer - get SQL db connection
		 * @return blnResult
		 */	
		public static boolean OpenDatabaseConnectionSQLServer( )
		{
			boolean blnResult = false;
			
			try
			{
				SQLServerDataSource sdsVehicleRental = new SQLServerDataSource( );
				sdsVehicleRental.setServerName( "FR33M1ND" ); // localhost or IP or server name
				// sdsVehicleRental.setServerName( "localhost\\SQLExpress" ); // SQL Express version
				sdsVehicleRental.setPortNumber( 1433 );
				sdsVehicleRental.setDatabaseName( "dbVehicleRental" );
				
				// Login Type:
				
					// Windows Integrated - MOST STUDENTS WILL USE THIS ONE!
					//tg-comment out --sdsVehicleRental.setIntegratedSecurity( true );
					
					// OR
					
					// SQL Server
				     sdsVehicleRental.setUser( "sa" );
					 sdsVehicleRental.setPassword( "Joseph87" );	// Empty string "" for blank password
				
				// Open a connection to the database
				m_conAdministrator = sdsVehicleRental.getConnection(  );
				
				// Success
				blnResult = true;
			}
			catch( Exception excError )
			{
				// Display Error Message
				System.out.println( "Cannot connect - error: " + excError );

				// Warn about SQL Server JDBC Drivers
				System.out.println( "Make sure download MS SQL Server JDBC Drivers");
			}
			
			return blnResult;
		}
			
		
		/**
		* Name: CloseDatabaseConnection
		* Abstract: Close the connection to the database
		* @return blnResult
		*/ 
		public static boolean CloseDatabaseConnection( )
		{
			boolean blnResult = false;
			
			try
			{
				// Is there a connection object?
				if( m_conAdministrator != null )
				{
					// Yes, close the connection if not closed already
					if( m_conAdministrator.isClosed( ) == false ) 
					{
						m_conAdministrator.close( );
						
						// Prevent JVM from crashing
						m_conAdministrator = null;
					}
				}
				// Success
				blnResult = true;
			}
			catch( Exception excError )
			{
				// Display Error Message
				System.out.println( excError );
			}
			
			return blnResult;
		}

}