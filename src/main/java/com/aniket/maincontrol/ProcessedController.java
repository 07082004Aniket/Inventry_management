package com.aniket.maincontrol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aniket.daoclass.ProcessedMaterialDao;
import com.aniket.model.ProcessedMaterial;
import com.aniket.model.RawMaterial;

@Controller
public class ProcessedController {

	@Autowired
	ProcessedMaterial processedMaterial;
	@Autowired
	ProcessedMaterialDao processedMaterialDao;
	
	@RequestMapping("/viewProcessed")
	public String viewProcessedMaterial(Model model)
	{
		List<ProcessedMaterial> processedMaterial=processedMaterialDao.getAllProcessedMaterial();
		model.addAttribute("processedMaterialList",processedMaterial);
		return "viewProcessedMaterial";
	}
	
	@RequestMapping("/UpdateProcessed")
	public String updateProcessedMaterial()
	{
		return "updateProcessedMaterial";
	}
	
	@RequestMapping("/addprocessed")
	public String addProcessed()
	{
		return "addProcessed";
	}
	
	@RequestMapping(path="/addprocesseddb",method=RequestMethod.POST)
	public String addUsersdb(@ModelAttribute ProcessedMaterial processedMaterial,HttpServletRequest request)
	{
		System.out.println(processedMaterial);
		int i=processedMaterialDao.insert(processedMaterial);
		return "redirect:/viewProcessed";
	}
	
	@RequestMapping(path="/deleteProcessed",method=RequestMethod.GET)
	public String deleteUsersById(HttpServletRequest request,Model model)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		processedMaterialDao.deleteRawMaterial(id);
		return "redirect:/viewProcessed";
	}
	
	@RequestMapping(path="/updateProcessed",method=RequestMethod.GET)
	public String updateRawMaterial(HttpServletRequest request,Model model)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		processedMaterial=processedMaterialDao.getProcessedMaterial(id);
		model.addAttribute("processedMaterialList",processedMaterial);
		return "updateprocessedMaterial";
	}
	
	@RequestMapping(path="/updateProcesseddb",method=RequestMethod.POST)
	public String updateRawdb(@ModelAttribute ProcessedMaterial processedMaterial,HttpServletRequest request)
	{
		System.out.println(processedMaterial);
		processedMaterialDao.updateCustomer(processedMaterial);
		return "redirect:/viewProcessed";
	}
}
