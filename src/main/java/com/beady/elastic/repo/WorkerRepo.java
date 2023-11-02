package com.beady.elastic.repo;

import com.beady.elastic.model.User;
import com.beady.elastic.model.Worker;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface WorkerRepo extends ElasticsearchRepository<Worker,String> {
}
