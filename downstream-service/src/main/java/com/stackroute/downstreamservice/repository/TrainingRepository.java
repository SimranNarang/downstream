package com.stackroute.downstreamservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.downstreamservice.model.Certificates;

@Repository
public interface TrainingRepository extends CrudRepository<Certificates, String> {

}
