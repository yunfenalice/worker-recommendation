package com.beady.elastic.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.beady.elastic.model.Product;
import com.beady.elastic.model.User;
import com.beady.elastic.service.OperationService;
import com.beady.elastic.service.WorkerService;
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
public class WorkerController {
    private static final Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    ElasticsearchClient esClient;
    @Autowired
    WorkerService workerService;

    @GetMapping("/create/worker/bulkInsert")
    public R createBulk(){
         workerService.saveBulkWorker();
        return R.ok("insert success");
    }

}
