package net.restassured.demo.google.place.details;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
public class Place {

    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private String website;
    private String language;
    private Location location;
    private List<String> types;

    public static Place createPlaceDetails(Map<String, String> entry) {
        Place place = new Place();
        place.setAccuracy(Integer.parseInt(entry.get("accuracy")));
        place.setName(entry.get("name"));
        place.setPhone_number(entry.get("phoneNumber"));
        place.setAddress(entry.get("address"));
        place.setWebsite(entry.get("website"));
        place.setLanguage(entry.get("language"));
        Location location = new Location();
        location.setLat(Double.parseDouble(entry.get("latitude")));
        location.setLng(Double.parseDouble(entry.get("longitude")));
        place.setLocation(location);
        place.setTypes(Arrays.asList(entry.get("types").split("_").clone()));
        return place;
    }

}