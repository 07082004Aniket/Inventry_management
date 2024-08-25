package com.aniket.maincontrol;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aniket.daoclass.*;
import com.aniket.model.*;

@Controller
public class IssueProcessedController {

	@Autowired
	IssueProcessedDao issueProcessedDao;
	@Autowired
	IssueProcessed issueProcessed;
	@Autowired
	ProcessedMaterial processedMaterial;
	@Autowired
	ProcessedMaterialDao processedMaterialDao;
	
	@RequestMapping("/viewIssuepro")
	public String viewIssueRawdMaterial(Model model)
	{
		List<IssueProcessed> issueProcessed=issueProcessedDao.getAllIssueProcessed();
		model.addAttribute("issueProcessedList",issueProcessed);
		return "viewIssueProcesseddMaterial";
	}
	

	@RequestMapping(path="/addissuepro",method=RequestMethod.GET)
	public String addissue(HttpServletRequest request,Model model)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		ProcessedMaterial processedMaterial=processedMaterialDao.getProcessedMaterial(id);
		model.addAttribute("processedMateriallList",processedMaterial);
		return "addissueProcessed";
	}
	
	@RequestMapping(path="/addissueProcesseddb",method=RequestMethod.POST)
	public String addUsersdb(@ModelAttribute IssueProcessed issueProcessed,HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("processedId"));
		float issue_quantity=Float.parseFloat(request.getParameter("quantity"));
		ProcessedMaterial processedMaterial=processedMaterialDao.getProcessedMaterial(id);
		float curr_quantity=processedMaterial.getQuantity();
		float new_quantity=curr_quantity-issue_quantity;
		processedMaterial.setQuantity(new_quantity);
		processedMaterialDao.updateCustomer(processedMaterial);
		System.out.println(issueProcessed);
		int i=issueProcessedDao.insert(issueProcessed);
		return "redirect:/viewIssuepro";
	}
	
}
