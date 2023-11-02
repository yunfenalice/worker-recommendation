package com.beady.elastic.repo;

import com.beady.elastic.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepo extends ElasticsearchRepository<User,String> {
}
