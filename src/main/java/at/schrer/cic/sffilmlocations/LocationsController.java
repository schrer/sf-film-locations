package at.schrer.cic.sffilmlocations;

import at.schrer.cic.sffilmlocations.entity.FilmLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.io.UnsupportedEncodingException;

/**
 * Used to answer any calls on the API, specifically "/api/v1/locations", the only endpoint.
 */
@RestController
public class LocationsController {

    private static final String API_V1="/api/v1/";

    private LocationsRepository repo;


    @Autowired
    public LocationsController(LocationsRepository repo)
    {
        this.repo = repo;
    }


    /**
     * Reacts to any calls "/api/v1/locations". Supports optional parameters "title" and "locations", which will be used to filter the result for specific film/location.
     * @param title title of the film to filter for.
     * @param locations name of the location to filter for.
     * @return all locations (for the specific filter if at least one of title/location is given)
     */
    @GetMapping(API_V1+"locations")
    public FilmLocation[] getLocations(@RequestParam(value = "title", defaultValue = "") String title,
                                     @RequestParam(value = "locations", defaultValue = "") String locations)
    {
        try {
            return repo.getFilteredFilmLocations(title, locations);
        } catch (UnsupportedEncodingException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
