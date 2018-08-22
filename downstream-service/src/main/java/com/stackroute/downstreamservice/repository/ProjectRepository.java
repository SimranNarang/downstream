package com.stackroute.downstreamservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.downstreamservice.model.Projects;

@Repository
public interface ProjectRepository extends CrudRepository<Projects, String> {

}
