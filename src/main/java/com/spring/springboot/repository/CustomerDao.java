package com.spring.springboot.repository;

import com.spring.springboot.entity.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CustomerAccount findOne(int customerId) {
        CustomerAccount customerAccount = (CustomerAccount) jdbcTemplate.queryForObject("SELECT * FROM customer_account where customer_id = ? ",
                new Object[] { customerId }, new BeanPropertyRowMapper(CustomerAccount.class));

        return customerAccount;
    }

    public List<CustomerAccount> findAll() {
        List<CustomerAccount> persons = jdbcTemplate.query("SELECT * FROM customer_account", new BeanPropertyRowMapper(CustomerAccount.class));
        return persons;
    }
}
