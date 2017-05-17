package com.jpa.domain;


import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by Liuqi
 * Date: 2017/5/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
