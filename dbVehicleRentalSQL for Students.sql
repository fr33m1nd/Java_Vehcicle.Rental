-- --------------------------------------------------------------------------------
-- Options
-- --------------------------------------------------------------------------------
USE dbVehicleRental;     -- Get out of the master database
SET NOCOUNT ON; -- Report only errors

-- --------------------------------------------------------------------------------
-- Drop Tables
-- --------------------------------------------------------------------------------
IF OBJECT_ID( 'TVehicleRental' )					IS NOT NULL DROP TABLE	TVehicles



-- --------------------------------------------------------------------------------
-- Step #1: Create Tables
-- --------------------------------------------------------------------------------

CREATE TABLE TLocations
(
	 intLocationID		INTEGER			NOT NULL
	,strLocationName	VARCHAR(50)		NOT NULL
	,strAddress			VARCHAR(50)		NOT NULL
	,strCity			VARCHAR(50)		NOT NULL
	,strState			VARCHAR(2)		NOT NULL
	,strZip				VARCHAR(5)		NOT NULL
	,CONSTRAINT TLocations_PK PRIMARY KEY ( intLocationID )
)


-- --------------------------------------------------------------------------------
-- Step #3: Add data to TLocations
-- -------------------------------------------------------------------------------
INSERT INTO TLocations( intLocationID, strLocationName, strAddress, strCity, strState, strZip)
VALUES		(1, 'Northwest', '10 Colerain', 'Cinti', 'OH', '45241')
		,(2, 'Downtown', '2010 Vine', 'Cinti', 'OH', '45201')
		,(3, 'Loveland', '202 Main St ', 'Loveland', 'OH', '45140')
		,(4, 'Hamilton', '9010 C Street', 'Hamilton', 'OH', '45013')

-- SELECT * FROM TLocations WHERE intVehiclesID = '1'
-- delete from tlocations