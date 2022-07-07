package Locators;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.junit.experimental.categories.Categories;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"placeName", "longitude", "state", "stateAbbreviation", "latitude"})
public class Pet {

    private String id;
    private String name;
    private List<category>  categories;
    private List<photoUrl> photoUrls;
    private List<tag> tags;
    private String status;
    public Pet() {

        this.id = "1050";
        this.name = "Latvia";

        Categories categories = new Categories();
        List<category> categoryList = new ArrayList<>();
        places.add(place);
        this.categories = "LV";

        Place place = new Place();
        List<Place> places = new ArrayList<>();
        places.add(place);

        this.places = places;
    }

    @JsonProperty("post code")
    public String getPostCode() {
        return postCode;
    }

    @JsonProperty("post code")
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country abbreviation")
    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    @JsonProperty("country abbreviation")
    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
