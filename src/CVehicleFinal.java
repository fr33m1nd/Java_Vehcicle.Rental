/**
 * CVehicleFinal Class
 * Abstract: Main class to process functions/methods of the application 
 * @author Derrick Warren
 *
 */
public class CVehicleFinal 
{
	/**
	 * Method: Main
	 * Abstract: 1) Display pick-up locations
	 * 			 2) Display current top rentals
	 * 		     3) System Special Instructions
	 * 			 4) Get input from user
	 * 			 5) Display rental receipt
	 * @param args - no args
	 */
	public static void main( String[ ] args ) 
	{		
		// Heading - Company Rental System
		System.out.println("###################################");
		System.out.println("### D. Warren's Vehicle Rentals ###");
		System.out.println("###################################");
		
		//****************************************************************************
		// ***** Display pick up locations *******************************************
        //****************************************************************************
		try{
       			// Can we connect to the database?
    			if ( DisplayVehicleRentalLocation.OpenDatabaseConnectionSQLServer( ) == true )
    			{	
					// Yes, load the teams list
    				DisplayVehicleRentalLocation.LoadListFromDatabase( "TLocations", "intLocationID" , "strLocationName", 
    																"strAddress", "strCity", "strZip" );
    			}
    			else
    			{
    				// No, warn the user ...
    				System.out.println("Error loading the table");
    			}
    			
    		// System.out.println("Process Complete");
        	}
            catch 	(Exception e) 
			{ System.out.println("An I/O error occurred: " + e.getMessage()); }
		
		//****************************************************************************
		// ***** Display current top rentals *****************************************
        //****************************************************************************
		CDisplayTopRentals.DisplayTopRentals( );	
		
		//****************************************************************************
		// ***** System Special Instructions *****************************************
        //****************************************************************************		
		System.out.println("\n####### System Special Instructions #######");
		System.out.println( "-------------------------------------------" );
		System.out.println( "### Enter 'Quit' or 'Q' to exit program ###" );
		System.out.println( "-------------------------------------------" ); 
		System.out.println( "-------------------------------------------" );
		System.out.println( "# If additional vehicles need to be       #" );
		System.out.println( "# added for the customer; when prompted   #" );
		System.out.println( "# by the system enter:                    #" );
		System.out.println( "# 1) Pick-up Date                         #" );
		System.out.println( "# 2) Number of Rental Days                #" );
		System.out.println( "# 3) Vehicle Type                         #" );
		System.out.println( "-------------------------------------------" );
		
		
		//****************************************************************************
		// ***** Get input from user *************************************************
        //****************************************************************************	
		System.out.println("\n########## Customer Application ##########");
		
		CCustomerApplication.GetCustomerName();
		CCustomerApplication.GetPhoneNumber();
		CCustomerApplication.GetEmailAddress();
		
		System.out.println( "\nVehicle Details");
		System.out.println( "___________________________________________");
		CCustomerApplication.GetPickUpDate();
		CCustomerApplication.GetNumOfRentalDays();
		CCustomerApplication.GetNumOfVehiclesRented();
		CCustomerApplication.GetVehicleType();
		
		
				
		//****************************************************************************
		// ***** Display rental receipt **********************************************
        //****************************************************************************
		CCustomerApplication.CalculateRentalCostAllVehicles();
		
		System.out.println( "-------------------------------------------" );
		System.out.println( "********** Vehicle Rental Receipt **********" );
		System.out.println( "-------------------------------------------" );
		
		CCustomerApplication.CustomerApplicationOutput( ); 
			
	}
		
}
