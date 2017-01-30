package com.example.nosqldemo.repository;

import java.util.List;

import com.example.nosqldemo.domain.Pakiet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Pakiet;

public interface PakietRepository extends CrudRepository<Pakiet, ObjectId>{

	@Query(value = "{ 'nazwapakiet' : ?0}" )
	List<Pakiet> znajdzPakiet(String nazwa);

	Pakiet findById(ObjectId id);

}
