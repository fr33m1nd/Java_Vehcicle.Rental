/**
 * CVehicle Parent Class
 * @author Derrick Warren
 *
 */
public class CVehicle 
{
	// Properties
	// Never make public properties.  
	// Make protected or private with public get/set methods

	protected int m_intWheels = 0;
	protected int m_intNumOfMPG = 0;
	protected String m_strHowToDrive = "";		
	
	protected String m_strMakeAndModel = "";
	protected String m_strVehcileType = "";
	
	
	/**
	 * Method: SetName
	 * Abstract: set make and model of vehicle
	 * @param strNewMakeAndModel - assigned make and model
	 */
	public void SetMakeAndModel( String strNewMakeAndModel )
	{
		int intLength = 0;
		
		intLength = strNewMakeAndModel.length( );
		
		//Too Long?
		if ( intLength > 50 )
		{
			//if longer, clip to 50 characters
			intLength = 50;
		}
		
		m_strMakeAndModel = strNewMakeAndModel.substring ( 0, intLength );
	}
	
	
	/**
	 * Method: GetMakeAndModel
	 * Abstract: get make and model of rental
	 * @return m_strName
	 */
	public String GetMakeAndModel( )
	{
		return m_strMakeAndModel;
	}
	
	
	/**
	 * Method: SetVehicleType
	 * Abstract: set type of vehicle
	 * @param strNewVehicleType - assign vehicle type 
	 */
	public void SetVehicleType ( String strNewVehicleType )
	{
		String strCar = "Car";
		String strMotorbike = "Motorbike";
		String strTrailer = "Trailer";
		
		// Check if vehicle type is valid
		if ( strNewVehicleType == strCar ) 
		{
			// assign vehicle type
			m_strVehcileType = strNewVehicleType;
		}
		else if ( strNewVehicleType == strMotorbike ) 
		{
			m_strVehcileType = strNewVehicleType;
		}
		else if ( strNewVehicleType == strTrailer ) 
		{
			m_strVehcileType = strNewVehicleType;
		}
		else
		{
			strNewVehicleType = "Undefined! Enter Valid Vehicle Type(\"Car\", \"Motorbike\", \"Trailer\").";
			System.out.println(strNewVehicleType);
		}

	}
	
	
	/**
	 * Method: GetVehicleType
	 * Abstract: get type of vehicle
	 * @return m_strVehcileType 
	 */
	public String GetVehicleType( )
	{
		return m_strVehcileType;
	}
	
	
	/**
	 * Method: SetHowToDrive
	 * Abstract: set how to drive vehicle/motorbike/trailer
	 * 			 depending on number of wheels rental has.
	 * @param strNewHowToDrive - assigns way customer should drive rental
	 */
	/*public void SetHowToDrive( String strNewHowToDrive )
	{
		// Depending on number of wheels, set how rental drives
		if ( m_intWheels == 2 ) 
		{
			strNewHowToDrive = "Handle bars";
		}
		else if ( m_intWheels == 4 )
		{
			strNewHowToDrive = "Steering Wheel";
		}
		else if ( m_intWheels == 6 )
		{
			strNewHowToDrive = "Use another vehicle to pull";
		}
		else
		{
			// Alert user that how to drive  is not valid
			strNewHowToDrive = "Undefined! Enter Valid Vehicle and/or Valid Wheel Count.";
			System.out.println(strNewHowToDrive);
		}
		
		m_strHowToDrive = strNewHowToDrive;
	}*/
	
	
	/**
	 * Method: GetHowToDrive
	 * Abstract: defines how to drive for vehicle
	 */
	public void GetHowToDrive ( )
	{
		System.out.println( "Undefined" );
	}
	
	
	/**
	 * Method: SetMPG
	 * Abstract: set MPG (miles per gallon) for vehicle
	 * 			 Default MPG = 0
	 * @param intNewNumOfMPG set MPG for vehicle
	 */
	public void SetMPG( int intNewNumOfMPG )
	{
		// local variables
		String strCar = "Car";
		String strMotorbike = "Motorbike";
		String strTrailer = "Trailer";
		String strNewNumOfMPG = "";
		
		// converted new number of MPG variable to a string for comparison purposes
		strNewNumOfMPG = Integer.toString(intNewNumOfMPG);
		
		// See what type of vehicle that rental is
		if ( m_strVehcileType == strCar ) 
		{
			// Set valid range of MPG for vehicle
			if (intNewNumOfMPG >= 1 || intNewNumOfMPG <= 60 )
			{
				m_intNumOfMPG = intNewNumOfMPG;
			}
		}
		else if ( m_strVehcileType == strMotorbike ) 
		{
			// Set valid range of MPG for vehicle
			if (intNewNumOfMPG >= 1 || intNewNumOfMPG <= 100 )
			{
				m_intNumOfMPG = intNewNumOfMPG;
			}
		}
		else if ( m_strVehcileType == strTrailer ) 
		{
			// 0 MPG for trailer
			m_intNumOfMPG = 0;
		}
		else
		{
			// Alert user 
			strNewNumOfMPG = "Undefined! Enter Valid Vehicle and/or Valid MPG. ";
			System.out.println(strNewNumOfMPG);
		}
				
	}
	
	
	/**
	 * Method: GetMPG
	 * Abstract: get MPG (miles per gallon) of vehicle
	 * @return m_intNumOfMPG
	 */
	public int GetMPG( )
	{
		return m_intNumOfMPG;
	}

	
	/**
	 * Method: SetWheels
	 * Abstract: set number of wheels for vehicle 
	 * 			 Valid wheel count: 2, 4, or 6
	 * 			 Default wheel count = 0
	 * @param intNewWheels set number of wheels for vehicle
	 */
	public void SetWheels ( int intNewWheels )
	{
		// local variables
		String strCar = "Car";
		String strMotorbike = "Motorbike";
		String strTrailer = "Trailer";
		
		// string variable that will be used for data type conversion
		String strNewWheels = "";
		
		// converted new wheel variable to a string for comparison purposes
		strNewWheels = Integer.toString(intNewWheels);
						
		// See what type of vehicle that rental is
		if ( m_strVehcileType == strCar ) 
		{
			// assign valid wheel count for vehicle
			intNewWheels = 4;
		}
		else if ( m_strVehcileType == strMotorbike ) 
		{
			intNewWheels = 2;
		}
		else if ( m_strVehcileType == strTrailer ) 
		{
			intNewWheels = 6;
		}
		else
		{
			// Alert user
			strNewWheels = "Undefined! Enter Valid Vehicle and/or Valid Wheel Count.";
			System.out.println(strNewWheels);
		}
		
		m_intWheels = intNewWheels;
	}
	
	
	/**
	 * Method: GetWheels
	 * Abstract: get wheel count of vehicle
	 * @return m_intWheels
	 */
	public int GetWheels( )
	{
		
		return m_intWheels;
	}
	
}
