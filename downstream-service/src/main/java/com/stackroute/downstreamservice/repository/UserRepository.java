package com.stackroute.downstreamservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.downstreamservice.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
