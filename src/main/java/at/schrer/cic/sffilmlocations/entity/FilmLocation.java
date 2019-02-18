package at.schrer.cic.sffilmlocations.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * Simple POJO for a filming location.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmLocation {

    @NonNull
    private String title;

    @NonNull
    private String locations;

    /**
     * Creates a new instance of FilmLocation. Added for compatibility with Jackson.
     * @param title the title of the film.
     * @param locations the location of the shoot.
     */
    @JsonCreator
    public FilmLocation(@JsonProperty("title") String title, @JsonProperty("locations") String locations){
        this.title = title;
        this.locations = locations;
    }
}
