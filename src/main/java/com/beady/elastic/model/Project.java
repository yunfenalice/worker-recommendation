package com.beady.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "project")
public class Project {
    @Id
    private String id;
    private String name;
    private String supervisor;
    private String projectName;
    private String requirements;
    private Date startDate;
    private Date endDate;
    private Worker assignWorker;
    private Address address;
    private Double site_rating;
    private Company company;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private GeoLocation geo;

        // Constructors, getters, and setters
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GeoLocation {
        private double lat;
        private double lng;


    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Company {
        private String name;
    }
}
