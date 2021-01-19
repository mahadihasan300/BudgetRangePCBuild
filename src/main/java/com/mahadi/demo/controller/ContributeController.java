package com.mahadi.demo.controller;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mahadi.demo.dao.BudgetDao;
import com.mahadi.demo.dao.MonitorRequrementDao;
import com.mahadi.demo.dao.PurposeDao;
import com.mahadi.demo.dao.SpecificationDao;
import com.mahadi.demo.entity.Specification;

@Controller
public class ContributeController {
	@Autowired
	private SpecificationDao specificationDao;
	
	@Autowired
	private BudgetDao budgetDao;
	
	@Autowired
	private MonitorRequrementDao monitorRequrementDao;
	
	@Autowired
	private PurposeDao purposeDao;
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/contribute/form")
	public String autoPhaseForm(@RequestParam(value = "id", required = false) Specification specification, Model m) {
		if (specification == null) {
			specification = new Specification();
		}
		m.addAttribute("specification", specification);
		m.addAttribute("budget", budgetDao.findAll());
		m.addAttribute("monitorRequrement", monitorRequrementDao.findAll());
		m.addAttribute("purpose", purposeDao.findAll());
		
		return "contribute/form";
	}
	
	@PostMapping("/contribute/form")
	public String autoPhaseSave(@ModelAttribute("specification") @Validated Specification specification,
			BindingResult errors, SessionStatus sessionStatus,
			@RequestParam(name = "btnSubmit", required = false) String btnSubmit, RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model m) throws ParseException {
		if (errors.hasErrors()) {
			return "contribute/form";
		}
		
		specification.setUpdatedAt(new Date());
		specificationDao.save(specification);
		sessionStatus.setComplete();
		if (btnSubmit.equalsIgnoreCase("SaveClose")) {
			redirectAttributes.addFlashAttribute("message", "Your Record has been saved successfully");
			return "redirect:/contribute/thankYou";
		} else if (btnSubmit.equalsIgnoreCase("SaveNew")) {
			redirectAttributes.addFlashAttribute("message", "Your Record has been saved successfully");
			return "redirect:/contribute/form";
		} else {
			specificationDao.delete(specification);
			return "redirect:/contribute/form";
		}
	}
	
	@GetMapping("/contribute/thankYou")
	public String thankYou(@RequestParam(value = "id", required = false) Specification specification, Model m) {
//		if (specification == null) {
//			specification = new Specification();
//		}
//		m.addAttribute("specification", specification);
//		m.addAttribute("budget", budgetDao.findAll());
//		m.addAttribute("monitorRequrement", monitorRequrementDao.findAll());
//		m.addAttribute("purpose", purposeDao.findAll());
		
		return "contribute/thankYou";
	}

}
