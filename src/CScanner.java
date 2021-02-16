import java.io.*;
/**
 * CScanner Parent Class 
 * Abstract: This class will be used to read in user input 
 * @author Derrick Warren
 *
 */
public class CScanner 
{
	// Properties
	// Never make public properties.  
	// Make protected or private with public get/set methods

	private static String m_strBuffer = "";
	private static int m_intValue = 0;
	private static char m_chrCharacterInput = ' ';
	
	
	/**
	 * Method: ReadStringFromUser
	 * Abstract: Read a string from the user
	 * @return m_strBuffer
	 */
	public static String ReadStringFromUser( )
	{			  		
		try
		{
			
			// Input stream
			BufferedReader burInput = new BufferedReader( new InputStreamReader( System.in ) ) ;
	
			// Read a line from the user
			m_strBuffer = burInput.readLine( );
	
		}
		catch( NullPointerException | IOException e ) // make sure user input is not null
		{
			System.out.println( "Error! Please enter valid input." ); // System.out.println( Error Message )
		}
		
		// Return string value
		return m_strBuffer;
	}
	
	
	/**
	 * Method: ReadIntegerFromUser
	 * Abstract: Read an integer from the user
	 * @return m_intValue
	 */
	public static int ReadIntegerFromUser( )
	{			  	
		try
		{
			String strBuffer = "";	
	
			// Input stream
			BufferedReader burInput = new BufferedReader( new InputStreamReader( System.in ) ) ;
	
			// Read a line from the user
			strBuffer = burInput.readLine( );
			
			// Convert from string to integer
			m_intValue = Integer.parseInt( strBuffer );
		}
		catch ( NumberFormatException | IOException e )	// catch( Number Format Exception )
		{
			// System.out.println( "Error! Please enter a valid number for input." );	// System.out.println( Error Message )
		}
		catch( NullPointerException e) // make sure user input is not null
		{
			// System.out.println( "Error! Please enter a valid number for input." ); // System.out.println( Error Message )
		}
		
		// Return integer value
		return m_intValue;
	}
	
	
	/**
	 * Method: ReadCharacterFromUser
	 * Abstract: Read a character from the user
	 * @return m_chrCharacterInput
	 */
		public static char ReadCharacterFromUser( )
		{			  			
			try
			{
				
				// Input stream
				BufferedReader burInput = new BufferedReader( new InputStreamReader( System.in ) ) ;

				// Read a line from the user
				m_chrCharacterInput = (char)burInput.read( );
			}
			catch( Exception excError )
			{
				System.out.println( excError.toString( ) );
			}
			
			// Return character value
			return m_chrCharacterInput;
		}
}
