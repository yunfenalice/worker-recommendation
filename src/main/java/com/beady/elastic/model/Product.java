package com.beady.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products")
public class Product {
    private String id;
    private String name;
    private Double price;
}
