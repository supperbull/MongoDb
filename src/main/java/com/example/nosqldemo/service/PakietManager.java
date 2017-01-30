package com.example.nosqldemo.service;

import java.util.List;

import com.example.nosqldemo.domain.Pakiet;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Pakiet;
import com.example.nosqldemo.repository.PakietRepository;

@Component
public class PakietManager {

	@Autowired
	private PakietRepository pakietRepository;

	public void addNewPakiet(Pakiet pakiet){pakietRepository.save(pakiet);}
	public void updatePakiet(Pakiet pakiet){
		pakietRepository.save(pakiet);
	}
	public void deletePakiet(Pakiet pakiet){
		pakietRepository.delete(pakiet);
	}
	public List<Pakiet> getPakiety(String nazwapakiet){
		return pakietRepository.znajdzPakiet(nazwapakiet);
	}

	public Pakiet findById(ObjectId id){
		return pakietRepository.findById(id);
	}
	
	
	
}
