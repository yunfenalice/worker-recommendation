package com.beady.elastic.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private Address address;
    private Company company;
    @Data
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private GeoLocation geo;

        // Constructors, getters, and setters
    }
    @Data
    public static class GeoLocation {
        private double lat;
        private double lng;


    }
@Data
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        // Constructors, getters, and setters
    }


}