package com.stackroute.downstreamservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.downstreamservice.model.AcademicQualification;

@Repository
public interface AcademiesRepository extends CrudRepository<AcademicQualification,String> {

}
