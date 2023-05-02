package com.lead.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lead.entities.Lead;
import com.lead.repository.LeadRepository;

@Service
public class ServiceLeadImpl implements ServiceLead {
	@Autowired//Dependency Injection
	private LeadRepository leadrepo;

	@Override
	public void SaveReg(Lead lead) {//To Save Data into the Database
		leadrepo.save(lead);
	}

	@Override
	public List<Lead> findallLeads() {
		List<Lead> leads = leadrepo.findAll();// To Read data into the database
		return leads;
	}

	@Override
	public void deleteById(long id) {
		leadrepo.deleteById(id);
		
	}

	@Override
	public Lead findById(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();
		return lead;


	}
}
