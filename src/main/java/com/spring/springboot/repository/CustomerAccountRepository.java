package com.spring.springboot.repository;

import com.spring.springboot.entity.CustomerAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called customerAccountRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Integer> {

}