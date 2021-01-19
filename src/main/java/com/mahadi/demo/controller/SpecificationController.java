package com.mahadi.demo.controller;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class SpecificationController {
	
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
	
	@GetMapping("/specification/list")
    public ModelMap autoPhaseList(@PageableDefault(size = 400) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model){
    	ModelMap modelMap = new ModelMap();
    	
		/*
		 * if (pageable.getSort().isEmpty()) { pageable =
		 * PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
		 * Sort.by("sortOrder").ascending()); }
		 */
		
    	if (value != null) {
            model.addAttribute("key", value);
           // modelMap.addAttribute("autoPhase", autoPhaseDao.findByNameContainingIgnoreCase(value, pageable));
            return modelMap;
        }else {
        	model.addAttribute("key", "");
        	modelMap.addAttribute("specification", specificationDao.findAll(pageable));
			return modelMap;
		}
    }
	@GetMapping("/contribute/list")
    public ModelMap Contribute(@PageableDefault(size = 400) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model){
    	ModelMap modelMap = new ModelMap();
    	
		/*
		 * if (pageable.getSort().isEmpty()) { pageable =
		 * PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
		 * Sort.by("sortOrder").ascending()); }
		 */
		
    	if (value != null) {
            model.addAttribute("key", value);
           // modelMap.addAttribute("autoPhase", autoPhaseDao.findByNameContainingIgnoreCase(value, pageable));
            return modelMap;
        }else {
        	model.addAttribute("key", "");
        	modelMap.addAttribute("specification", specificationDao.findByContribution());
			return modelMap;
		}
    }
	
	@GetMapping("/specification/form")
	public String autoPhaseForm(@RequestParam(value = "id", required = false) Specification specification, Model m) {
		if (specification == null) {
			specification = new Specification();
		}
		m.addAttribute("specification", specification);
		m.addAttribute("budget", budgetDao.findAll());
		m.addAttribute("monitorRequrement", monitorRequrementDao.findAll());
		m.addAttribute("purpose", purposeDao.findAll());
		
		return "specification/form";
	}
	
	@PostMapping("/specification/form")
	public String autoPhaseSave(@ModelAttribute("specification") @Validated Specification specification,
			BindingResult errors, SessionStatus sessionStatus,
			@RequestParam(name = "btnSubmit", required = false) String btnSubmit, RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model m) throws ParseException {
		if (errors.hasErrors()) {
			return "specification/form";
		}
		
		specification.setUpdatedAt(new Date());
		specificationDao.save(specification);
		sessionStatus.setComplete();
		if (btnSubmit.equalsIgnoreCase("SaveClose")) {
			redirectAttributes.addFlashAttribute("message", "Auto Phase has been saved successfully");
			return "redirect:/specification/list";
		} else if (btnSubmit.equalsIgnoreCase("SaveNew")) {
			redirectAttributes.addFlashAttribute("message", "Auto Phase has been saved successfully");
			return "redirect:/specification/form";
		} else {
			specificationDao.delete(specification);
			return "redirect:/specification/form";
		}
	}
	
	@GetMapping("/specification/delete")
   	public String delete(String id, RedirectAttributes redirAttrs) {
   		try {
   			specificationDao.deleteById(id);
   			return "redirect:/specification/list";
   		} catch (Exception e) {
   			redirAttrs.addFlashAttribute("message", "Deletion failed.");
   			return "redirect:/specification/form";
   		}
   		
   	}
	
	@GetMapping("/specification/admin")
	public String thankYou(@RequestParam(value = "id", required = false) Specification specification, Model m) {

		return "specification/admin";
	}
	


}
