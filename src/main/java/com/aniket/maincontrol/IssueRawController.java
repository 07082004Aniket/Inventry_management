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
public class IssueRawController {

	@Autowired
	IssueRawDao issueRawDao;
	@Autowired
	IssueRaw issueRaw;
	@Autowired
	RawMaterial rawMaterial;
	@Autowired
	RawMaterialDao rawMaterialDao;
	
	@RequestMapping("/viewIssueRaw")
	public String viewIssueRawdMaterial(Model model)
	{
		List<IssueRaw> issueRaw=issueRawDao.getAllIssueRaw();
		model.addAttribute("issueRawList",issueRaw);
		return "viewIssueRawdMaterial";
	}
	

	@RequestMapping(path="/addissueraw",method=RequestMethod.GET)
	public String addissue(HttpServletRequest request,Model model)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		RawMaterial rawMaterial=rawMaterialDao.getRawMaterial(id);
		model.addAttribute("issueRawMaterialList",rawMaterial);
		return "addIssueRaw";
	}
	
	@RequestMapping(path="/addissuerawdb",method=RequestMethod.POST)
	public String addUsersdb(@ModelAttribute IssueRaw IssueRaw,HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("rawId"));
		float issue_quantity=Float.parseFloat(request.getParameter("quantity"));
		
		RawMaterial rawMaterial=rawMaterialDao.getRawMaterial(id);
		float curr_quantity=rawMaterial.getQuantity();
		float new_quantity=curr_quantity-issue_quantity;
		rawMaterial.setQuantity(new_quantity);
		rawMaterialDao.updateRawMaterial(rawMaterial);
		System.out.println(IssueRaw);
		int i=issueRawDao.insert(IssueRaw);
		return "redirect:/viewIssueRaw";
	}
	
	
}
