package com.aniket.daoclass;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

import com.aniket.model.ProcessedMaterial;


@Component
public class ProcessedMaterialDao {

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public ProcessedMaterialDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProcessedMaterialDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String toString() {
		return "ProcessedMaterialDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	
	@Transactional
	public int insert(ProcessedMaterial processedMaterial)
	{
		Integer i = (Integer) this.hibernateTemplate.save(processedMaterial);
		return i;
	}
	
	public ProcessedMaterial getProcessedMaterial(int id)
	{
		ProcessedMaterial processedMaterial = this.hibernateTemplate.get(ProcessedMaterial.class, id);
		return processedMaterial;
	}
	
	public List<ProcessedMaterial> getAllProcessedMaterial() {
		List<ProcessedMaterial> processedMaterial = this.hibernateTemplate.loadAll(ProcessedMaterial.class);
		return processedMaterial;
		}
	
	@Transactional
	public void deleteRawMaterial(int id) {
		ProcessedMaterial processedMaterial = this.hibernateTemplate.get(ProcessedMaterial.class, id);
		this.hibernateTemplate.delete(processedMaterial);
		}
	
	@Transactional
	public void updateCustomer(ProcessedMaterial processedMaterial) {
		this.hibernateTemplate.update(processedMaterial);
		}
	
}
