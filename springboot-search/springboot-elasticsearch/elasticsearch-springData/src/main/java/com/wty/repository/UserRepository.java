package com.wty.repository;

import com.wty.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author wty
 * @date 2019/12/24 12:08
 */
public interface UserRepository extends ElasticsearchRepository<User, Long> {
    List<User> findUsersByUsername(String username);

    List<User> queryUsersByUsernameLike(String username);
}
