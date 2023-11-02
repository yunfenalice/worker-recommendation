package com.beady.elastic.repo;

import com.beady.elastic.model.Project;
import com.beady.elastic.model.Worker;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProjectRepo extends ElasticsearchRepository<Project,String> {
}
