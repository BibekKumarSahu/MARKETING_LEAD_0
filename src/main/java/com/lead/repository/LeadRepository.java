package com.lead.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
