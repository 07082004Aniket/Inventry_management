package com.aniket.daoclass;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

import com.aniket.model.RawMaterial;

@Component
public class RawMaterialDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public RawMaterialDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RawMaterialDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String toString() {
		return "RawMaterialDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	
	@Transactional
	public int insert(RawMaterial rawMaterial)
	{
		Integer i = (Integer) this.hibernateTemplate.save(rawMaterial);
		return i;
	}
	
	public RawMaterial getRawMaterial(int id)
	{
		RawMaterial rawMaterial = this.hibernateTemplate.get(RawMaterial.class, id);
		return rawMaterial;
	}
	
	public List<RawMaterial> getAllRawMaterial() {
		List<RawMaterial> rawMaterial = this.hibernateTemplate.loadAll(RawMaterial.class);
		return rawMaterial;
		}
	
	@Transactional
	public void deleteRawMaterial(int id) {
		RawMaterial rawMaterial = this.hibernateTemplate.get(RawMaterial.class, id);
		this.hibernateTemplate.delete(rawMaterial);
		}
	
	@Transactional
	public void updateRawMaterial(RawMaterial rawMaterial) {
		this.hibernateTemplate.update(rawMaterial);
		}
	
}
