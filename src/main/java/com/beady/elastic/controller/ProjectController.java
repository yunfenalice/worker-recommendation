package com.beady.elastic.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.beady.elastic.service.ProjectService;
import com.beady.elastic.service.WorkerService;
import com.beady.elastic.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ElasticsearchClient esClient;
    @Autowired
    WorkerService workerService;
    @Autowired
    ProjectService projectService;

    @GetMapping("/create/project/bulkInsert")
    public R createBulk(){
        projectService.saveBulkProject();
        return R.ok("insert success");
    }

    @GetMapping("/find/workers")
    public R findWorkerForProject(String projectId){
        projectService.findWorker(projectId);
        return null;

    }

}
