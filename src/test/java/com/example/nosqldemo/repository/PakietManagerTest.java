package com.example.nosqldemo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.nosqldemo.domain.Antywirus;
import com.example.nosqldemo.domain.Pakiet;
import com.example.nosqldemo.repository.AntywirusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.Pakiet;
import com.example.nosqldemo.service.PakietManager;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class PakietManagerTest {
	
	@Autowired
	PakietManager pakietManager;
	@Autowired
	AntywirusRepository antywirusRepository;

	@Test
	public void checkAdding(){
		Pakiet PAKIECIK = new Pakiet();
		PAKIECIK.setNazwapakiet("fajna");
		PAKIECIK.setOpis("Opis1");
		PAKIECIK.setCena(10.0);
		pakietManager.addNewPakiet(PAKIECIK);
		Pakiet PAKIECIK2 = new Pakiet();
		PAKIECIK2.setNazwapakiet("fajna2");
		PAKIECIK2.setOpis("Opis1");
		PAKIECIK2.setCena(10.0);
		pakietManager.addNewPakiet(PAKIECIK2);
		Pakiet PAKIECIK3 = new Pakiet();
		PAKIECIK3.setNazwapakiet("fajna2");
		PAKIECIK3.setOpis("Opis1");
		PAKIECIK3.setCena(10.0);
		pakietManager.addNewPakiet(PAKIECIK3);


		List<Pakiet> Pakiety = pakietManager.getPakiety("fajna2");

		assertTrue(Pakiety.size() >= 2);
	}


	@Test
	public void checkUpdatePakiet(){
		Pakiet PAKIECIK = new Pakiet();
		PAKIECIK.setNazwapakiet("fajna");
		PAKIECIK.setOpis("Opis1");
		PAKIECIK.setCena(10.0);
		pakietManager.addNewPakiet(PAKIECIK);
		List<Pakiet> Pakiety = pakietManager.getPakiety("fajna2");
		assertEquals("fajna",PAKIECIK.getNazwapakiet());


		PAKIECIK.setNazwapakiet("fajna");
		PAKIECIK.setOpis("lepszy");
		pakietManager.updatePakiet(PAKIECIK);
		List<Pakiet> Pakiety2 = pakietManager.getPakiety("fajna");

		assertEquals("fajna",PAKIECIK.getNazwapakiet());
		assertEquals("lepszy",PAKIECIK.getOpis());
	}
	public void checkDelete(){
		Pakiet PAKIECIK = new Pakiet();
		PAKIECIK.setNazwapakiet("fajna");
		PAKIECIK.setOpis("Opis1");
		PAKIECIK.setCena(10.0);
		pakietManager.addNewPakiet(PAKIECIK);
		pakietManager.deletePakiet(PAKIECIK);

		assertNull(pakietManager.getPakiety("fajna"));
	}




	@Test
	public void checkAddingAntywir(){
		Pakiet PAKIECIK = new Pakiet();
		PAKIECIK.setNazwapakiet("fajnaa");
		PAKIECIK.setOpis("Opis1");
		PAKIECIK.setCena(10.0);
		pakietManager.addNewPakiet(PAKIECIK);
		List<Pakiet> pakietTab = new ArrayList<Pakiet>();
		pakietTab.add(PAKIECIK);

		Antywirus ANTYWIR = new Antywirus();
		ANTYWIR.setnazwa("Antywir1");
		ANTYWIR.setOcena(10);
		ANTYWIR.setAnty(pakietTab);
		antywirusRepository.save(ANTYWIR);

		List<Antywirus> antyrusek = antywirusRepository.findByName("Antywir1");

		assertTrue(antyrusek.size() >= 1);
	}

	@Test
	public void checkFindAntyPakiet(){
		Pakiet PAKIECIK = new Pakiet();
		PAKIECIK.setNazwapakiet("fajnaa");
		PAKIECIK.setOpis("Opis1");
		PAKIECIK.setCena(10.0);
		pakietManager.addNewPakiet(PAKIECIK);
		List<Pakiet> pakietTab = new ArrayList<Pakiet>();
		pakietTab.add(PAKIECIK);

		Antywirus ANTYWIR = new Antywirus();
		ANTYWIR.setnazwa("Antywir1");
		ANTYWIR.setOcena(10);
		ANTYWIR.setAnty(pakietTab);
		antywirusRepository.save(ANTYWIR);

		List<Antywirus> antyrusek = antywirusRepository.findByName("Antywir1");

		assertTrue(antyrusek.size() >= 1);
		assertEquals(pakietTab,ANTYWIR.getAnty());
	}

	@Test
	public void checkDeletePakiefFromAntywir(){
		Pakiet PAKIECIK = new Pakiet();
		PAKIECIK.setNazwapakiet("fajnaa");
		PAKIECIK.setOpis("Opis1");
		PAKIECIK.setCena(10.0);
		pakietManager.addNewPakiet(PAKIECIK);
		List<Pakiet> pakietTab = new ArrayList<Pakiet>();
		pakietTab.add(PAKIECIK);

		Antywirus ANTYWIR = new Antywirus();
		ANTYWIR.setnazwa("Antywir1");
		ANTYWIR.setOcena(10);
		ANTYWIR.setAnty(pakietTab);
		antywirusRepository.save(ANTYWIR);
		ANTYWIR.setAnty(null);
		antywirusRepository.save(ANTYWIR);

		List<Antywirus> antyrusek = antywirusRepository.findByName("Antywir1");

		assertTrue(antyrusek.size() >= 1);
		assertNull(ANTYWIR.getAnty());
	}




}
