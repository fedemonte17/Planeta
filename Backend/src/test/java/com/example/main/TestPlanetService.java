package com.example.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.PlanetDTO;
import com.example.dto.StarDTO;
import com.example.repository.PlanetRepository;
import com.example.service.PlanetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlanetService {

	@Autowired 
	PlanetService planetaservice;
	PlanetRepository planetarepository;
	


	@Test
	public void testGetOne() {
		PlanetDTO planetaAntes = planetaservice.getOne(5);
				
		PlanetDTO planet = new PlanetDTO();
		planet.setId(5);
		planet.getNombre();
		planet.getSize();
		StarDTO star = new StarDTO();
		star.getId();
		star.getNombre();
		star.getDensidad();
		planet.getStar();
		
		
		
		assertEquals("Marte",planetaAntes.getNombre());
		assertEquals("124",planetaAntes.getSize());
		assertEquals(1,planetaAntes.getStar().getId());
		assertEquals("Las Tres Marias",planetaAntes.getStar().getNombre());
		assertEquals("425",planetaAntes.getStar().getDensidad());
		
	}



	@Test
	public void testPut() {
	
		PlanetDTO planetaAntes = planetaservice.getOne(1);
	
		planetaAntes.setNombre("Luna");
		planetaAntes.setSize("151");
		StarDTO star = new StarDTO();
		star.setId(1);
		planetaAntes.setStar(star);
			
	
		PlanetDTO planetaDespues = planetaservice.put(planetaAntes, 1);
	
		assertEquals("Luna", planetaDespues.getNombre());
		assertEquals("151", planetaDespues.getSize());
		assertEquals(1, planetaDespues.getStar().getId());
	}



}
