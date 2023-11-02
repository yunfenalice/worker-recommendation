package com.beady.elastic.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.beady.elastic.model.Product;
import com.beady.elastic.model.User;
import com.beady.elastic.service.OperationService;
import com.beady.elastic.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class CreateIndex {
    private static final Logger logger = LoggerFactory.getLogger(CreateIndex.class);

    @Autowired
    ElasticsearchClient esClient;
    @Autowired
    OperationService operationService;
    @GetMapping("/create/index/worker")
    public void createIndex(){
        try {
            Product product = new Product("bk-1", "City bike", 123.0);

            IndexResponse response = esClient.index(i -> i
                    .index("products")
                    .id(product.getId())
                    .document(product)
            );

           logger.info("Indexed with version " + response.version());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/create/index/User")
    public void createIndexUser(){

        try {
            User.Address address = new User.Address();
            address.setStreet("Kulas Light");
            address.setSuite("Apt. 556");
            address.setCity("Gwenborough");
            address.setZipcode("92998-3874");

            User.GeoLocation geo = new User.GeoLocation();
            geo.setLat(-37.3159);
            geo.setLng(81.1496);
            address.setGeo(geo);

// Create the Company object
            User.Company company = new User.Company();
            company.setName("Romaguera-Crona");
            company.setCatchPhrase("Multi-layered client-server neural-net");
            company.setBs("harness real-time e-markets");

// Create the User object
            User user = new User();
            user.setId("1");
            user.setName("Leanne Graham");
            user.setUsername("Bret");
            user.setEmail("Sincere@april.biz");
            user.setAddress(address);
            user.setPhone("1-770-736-8031 x56442");
            user.setWebsite("hildegard.org");
            user.setCompany(company);
            IndexResponse response = esClient.index(i -> i
                    .index("user")
                    .id(user.getId())
                    .document(user)
            );

            logger.info("Indexed with version " + response.version());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("get/product")
    public R getProduct(){
        GetResponse<Product> response = null;
        try {
            response = esClient.get(g -> g
                            .index("products")
                            .id("bk-1"),
                    Product.class
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.found()) {
            Product product = response.source();
            logger.info("Product name " + product.getName());
            return R.ok().put("data",product);

        } else {
            logger.info ("Product not found");
            return R.ok("no product");
        }
    }

    @GetMapping("/create/user/bulkInsert")
    public R createBulk(){
        // Create User 7
        User.Address address7 = new User.Address();
        address7.setStreet("Rex Trail");
        address7.setSuite("Suite 280");
        address7.setCity("Howemouth");
        address7.setZipcode("58804-1099");

        User.GeoLocation geo7 =new User.GeoLocation();
        geo7.setLat(24.8918);
        geo7.setLng(21.8984);
        address7.setGeo(geo7);

        User.Company company7 = new User.Company();
        company7.setName("Johns Group");
        company7.setCatchPhrase("Configurable multimedia task-force");
        company7.setBs("generate enterprise e-tailers");

        User user7 = new User();
        user7.setId("7");
        user7.setName("Kurtis Weissnat");
        user7.setUsername("Elwyn.Skiles");
        user7.setEmail("Telly.Hoeger@billy.biz");
        user7.setAddress(address7);
        user7.setPhone("210.067.6132");
        user7.setWebsite("elvis.io");
        user7.setCompany(company7);

// Create User 8
        User.Address address8 = new User.Address();
        address8.setStreet("Ellsworth Summit");
        address8.setSuite("Suite 729");
        address8.setCity("Aliyaview");
        address8.setZipcode("45169");

        User.GeoLocation geo8 = new User.GeoLocation();
        geo8.setLat(-14.3990);
        geo8.setLng(-120.7677);
        address8.setGeo(geo8);

        User.Company company8 = new User.Company();
        company8.setName("Abernathy Group");
        company8.setCatchPhrase("Implemented secondary concept");
        company8.setBs("e-enable extensible e-tailers");

        User user8 = new User();
        user8.setId("8");
        user8.setName("Nicholas Runolfsdottir V");
        user8.setUsername("Maxime_Nienow");
        user8.setEmail("Sherwood@rosamond.me");
        user8.setAddress(address8);
        user8.setPhone("586.493.6943 x140");
        user8.setWebsite("jacynthe.com");
        user8.setCompany(company8);

// Create User 9
        User.Address address9 = new User.Address();
        address9.setStreet("Dayna Park");
        address9.setSuite("Suite 449");
        address9.setCity("Bartholomebury");
        address9.setZipcode("76495-3109");

        User.GeoLocation geo9 = new User.GeoLocation();
        geo9.setLat(24.6463);
        geo9.setLng(-168.8889);
        address9.setGeo(geo9);

        User.Company company9 = new User.Company();
        company9.setName("Yost and Sons");
        company9.setCatchPhrase("Switchable contextually-based project");
        company9.setBs("aggregate real-time technologies");

        User user9 = new User();
        user9.setId("9");
        user9.setName("Glenna Reichert");
        user9.setUsername("Delphine");
        user9.setEmail("Chaim_McDermott@dana.io");
        user9.setAddress(address9);
        user9.setPhone("(775)976-6794 x41206");
        user9.setWebsite("conrad.com");
        user9.setCompany(company9);

// Create User 10
        User.Address address10 = new User.Address();
        address10.setStreet("Kattie Turnpike");
        address10.setSuite("Suite 198");
        address10.setCity("Lebsackbury");
        address10.setZipcode("31428-2261");

        User.GeoLocation geo10 = new User.GeoLocation();
        geo10.setLat(-38.2386);
        geo10.setLng(57.2232);
        address10.setGeo(geo10);

        User.Company company10 = new User.Company();
        company10.setName("Hoeger LLC");
        company10.setCatchPhrase("Centralized empowering task-force");
        company10.setBs("target end-to-end models");

        User user10 = new User();
        user10.setId("10");
        user10.setName("Clementina DuBuque");
        user10.setUsername("Moriah.Stanton");
        user10.setEmail("Rey.Padberg@karina.biz");
        user10.setAddress(address10);
        user10.setPhone("024-648-3804");
        user10.setWebsite("ambrose.net");
        user10.setCompany(company10);

        List<User> userlist= Arrays.asList(user7,user8,user9,user10);
        operationService.bulkInsert(userlist);
        return R.ok("insert success");
    }

}
