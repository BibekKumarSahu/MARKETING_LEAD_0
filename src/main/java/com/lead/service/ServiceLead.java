package com.lead.service;

import java.util.List;

import com.lead.entities.Lead;

public interface ServiceLead {
	
	public void SaveReg(Lead lead);

	public List<Lead> findallLeads();

	public void  deleteById(long id);

	public Lead findById(long id);


}
