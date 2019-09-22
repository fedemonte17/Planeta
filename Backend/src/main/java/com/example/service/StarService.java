package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.dto.StarDTO;

import com.example.entity.Star;
import com.example.repository.StarRepository;

@Service
public class StarService implements BaseService<StarDTO> {

	@Autowired
	private StarRepository starRepository;
	

	
	@Override
	public List<StarDTO> getAll()  {
	List<StarDTO> result = new ArrayList<>();
		
		for (Star star : starRepository.findAll()) {
			StarDTO temp = new StarDTO();
			temp.setId(star.getId());
			temp.setNombre(star.getNombre());
			temp.setDesidad(star.getDensidad());
			result.add(temp);
		}
		return result;
	}

	@Override
	public StarDTO getOne(int id)  {
		Optional<Star> planetstar = starRepository.findById(id);
		StarDTO starDTO = new StarDTO();	
		try {

			Star star = planetstar.get();			
			starDTO.setId(star.getId());
			starDTO.setNombre(star.getNombre());
			starDTO.setDesidad(star.getDensidad());
			
			
			
		} catch (Exception e) {
			
			
		}
		return starDTO;
	}

	@Override
	public StarDTO post(StarDTO starDTO) {		
		Star star = new Star();		
		star.setId(starDTO.getId());
		star.setNombre(starDTO.getNombre());
		star.setDensidad(starDTO.getDensidad());
		try {			
			starRepository.save(star);			
		} catch (Exception e) {						
		}	
		starDTO.setId(star.getId());
		return starDTO;
		
	}
	@Override
	public StarDTO put(StarDTO starDTO, int id) {
		Optional<Star> temp = starRepository.findById(id);			
		try {		
			Star star = temp.get();
			star.setNombre(starDTO.getNombre());
			star.setDensidad(starDTO.getDensidad());
			starRepository.save(star);		
			starDTO.setId(star.getId());		
		} catch (Exception e) {			
		}			
		return starDTO;	
	}

	@Override
	public boolean delete(int id)  {
		
		try {					
			starRepository.deleteById(id);
					
		} catch (Exception e) {
			return false;
			
		}
		return true;	
	}



}
