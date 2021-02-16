/**
 * CMotorBike Child Class
 * @author Derrick Warren
 *
 */
public class CMotorBike extends CVehicle
{
	// Properties
	// Never make public properties.  
	// Make protected or private with public get/set methods
	
	/**
	 * Method: GetHowToDrive
	 * Abstract: defines the way the vehicle drives
	 */
	public void GetHowToDrive( )
	{
		// How many wheels vehicle has determines how to drive
		if(GetWheels() == 2)
		{
			System.out.println( "Handle Bars" );
		}
		
	}
	
		
}	
