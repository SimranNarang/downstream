package com.stackroute.downstreamservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.downstreamservice.model.PersonalInfo;

@Repository
public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, String>{

}
