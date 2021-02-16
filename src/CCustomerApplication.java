/**
 * CCustomerApplication Child Class
 * 
 * Abstract: This class will handle customer information:
 * a. Name
 * b. Phone Number
 * c. Email
 * 
 * It will handle rental information:
 * a. Rental Pick-up Date
 * b. Number of Rental Days
 * c. Number of Vehicles to Rent
 * d. Type of Vehicle to Rent

 * It will calculate:
 * a. Total Rental for vehicle based on Price * Number of Days (must display 2 decimal places)
 * b. Total Rental Amount for all vehicles (must display 2 decimal places)
 *
 * @author Derrick Warren
 *
 */
public class CCustomerApplication extends CScanner
{
	// Properties
	// Never make public properties.  
	// Make protected or private with public get/set methods
	
	// variables (constant) to set regex patterns for phone number, email address, and pick-up date
	private static final String m_strVALID_PHONE_NUMBER = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
	private static final String m_strVALID_EMAIL_ADDRESS = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static final String m_strVALID_PICKUP_DATE = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	// variables for customer
	private static String m_strName = "";
	private static String m_strPhoneNumber = "";
	private static String m_strEmailAddress = "";
	
	// variables for rental vehicle input and calculations
	private static String m_strPickUpDate = "";
	private static int m_intNumOfRentalDays = 0;
	private static int m_intNumOfVehiclesRented = 0;
	private static String m_strVehicleType = ""; 
	private static int m_intVehicleTypePrice = 0;
	private static float m_sngRentalCostPerVehicle = 0.0f;
	private static float m_sngFinalCost = 0.0f;
	
	
	// arrays to hold costs from multiple vehicle rentals from same customer
	private static float[] m_sngVehiclesCostArray = new float[3];
	private static String[] m_strVehicleTypeArray = new String[3];
	private static String[] m_strPickUpDateArray = new String[3];
	
	/**
	 * Method: QuitProgram
	 * Abstract: User can quit program by typing 'Quit' or 'Q'
	 */
	public static void QuitProgram( ) 
	{
		 // Stop the program if the user types 'q' or 'quit'
        if( m_strName.toUpperCase().equals("QUIT") || m_strName.toUpperCase().equals("Q") )
        {  
        	System.out.println( "Program Ended." );
        	System.out.println( "Thanks for using this program!\n" );
        	System.exit(0);
        }
        if( m_strPhoneNumber.toUpperCase().equals("QUIT") || m_strPhoneNumber.toUpperCase().equals("Q") )
        {  
        	System.out.println( "Program Ended." );
        	System.out.println( "Thanks for using this program!\n" );
        	System.exit(0);
        }
        if( m_strEmailAddress.toUpperCase().equals("QUIT") || m_strEmailAddress.toUpperCase().equals("Q") )
        {  
        	System.out.println( "Program Ended." );
        	System.out.println( "Thanks for using this program!\n" );
        	System.exit(0);
        }
        if( m_strPickUpDate.toUpperCase().equals("QUIT") || m_strPickUpDate.toUpperCase().equals("Q") )
        {  
        	System.out.println( "Program Ended." );
        	System.out.println( "Thanks for using this program!\n" );
        	System.exit(0);
        }
        if( m_strVehicleType.toUpperCase().equals("QUIT") || m_strVehicleType.toUpperCase().equals("Q") )
        {  
        	System.out.println( "Program Ended." );
        	System.out.println( "Thanks for using this program!\n" );
        	System.exit(0);
        }
		
	}
	
	
	/**
	 * Method: GetCustomerName
	 * Abstract: Get customer name from user
	 * @return getM_strName Customer Name 
	 */
	public static String GetCustomerName( ) 
	{	
		// get name of customer from user
		do 
		{
			System.out.print( "Enter Customer Name: " );
			m_strName = ReadStringFromUser();
			
			// validate customer name
			ValidateCustomerName( m_strName );
		
		} while ( m_strName.length() == 0 );
		
		// Stop the program if the user types 'q' or 'quit'
		QuitProgram( );
			
		return m_strName;
	}

	
	/**
	 * Method: ValidateCustomerName
	 * Abstract: If customer name is an empty string alert user
	 * @param m_strName Customer Name
	 */
	public static void ValidateCustomerName( String m_strName  ) 
	{
		
		if ( m_strName.length() == 0 )
		{
			System.out.println( "Error! Please enter customer name.\n" );
		}
	}
 

	/**
	 * Method: GetPhoneNumber
	 * Abstract: Get customer phone number from user
	 * @return getM_strPhoneNumber Customer Phone Number 
	 */
	public static String GetPhoneNumber( ) 
	{	
		// get phone number of customer from user
		do 
		{
			System.out.print( "Enter Customer Phone Number: " );
			m_strPhoneNumber = ReadStringFromUser();
			
			// Stop the program if the user types 'q' or 'quit'
			QuitProgram( );
			
			// validate customer phone number 
			if (IsValidPhoneNumber( m_strPhoneNumber ) == false)
			{
				System.out.println( "Error! Please enter valid customer phone number.\n" );
			}
		
		} while ( IsValidPhoneNumber( m_strPhoneNumber ) == false );
		
		return m_strPhoneNumber;
	}
	
	
	/**
	 * Method: IsValidPhoneNumber
	 * Abstract: Validate customer phone number
	 * @param m_strPhoneNumber Customer Phone Number
	 * @return true
	 */
	public static boolean IsValidPhoneNumber( String m_strPhoneNumber ) 
	{	
		// make sure user input is not empty and is validated by regex format
		if (m_strPhoneNumber.length() == 0  
			|| m_strPhoneNumber.matches(m_strVALID_PHONE_NUMBER) == false )
		{
			return false;
		}
		else
		{
			return true;
		}
					
	}
	
	
	/**
	 * Method: GetEmailAddress
	 * Abstract: Get Email Address from user
	 * @return getM_strEmailAddress Customer Email Address 
	 */
	public static String GetEmailAddress( ) 
	{	
		// get email address of customer from user
		do 
		{
			System.out.print( "Enter Email Address: " );
			m_strEmailAddress = ReadStringFromUser();
			
			// Stop the program if the user types 'q' or 'quit'
			QuitProgram( );
			
			// validate employee name
			if ( IsValidEmailAddress( m_strEmailAddress ) == false )
			{
				System.out.println( "Error! Please enter valid customer email address.\n" );
			}
		
		} while ( IsValidEmailAddress( m_strEmailAddress ) == false );
		
		return m_strEmailAddress;
	}


	/**
	 * Method: IsValidEmailAddress
	 * Abstract: Validate customer Email Address
	 * @param m_strEmailAddress Customer Email Address
	 * @return true
	 */
	public static boolean IsValidEmailAddress( String m_strEmailAddress ) 
	{
		// make sure user input is not empty and is validated by regex format
		if ( m_strEmailAddress.length() == 0
			|| m_strEmailAddress.matches( m_strVALID_EMAIL_ADDRESS ) == false )
		{ 
			return false;
		}		
		else
		{
			return true;
		}
	}
	
	
	/**
	 * Method: GetPickUpDate
	 * Abstract: Get pick up date for rental
	 * @return getM_strPickUpDate Pick up date of rental
	 */
	public static String GetPickUpDate() 
	{	
		do 
		{		
			System.out.print( "Enter Pick-up Date: " );
			m_strPickUpDate = ReadStringFromUser();

		// loop until valid input is entered
		} while ( ValidatePickUpDate( ) == false );
		
		// User has option to quit program
		QuitProgram();
		
		return m_strPickUpDate;
	}

	
	/**
	 * Method: ValidatePickUpDate
	 * Abstract: Make sure date entered is valid and not empty
	 * @return true 
	 */
	public static boolean ValidatePickUpDate( ) 
	{
		// make sure user input is not empty and is validated by regex format
		if (m_strPickUpDate.length() == 0  
			|| m_strPickUpDate.matches(m_strVALID_PICKUP_DATE) == false )
		{
			System.out.println( "Error! Please enter valid date(e.g. mm/dd/yyyy).\n" ); // alert user
			return false;
		}
		else
		{
			return true;
		}

	}


	/**
	 * Method: GetNumOfRentalDays
	 * Abstract: Get number of days vehicle was rented 
	 * @return getM_intNumOfRentalDays Number of Rental Days
	 */
	public static int GetNumOfRentalDays() 
	{	
		do 
		{		
			System.out.print( "Enter Number of Rental Days: " );
			m_intNumOfRentalDays = ReadIntegerFromUser();

		// loop until valid input is entered
		} while ( ValidateNumOfRentalDays( ) == false );
		
		return m_intNumOfRentalDays;
	}
	
	
	/**
	 * Method: ValidateNumOfRentalDays
	 * Abstract: If number of rental days is empty, 
	 * 			 equal to 0, or less than 0 alert user
	 * @return true 
	 */
	public static boolean ValidateNumOfRentalDays( ) 
	{
		// string variable that will be used for data type conversion
		String strNewNumOfRentalDays = "";
				
		// converted Number of rental days variable to a string for comparison purposes
		strNewNumOfRentalDays = Integer.toString( m_intNumOfRentalDays );
		
		// see if Number of rental days is empty, equal to 0, or negative
		if ( strNewNumOfRentalDays.length() == 0 || m_intNumOfRentalDays <= 0 )
		{
			System.out.println( "Error! Please enter valid number of rental days.\n" ); // alert user
			return false;
		}
					
		return true;
		
	}
	
	
	/**
	 * Method: GetNumOfVehiclesRented
	 * Abstract: Get number of vehicles being rented 
	 * @return getM_intNumOfVehiclesRented Number of Vehicles Rented
	 */
	public static int GetNumOfVehiclesRented() 
	{	
		do 
		{
			System.out.print( "Enter Number of Vehicles Being Rented: " );
			m_intNumOfVehiclesRented = ReadIntegerFromUser();
		
		} while ( IsValidVehicleNumber( ) == false );
		
		return m_intNumOfVehiclesRented;
	}
	
	
	/**
	 * Method: IsValidVehicleNumber
	 * Abstract: If number of vehicles being rented is empty 
	 * 			 or if number of vehicles being rented is not between 1 - 3
	 * 			 then alert user
	 * @return true
	 */
	public static boolean IsValidVehicleNumber( ) 
	{
		// string variable that will be used for data type conversion
		String strNumOfVehiclesRented = "";
				
		// converted Number of rental days variable to a string for comparison purposes
		strNumOfVehiclesRented = Integer.toString( m_intNumOfVehiclesRented );
		
		// see if Number of vehicles rented is empty, equal to 0, negative, or greater than 3 
		if ( strNumOfVehiclesRented.length() == 0 || m_intNumOfVehiclesRented <= 0 
				|| m_intNumOfVehiclesRented > 3 )
		{
			System.out.println( "Error! Please enter valid number of vehicles to rent (1-3).\n" ); // alert user
			return false;
		}
					
		return true;
	}
	
	
	/**
	 * Method: CalculateRentalCostAllVehicles
	 * Abstract: If number of vehicles being rented is more than 1 
	 * 			 loop through program to get other vehicle data
	 * 			 then display rental costs depending on input
	 * @return m_sngFinalCost - total cost for rentals
	 */
	public static float CalculateRentalCostAllVehicles( ) 
	{
		// local variables 
		int intIndex = 0;
		
		// see if Number of vehicles rented is more than 1: (2 or 3) 
		if ( m_intNumOfVehiclesRented == 2 || m_intNumOfVehiclesRented == 3 )
		{
			// yes, then loop through to get additional input and calculations
			for (intIndex = 1; intIndex < m_intNumOfVehiclesRented; intIndex += 1)
			{				
				// Heading
				System.out.println( "\nAdditional Vehicle Details");
				System.out.println( "___________________________________________");
				
				// Method will get cost per rental
				CalculateRentalCostPerVehicle( );
				
				// Store cost per vehicle in array and add each cost of vehicle rented
				m_sngVehiclesCostArray[intIndex - 1] += m_sngRentalCostPerVehicle;
						
				// Store type of vehicle in array to access later 
				m_strVehicleTypeArray[intIndex - 1] = m_strVehicleType;
				
				// Store pick up date in array to access later
				m_strPickUpDateArray[intIndex -1] = m_strPickUpDate;
				
				// Get necessary user input
				GetPickUpDate();
				GetNumOfRentalDays();
				GetVehicleType();
			}	
			
			// This method and equation will add in the last cost per vehicle to get the total
			CalculateRentalCostPerVehicle( );
			m_sngVehiclesCostArray[intIndex - 1] += m_sngRentalCostPerVehicle;
			
			// Store the last type of vehicle rented in array to access later 
			m_strVehicleTypeArray[intIndex - 1] = m_strVehicleType;
			
			// Store pick up date in array to access later
			m_strPickUpDateArray[intIndex -1] = m_strPickUpDate;
			
			// Assign the final cost to a variable from adding the cost in each array element 
			m_sngFinalCost = m_sngVehiclesCostArray[0] + m_sngVehiclesCostArray[1] + m_sngVehiclesCostArray[2];				
		}
		else
		{
			// If only one vehicle rented then calculate and display rental information for that vehicle		
			CalculateRentalCostPerVehicle( );
			
			// Store cost per vehicle in array and add each cost of vehicle rented
			m_sngVehiclesCostArray[ intIndex ] += m_sngRentalCostPerVehicle;
			
			// Store type of vehicle in array to access later 
			m_strVehicleTypeArray[ intIndex ] = m_strVehicleType;
			
			// Store pick up date in array to access later
			m_strPickUpDateArray[ intIndex ] = m_strPickUpDate;
			
			// Assign the final cost to a variable from first array element
			m_sngFinalCost = m_sngVehiclesCostArray[0];
		}
		
		return m_sngFinalCost;		
	}
		
		
	/**
	 * Method: GetVehicleType
	 * Abstract: Get type of vehicle being rented
	 * @return m_strVehicleType Type of Vehicle Rented
	 */
	public static String GetVehicleType() 
	{	
		// variables used to compare vehicle type to get vehicle price
		String strCar = "Car";
		String strMotorbike = "Motorbike";
		String strTrailer = "Trailer";
		char chrUserInput = ' ';
		
		do 
		{
			//System.out.println( "A = Car" );
			//System.out.println( "B = Motorbike" );
			//System.out.println( "C = Trailer" );
			System.out.print( "Select Vehicle Type( A = Car, B = Motorbike, C = Trailer ): " );
			chrUserInput = ReadCharacterFromUser();
			System.out.println( "" );
			
			
			if (chrUserInput == 'A' || chrUserInput == 'a')
			{
				m_strVehicleType = strCar;
			}
			else if (chrUserInput == 'B' || chrUserInput == 'b')
			{
				m_strVehicleType = strMotorbike;
			}
			else if (chrUserInput == 'C' || chrUserInput == 'c')
			{
				m_strVehicleType = strTrailer;
			}
			else
			{
				
				System.out.println( "Error! Please enter valid character for vehicle type (A.car, B.motorbike, C.trailer).\n" ); // alert user
			}
			
			// Stop the program if the user types 'q' or 'quit'
			QuitProgram( );
			
		} while ( IsValidVehicleType( chrUserInput ) == false );
		
		GetVehicleTypePrice( chrUserInput );
				
		return m_strVehicleType;
	}
	
	
	/**
	 * Method: GetVehicleTypePrice
	 * Abstract: Get type of vehicle being rented
	 * @param chrUserInput - user input for vehicle type
	 * @return m_intVehicleTypePrice Price of Vehicle Rented
	 */
	public static int GetVehicleTypePrice( char chrUserInput ) 
	{			
		// check to see which vehicle type to get the vehicle price 
		if (chrUserInput == 'A' || chrUserInput == 'a')
		{
			m_intVehicleTypePrice = 50;
		}
		else if (chrUserInput == 'B' || chrUserInput == 'b')
		{
			m_intVehicleTypePrice = 25;
		}
		else if (chrUserInput == 'C' || chrUserInput == 'c')
		{
			m_intVehicleTypePrice = 35;
		}
		
		return m_intVehicleTypePrice;
	}
	
	
	/**
	 * Method: IsValidVehicleType
	 * Abstract: If vehicle type being rented is empty  
	 * 			 or if type of vehicle being rented is not a match
	 * 			 then alert user
	 * @param chrUserInput - user input for vehicle type
	 * @return true
	 */
	public static boolean IsValidVehicleType( char chrUserInput ) 
	{		
		// see if vehicle type is empty
		if ( chrUserInput == 0 )
		{
			return false;
		}
		
		// check to see which vehicle type to see if it's valid 
		if (chrUserInput == 'A' || chrUserInput == 'a')
		{
			return true;
		}
		else if (chrUserInput == 'B' || chrUserInput == 'b')
		{
			return true;
		}
		else if (chrUserInput == 'C' || chrUserInput == 'c')
		{
			return true;
		}
		else
		{
			return false;
		}
						
	}
	
	
	/**
	 * Method: CalculateRentalCostPerVehicle
	 * Abstract: Calculate rental cost per vehicle: (m_intVehicleTypePrice * m_intNumOfRentalDays)
	 * @return m_sngRentalCostPerVehicle Rental Cost Per Vehicle
	 */
	public static float CalculateRentalCostPerVehicle( ) 
	{	
		// calculate the total rental cost per vehicle 
		m_sngRentalCostPerVehicle = (float) m_intVehicleTypePrice * (float) m_intNumOfRentalDays;
				
		return m_sngRentalCostPerVehicle;
	}
	
	
	/**
	 * Method: CustomerApplicationOutput
	 * Abstract: Display desired output, based on user input for application
	 */
	public static void CustomerApplicationOutput( ) 
	{	
		int intIndex = 0;
		
		System.out.println( "Customer Name: " + m_strName );
				
		System.out.println( "Phone Number: " + m_strPhoneNumber );
		
		System.out.println( "Email Address: " + m_strEmailAddress );
		
		System.out.println( "");
		
		// loop through to display all vehicles rented and price per vehicle
		for (intIndex = 0; intIndex < m_intNumOfVehiclesRented; intIndex += 1)
		{							
			System.out.printf( "Vehicle Type: %-12s Cost: $%-14.2f Pick-up Date: %-14s\n", 
															   m_strVehicleTypeArray[intIndex],
															   m_sngVehiclesCostArray[intIndex],
															   m_strPickUpDateArray[intIndex]);
		
		}
		
		System.out.printf( "\nTotal Cost For All Rentals: $%.2f", m_sngFinalCost );
		
	}
	
}











































