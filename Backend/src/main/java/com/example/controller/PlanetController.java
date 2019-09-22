package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.dto.PlanetDTO;
import com.example.dto.StarDTO;
import com.example.service.PlanetService;

@Controller
@RestController
@RequestMapping(path = "api/v1")
public class PlanetController {
	
	@Autowired
	PlanetService planetservice;


	
	
	@GetMapping(path="/planet")
	@CrossOrigin(origins = "*")
	@Transactional
	public List<PlanetDTO> getAll() throws Exception {
	
		return ResponseEntity.status(200).body(planetservice.getAll()).getBody();
	}
	
	
	@GetMapping(path="/planet/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public PlanetDTO getOne(@PathVariable int id) {

		return
          ResponseEntity.status(200).body(planetservice.getOne(id)).getBody();
	}
	
	@PostMapping(path="/planet")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity post(@RequestBody PlanetDTO planetDTO) {
		
		PlanetDTO result = planetservice.post(planetDTO);
		
		if(result.getId()!= 0) {
			return ResponseEntity.status(201).body(result);
		}
		else {
			return ResponseEntity.status(400).body("{error: bad request}");
		}
		
	}
	
	@PutMapping(path = "/planet/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity put(@RequestBody PlanetDTO planetDTO, @PathVariable int id) {
		
		PlanetDTO result = new PlanetDTO();
		
		try {
			result = planetservice.put(planetDTO, id);
			
		} catch (Exception e) {

		}
		
		planetDTO.setId(result.getId());
		
		return ResponseEntity.status(201).body(planetDTO);
		
	}
	
	@DeleteMapping(path = "/planet/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		
		boolean result = planetservice.delete(id);
		
		if(result) {
			return ResponseEntity.status(204).body("");
		}
		else {
			return ResponseEntity.status(204).body("");
		}
		
	
		
	}
	
	
}
