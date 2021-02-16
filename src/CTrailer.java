/**
 * CTrailer Child Class
 * @author Derrick Warren
 *
 */
public class CTrailer extends CVehicle
{
	// Properties
	// Never make public properties.  
	// Make protected or private with public get/set methods

	private static final int m_intTRAILER_MPG = 0;
	
	
	/**
	 * Method: GetHowToDrive
	 * Abstract: defines the way the vehicle drives
	 */
	public void GetHowToDrive( )
	{
		// How many wheels vehicle has determines how to drive
		if(GetWheels() == 6)
		{
			System.out.println( "Use another vehicle to pull" );
		}
		
	}

	
	/**
	 * Method: SetTrailerMPG
	 * Abstract: 0 MPG for trailers
	 */
	public void SetTrailerMPG( )
	{
		// Set MPG for trailer
		m_intNumOfMPG =  m_intTRAILER_MPG;
	}
	
	
	/**
	 * Method: GetTrailerMPG
	 * Abstract: 0 MPG for trailers
	 * @return GetMPG() - method that defines MPG for rental
	 */
	public int GetTrailerMPG( )
	{
		// Uses set method to get number of MPG for rental 
		SetTrailerMPG( );
		
		return GetTrailerMPG();
		
	}
		
}	











