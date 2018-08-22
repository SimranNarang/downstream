package com.stackroute.downstreamservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.downstreamservice.model.Experience;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience,String> {

}
