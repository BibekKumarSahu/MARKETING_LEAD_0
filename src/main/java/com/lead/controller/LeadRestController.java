package com.lead.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lead.entities.Lead;
import com.lead.repository.LeadRepository;

@RestController
@RequestMapping("/api/lead") // localhost:8080/api/lead
public class LeadRestController {
	@Autowired
	private LeadRepository leadrepo;

	@GetMapping // localhost:8080/api/lead
	public List<Lead> getAllLeads() {
		List<Lead> list = leadrepo.findAll();
		return list;
	}

	@PostMapping // localhost:8080/api/lead
	public void saveLead(@RequestBody Lead lead) {
		leadrepo.save(lead);
	}

	@DeleteMapping("/{id}") // localhost:8080/api/lead/{id}
	public void deleteLead(@PathVariable("id") long id) {
		leadrepo.deleteById(id);
	}

	@PutMapping // localhost:8080/api/lead
	public void updateLead(@RequestBody Lead lead) {
		leadrepo.save(lead);
	}

	@GetMapping("/leads/{id}") // http://localhost:8080/api/lead/leads/{id}
	public Lead GetLeadById(@PathVariable("id") long id) {
		Optional<Lead> lead = leadrepo.findById(id);
		return lead.get();
	}

}