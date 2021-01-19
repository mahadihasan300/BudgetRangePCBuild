package com.mahadi.demo.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
public class SpecificationUserController {
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
	
	public String budget;
	public String monitorRequrement;
	public String purpose;
	
	
	@GetMapping("/specificationUser/list")
    public ModelMap userList(@Validated @ModelAttribute("specification") Specification specification, @PageableDefault(size = 10) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model){
    	ModelMap modelMap = new ModelMap();
		
    
 
//        	String budget = specification.getBudget().getDisplayName();
//        	String monitorRequrement = specification.getMonitorRequrement().getDisplayName();
//        	String purpose = specification.getPurpose().getDisplayName();
  //      	modelMap.addAttribute("specification", specificationDao.findByBudgetAndMonitorRequrementAndPurpose(budget, monitorRequrement, purpose));
        	modelMap.addAttribute("specification", specificationDao.findByIsActiveTrue(budget, monitorRequrement, purpose));
    	
        	
        	//modelMap.addAttribute("specification", specificationDao.findAll(pageable));
			return modelMap;
		
    }
	
	@GetMapping("/specificationUser/user-form")
	public String userForm(@RequestParam(value = "id", required = false) Specification specification, Model m) {
		if (specification == null) {
			specification = new Specification();
		}
		m.addAttribute("specification", specification);
		m.addAttribute("budget", budgetDao.findAll());
		m.addAttribute("monitorRequrement", monitorRequrementDao.findAll());
		m.addAttribute("purpose", purposeDao.findAll());
		return "specificationUser/user-form";
	}
	
	@GetMapping("/")
	public String homePage(@RequestParam(value = "id", required = false) Specification specification, Model m) {
		if (specification == null) {
			specification = new Specification();
		}
		m.addAttribute("specification", specification);
		m.addAttribute("budget", budgetDao.findAll());
		m.addAttribute("monitorRequrement", monitorRequrementDao.findAll());
		m.addAttribute("purpose", purposeDao.findAll());
		return "specificationUser/user-form";
	}
	
//	@PostMapping("/specificationUser/user-form")
//	public String userFormSave(@ModelAttribute("specification") @Validated Specification specification,
//			BindingResult errors, SessionStatus sessionStatus,
//			@RequestParam(name = "btnSubmit", required = false) String btnSubmit, RedirectAttributes redirectAttributes,
//			HttpServletRequest request, Model m) throws ParseException {
//		ModelMap modelMap = new ModelMap();
//		
//        	String budget = specification.getBudget().getDisplayName();
//        	String monitorRequrement = specification.getMonitorRequrement().getDisplayName();
//        	String purpose = specification.getPurpose().getDisplayName();
//        	modelMap.addAttribute("specification", specificationDao.findByBudgetAndMonitorRequrementAndPurpose(budget, monitorRequrement, purpose));
//			return "specificationUser/list";
//		
//	}

	@PostMapping("/specificationUser/user-form")
	public String userFormSave(@ModelAttribute("specification") @Validated Specification specification,
			BindingResult errors, SessionStatus sessionStatus,
			@RequestParam(name = "btnSubmit", required = false) String btnSubmit, RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model m) throws ParseException {
		
		if (errors.hasErrors()) {
			return "specification/form";
		}
		//specificationDao.save(specification);
			budget = specification.getBudget().getId();
			monitorRequrement = specification.getMonitorRequrement().getId();
			purpose = specification.getPurpose().getId();
    	
    	
    	
		sessionStatus.setComplete();
		if (btnSubmit.equalsIgnoreCase("SaveClose")) {
			//redirectAttributes.addFlashAttribute("message", "Auto Phase has been saved successfully");
			return "redirect:/specificationUser/list";
		} else if (btnSubmit.equalsIgnoreCase("SaveNew")) {
			redirectAttributes.addFlashAttribute("message", "Auto Phase has been saved successfully");
			return "redirect:/specification/form";
		} else {
			specificationDao.delete(specification);
			return "redirect:/specification/form";
		}
	}
	
	@GetMapping("/specificationUser/view")
	public String autoPhaseForm(@RequestParam(value = "id", required = false) Specification specification, Model m) {
		if (specification == null) {
			specification = new Specification();
		}
		m.addAttribute("specification", specification);
		m.addAttribute("budget", budgetDao.findAll());
		m.addAttribute("monitorRequrement", monitorRequrementDao.findAll());
		m.addAttribute("purpose", purposeDao.findAll());
		
		return "specificationUser/view";
	}
	
}
