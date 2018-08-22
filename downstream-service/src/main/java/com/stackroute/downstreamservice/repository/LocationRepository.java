package com.stackroute.downstreamservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.downstreamservice.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {

}
