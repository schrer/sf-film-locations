# San Francisco Film Locations Backend

The backend part of the IBM CIC Coding Challenge. 

## Code description

The application consists of 4 classes.

* _SfFilmLocationsApplication_: Starting point for execution, no logic.
* _LocationsController_: The controller that reacts to calls on the API.
* _LocationsRepository_: Used to fetch the [film data from DataSF](https://data.sfgov.org/resource/wwmu-gmzc.json).
* _FilmLocation_: Simple entity to hold film title and location in an object.

Code dependencies:

* _Spring Framework_: as application server, for handling all API requests.
* _Jackson_: for fetching the data from Data SF.
* _Lombok_: for the FilmLocation-class to save some code.


## API Description

The REST API can be found at `/api/v1/*`
The only endpoint is `/api/v1/locations`, with two supported parameters (both optional):

* title: title of the film
* locations: the filming location

Both these parameters can be used to filter the results to only show those, which contain the correct value in their title-/locations-fields.

## Requirements

* JDK 8
* Maven 3.6.0 or newer (Optional)

## Usage

If Maven is not installed on your machine, or you have an older version than 3.6.0 (though older version may work), use scripts `mvnw` or `mvnw.cmd` (depending on your OS) instead of the command `mvn`.

**Compiling** (with cleaning of previous builds)**:**
`mvn clean compile`

**Starting the application:**
`mvn exec:java`

The application will then be running on localhost, Port 8080. The only API endpoint is at [localhost:8080/api/v1/locations](http://localhost:8080/api/v1/locations)

**Testing:**
`mvn test`

Testing is **very** basic, due to limited time.

