
package com.aniket.maincontrol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aniket.daoclass.RawMaterialDao;
import com.aniket.model.RawMaterial;

@Controller
public class RawController {
	@Autowired
	RawMaterial rawMaterial;
	@Autowired
	RawMaterialDao rawMaterialDao;
	
	@RequestMapping("/viewRaw")
	public String viewall(Model model)
	{
		List<RawMaterial> rawMaterial=rawMaterialDao.getAllRawMaterial();
		model.addAttribute("rawMaterialList",rawMaterial);
		return "viewRawMaterial";
	}
	
	@RequestMapping(path="/updateRaw",method=RequestMethod.GET)
	public String updateRawMaterial(HttpServletRequest request,Model model)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		rawMaterial=rawMaterialDao.getRawMaterial(id);
		model.addAttribute("rawMaterialList",rawMaterial);
		return "updateRawMaterial";
	}
	
	@RequestMapping(path="/updateRawdb",method=RequestMethod.POST)
	public String updateRawdb(@ModelAttribute RawMaterial rawMaterial,HttpServletRequest request)
	{
		System.out.println(rawMaterial);
		rawMaterialDao.updateRawMaterial(rawMaterial);
		return "redirect:/viewRaw";
	}
	
	@RequestMapping("/addraw")
	public String addRaw()
	{
		return "addRaw";
	}
	
	@RequestMapping(path="/addRawdb",method=RequestMethod.POST)
	public String addUsersdb(@ModelAttribute RawMaterial rawMaterial,HttpServletRequest request)
	{
		System.out.println(rawMaterial);
		int i=rawMaterialDao.insert(rawMaterial);
		return "redirect:/viewRaw";
	}
	
	@RequestMapping(path="/deleteRaw",method=RequestMethod.GET)
	public String deleteUsersById(HttpServletRequest request,Model model)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		rawMaterialDao.deleteRawMaterial(id);
		return "redirect:/viewRaw";
	}

}
