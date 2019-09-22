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


import com.example.dto.StarDTO;
import com.example.service.StarService;

@Controller

@RestController
@RequestMapping(path = "api/v1")
public class StarController {
	
	@Autowired
	 StarService starService;


	@GetMapping(path="/star")
	@CrossOrigin(origins = "*")
	@Transactional
	public List<StarDTO> getAll() throws Exception {

		return ResponseEntity.status(200).body(starService.getAll()).getBody();
	}
	
	@GetMapping(path="/star/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public StarDTO getOne(@PathVariable int id) {

		return
          ResponseEntity.status(200).body(starService.getOne(id)).getBody();
	}
	
	@PostMapping(path="/star")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity post(@RequestBody StarDTO starDTO) {
		
		StarDTO result = new StarDTO();
		
		try {
			
			result = starService.post(starDTO);
			
		} catch (Exception e) {

		}
		
		return ResponseEntity.status(201).body(result);
		
	}
	
	@PutMapping(path = "/star/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity put(@RequestBody StarDTO starDTO, @PathVariable int id) {
		
		StarDTO result = new StarDTO();
		
		try {
			
			result = starService.put(starDTO, id);
			
		} catch (Exception e) {

		}
		
		starDTO.setId(result.getId());
		
		return ResponseEntity.status(201).body(starDTO);
		
	}
	
	@DeleteMapping(path = "/star/{id}")
	@CrossOrigin(origins = "*")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		
		boolean result = starService.delete(id);
		
		if(result) {
			return ResponseEntity.status(204).body("");
		}
		else {
			return ResponseEntity.status(204).body("");
		}
		
	
		
	}
	
	
}
