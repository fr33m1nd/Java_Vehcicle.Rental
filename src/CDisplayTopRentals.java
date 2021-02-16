/**
 * Abstract: CDisplayTopRentals - Displays the current top rentals 
 * @author Derrick Warren
 *
 */
public class CDisplayTopRentals 
{
	/**
	 * Method: DisplayTopRentals
	 * Abstract: Create an instance of each class and assign to the aclsRentals array
	 */
	public static void DisplayTopRentals ( )
	{
		// Heading 
		System.out.println("\n############## Top Rentals ##############");
		
		// array using CVehicle Class and allocating size of 3
		CVehicle aclsRentals[ ] = new CVehicle [ 3 ];
		
		// local variables
		int intIndex = 0;
		String strCar = "Car";
		String strMotorbike = "Motorbike";
		String strTrailer = "Trailer";
		
		// Populate parking lot - showing polymorphism
		CCar clsCar = new CCar( );
		clsCar.SetVehicleType(strCar);
		clsCar.SetMakeAndModel("2020 Genesis G90");
		clsCar.SetMPG(20);
		clsCar.SetWheels(4);  
		
		CTrailer clsTrailer = new CTrailer( );
		clsTrailer.SetVehicleType(strTrailer);
		clsTrailer.SetMakeAndModel("Thompson Heavy Duty");
		clsTrailer.SetMPG(0);
		clsTrailer.SetWheels(6);
		
		CMotorBike clsMotorbike = new CMotorBike( );
		clsMotorbike.SetVehicleType(strMotorbike);
		clsMotorbike.SetMakeAndModel("2018 Ducati Panigale V4 R");
		clsMotorbike.SetMPG(40);
		clsMotorbike.SetWheels(2);
		
		aclsRentals [ 0 ] = ( CVehicle ) clsCar;
		aclsRentals [ 1 ] = ( CVehicle ) clsTrailer;
		aclsRentals [ 2 ] = ( CVehicle ) clsMotorbike;
				
		// Display vehicles using polymorphism
		for ( intIndex = 0; intIndex < aclsRentals.length; intIndex += 1 )
		{
			// Continue to run program if there is a null value
			if ( aclsRentals [ intIndex ] == null )
			{
				// Alert user
				System.out.println( "Undefined! No valid vehicle information to display.");
				continue;
			}
			
			// Is there a vehicle?
			if ( aclsRentals [ intIndex ] != null )
			{
				//This is polymorphism. All subclasses that derive from CVehicle have
				System.out.printf( "Vehicle Type: %s\n", aclsRentals [ intIndex ].GetVehicleType());
				System.out.printf( "Make and Model: %s\n", aclsRentals [ intIndex ].GetMakeAndModel());
				System.out.printf( "MPG: %d\n", aclsRentals [ intIndex ].GetMPG());
				System.out.printf( "Number of wheels: %d\n", aclsRentals [intIndex].GetWheels() );
				System.out.print( "How to drive vehicle: ");  
				aclsRentals [ intIndex ].GetHowToDrive();
			}
			
			System.out.println( "" );
		}
		
	}
	
}
