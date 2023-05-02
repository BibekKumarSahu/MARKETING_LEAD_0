package com.lead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lead.Email.ServiceEmail;
import com.lead.dto.DtoLead;
import com.lead.entities.Lead;
import com.lead.service.ServiceLead;

@Controller
public class LeadController {
//  localhost:8080/control
	@Autowired
	private ServiceLead servicelead;
	@Autowired
	private ServiceEmail serviceemail;

	@RequestMapping("/control")
	public String CreateLeadd() {
		return "NewFile";
	}

//	@RequestMapping("/bibek")
//	public String SaveLeadd(Lead lead,ModelMap m) {
//		m.addAttribute("msg", "Lead Saved!!");
//		servicelead.SaveReg(lead);
//		return "NewFile";
//	}
	@RequestMapping("/bibek")
	public String SaveLeadd(@ModelAttribute Lead lead, ModelMap m) {
		m.addAttribute("msg", "Lead Saved!!");
		servicelead.SaveReg(lead);
		serviceemail.emailsend(lead.getEmail(), "Fuck You", "Banda");
		return "NewFile";
	}

//	@RequestMapping("/bibek")
//	public String SaveLeadd(@RequestParam("name") String name, @RequestParam("city") String city,
//			@RequestParam("mobile") long mobile, Model m) {
//		m.addAttribute("msg", "Lead Saved!!");
//		Lead lead = new Lead();
//		lead.setName(name);
//		lead.setCity(city);
//		lead.setMobile(mobile);
//		servicelead.SaveReg(lead);
//		return "NewFile";
//	}
//	@RequestMapping("/bibek")
//	public String SaveLeadd(DtoLead dto,Model m) {
//		
//		m.addAttribute("msg", "Lead Saved!!");
//		Lead lead = new Lead();
//		lead.setName(dto.getName());
//		lead.setCity(dto.getCity());
//		lead.setMobile(dto.getMobile());
//		servicelead.SaveReg(lead);
//		return "NewFile";
//	}
	// localhost:8080/listtt
	@RequestMapping("/listtt")
	public String GetAllLeads(ModelMap model) {
		List<Lead> leads = servicelead.findallLeads();
		model.addAttribute("leads", leads);
		return "List_Leads";
	}

	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id") long id, Model model) {
		servicelead.deleteById(id);
		List<Lead> leads = servicelead.findallLeads();
		model.addAttribute("leads", leads);
		return "List_Leads";
	}

	@RequestMapping("/update")
	public String UpdateLeadById(@RequestParam("id") long id, Model model) {
		Lead lead = servicelead.findById(id);
		model.addAttribute("lead", lead);
		return "Update_Lead";
	}

	@RequestMapping("/edit")
	public String EditLeadById(DtoLead dto, Model model) {
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setName(dto.getName());
		lead.setCity(dto.getCity());
		lead.setMobile(dto.getMobile());
		servicelead.SaveReg(lead);
		List<Lead> leads = servicelead.findallLeads();
		model.addAttribute("leads", leads);
		return "List_Leads";
	}

}
