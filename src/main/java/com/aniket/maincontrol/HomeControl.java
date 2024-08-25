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
public class HomeControl {
	@Autowired
	RawMaterial rawMaterial;
	@Autowired
	RawMaterialDao rawMaterialDao;
	@Autowired
	ProcessedMaterial processedMaterial;
	@Autowired
	ProcessedMaterialDao processedMaterialDao;
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(path="/loginmanager", method=RequestMethod.POST)
	public String loginAdmin(HttpServletRequest request,Model model)
	{
		String aemail=request.getParameter("email");
		String apass=request.getParameter("pass");
		
		if(aemail.equals("manager@gmail.com")&& apass.equals("manager"))
		{
			model.addAttribute("em",aemail);
			return "homeView";
		}
		else
		{
			return "error";
		}
		
	}
	
	@RequestMapping("/view")
	public String homeView()
	{
		return "homeView";
	}
	
	@RequestMapping("/unavailableRaw")
	public String unavailableRawMaterial(Model model)
	{
		List<RawMaterial> rawMaterial=rawMaterialDao.getAllRawMaterial();
		model.addAttribute("rawMaterialList",rawMaterial);
		return "unavailableRawMaterial";
	}
	
	@RequestMapping("/unavailableProcessed")
	public String unavailableProcessedMaterial(Model model)
	{
		List<ProcessedMaterial> processedMaterial=processedMaterialDao.getAllProcessedMaterial();
		model.addAttribute("processedMaterialList",processedMaterial);
		return "unavailableProcessedMaterial";
	}
	
	@RequestMapping("/changePassword")
	public String changePassword()
	{
		return "changePassword";
	}
	
	
	
}
