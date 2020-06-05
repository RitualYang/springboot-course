package com.wty.repository;


import com.wty.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author wty
 * @create 2019-12-24 12:08
 */
public interface UserRepository extends ElasticsearchRepository<User,Long> {
}
