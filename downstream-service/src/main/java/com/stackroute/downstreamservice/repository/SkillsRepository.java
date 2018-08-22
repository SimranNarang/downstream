package com.stackroute.downstreamservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.downstreamservice.model.Skills;

@Repository
public interface SkillsRepository extends CrudRepository<Skills, String> {

}
