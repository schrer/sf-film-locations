package at.schrer.cic.sffilmlocations;

import at.schrer.cic.sffilmlocations.entity.FilmLocation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * Repository for retrieving filming location data from <a href="https://data.sfgov.org/resource/wwmu-gmzc.json">DataSF</a>.
 */
@Repository
public class LocationsRepository {

    private static final String SOURCE_URL = "https://data.sfgov.org/resource/wwmu-gmzc.json";


    /**
     * Get locations, filtered by title and location. If one of the two parameters is null or empty, then there is
     * no filtering performed for this parameter.
     * @param title the title of the film to filter for.
     * @param locations the name of the location to filter for.
     * @return an Array of {@link FilmLocation} objects, filtered with the given parameters.
     */
    public FilmLocation[] getFilteredFilmLocations(String title, String locations) throws UnsupportedEncodingException
    {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(SOURCE_URL);

        if (title != null && !title.isEmpty()) {
            title = URLEncoder.encode(title, "UTF-8");
            builder.queryParam("title", title);
        }

        if (locations != null && !locations.isEmpty()) {
            locations = URLEncoder.encode(locations, "UTF-8");
            builder.queryParam("locations", locations);
        }

        RestTemplate template = new RestTemplate();
        ResponseEntity<FilmLocation[]> filmLocations = template.getForEntity(builder.toUriString(), FilmLocation[].class);

        return filmLocations.getBody();
    }
}
