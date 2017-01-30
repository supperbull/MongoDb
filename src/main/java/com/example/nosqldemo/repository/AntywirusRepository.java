package com.example.nosqldemo.repository;

import java.util.List;

import com.example.nosqldemo.domain.Antywirus;
import com.example.nosqldemo.domain.Pakiet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Antywirus;

public interface AntywirusRepository extends CrudRepository<Antywirus, ObjectId> {

	//<S extends Pakiet> S save(S entity);
	@Query(value = "{ 'nazwa' : ?0}" )
	List<Antywirus> findByName(String nazwa);




}
