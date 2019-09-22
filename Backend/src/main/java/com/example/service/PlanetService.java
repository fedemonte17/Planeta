package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.PlanetDTO;
import com.example.dto.StarDTO;
import com.example.entity.Planet;
import com.example.entity.Star;
import com.example.repository.PlanetRepository;

@Service
public class PlanetService implements BaseService<PlanetDTO>  {

	private PlanetRepository planetRepository;
	
	@Autowired
	public PlanetService(PlanetRepository  planetRepository){
		this.planetRepository = planetRepository;
	}
	

	
	@Override
	public List<PlanetDTO> getAll()  {
		
		List<PlanetDTO> result = new ArrayList<>();
		
		for (Planet planet : planetRepository.findAll()) {
			PlanetDTO temp = new PlanetDTO();
			StarDTO starDTO = new StarDTO();
			temp.setId(planet.getId());
			temp.setNombre(planet.getNombre());
			temp.setSize(planet.getSize());			
			starDTO.setId(planet.getStar().getId());
			starDTO.setNombre(planet.getStar().getNombre());
			starDTO.setDesidad(planet.getStar().getDensidad());
			temp.setStar(starDTO);
			result.add(temp);
		}
		return result;
	}

	@Override
	public PlanetDTO getOne(int id)  {
		Optional<Planet> planetstar = planetRepository.findById(id);
		PlanetDTO planetDTO = new PlanetDTO();	
		try {

			Planet planet = planetstar.get();	
			
			planetDTO.setId(planet.getId());
			planetDTO.setNombre(planet.getNombre());
			planetDTO.setSize(planet.getSize());
			StarDTO starDTO = new StarDTO();
			starDTO.setId(planet.getStar().getId());
			starDTO.setNombre(planet.getStar().getNombre());
			starDTO.setDesidad(planet.getStar().getDensidad());
			planetDTO.setStar(starDTO);
			return planetDTO;
			
		} catch (Exception e) {
			
			return planetDTO;
		}
	}

	@Override
	public PlanetDTO post(PlanetDTO planetDTO) {		
		Planet planet = new Planet();	
		
		
		planet.setNombre(planetDTO.getNombre());
		planet.setSize(planetDTO.getSize());
		Star star = new Star();
		star.setId(planetDTO.getStar().getId());
		//star.setNombre(planetDTO.getStar().getNombre());
		//star.setDensidad(planetDTO.getStar().getDensidad());
		planet.setStar(star);
		
		planetRepository.save(planet);
		
		planetDTO.setId(planet.getId());
		
		return planetDTO;
		
	}
	@Override
	public PlanetDTO put(PlanetDTO planetDTO, int id) {
		Optional<Planet> temp1 = planetRepository.findById(id);
		   
		try {	
			 Planet temp = temp1.get();
			Star star = new Star();
			
			temp.setNombre(planetDTO.getNombre());
			temp.setSize(planetDTO.getSize());
						
			star.setId(planetDTO.getStar().getId());
			star.setNombre(planetDTO.getStar().getNombre());
			star.setDensidad(planetDTO.getStar().getDensidad());
			temp.setStar(star);
			planetRepository.save(temp);	
			planetDTO.setId(temp.getId());	
			
		} catch (Exception e) {			
		}			
		return planetDTO;	
	}

	@Override
	public boolean delete(int id)  {
			
		try {					
			planetRepository.deleteById(id);
			return true;		
		} catch (Exception e) {
			return false;
			
		}
	}



	


}
