package com.beady.elastic.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class ElasticClient {
    @Bean
    public ElasticsearchClient elasticsearchClient() {
        String serverUrl = "https://3b76cf40acdb4cfc9fda83a21afb2aa4.us-central1.gcp.cloud.es.io:443";
        String apiKey = "N2FGdk1Jc0JtYWs2V0U4WGY3S3Q6S2VrQTdwOGtSQTZfSkdib3M1Q0hwZw==";
        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        ElasticsearchClient esClient = new ElasticsearchClient(transport);
        return esClient;
    }



}
