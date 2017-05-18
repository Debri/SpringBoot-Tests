package com.mysql;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Liuqi
 * Date: 2017/5/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
