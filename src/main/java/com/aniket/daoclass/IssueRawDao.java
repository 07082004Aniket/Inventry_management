package com.aniket.daoclass;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

import com.aniket.model.IssueRaw;

@Component
public class IssueRawDao {

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public IssueRawDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IssueRawDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String toString() {
		return "IssueRawDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Transactional
	public int insert(IssueRaw issueRaw)
	{
		Integer i = (Integer) this.hibernateTemplate.save(issueRaw);
		return i;
	}
	
	public IssueRaw getIssueRaw(int id)
	{
		IssueRaw issueRaw = this.hibernateTemplate.get(IssueRaw.class, id);
		return issueRaw;
	}
	
	public List<IssueRaw> getAllIssueRaw() {
		List<IssueRaw> issueRaw = this.hibernateTemplate.loadAll(IssueRaw.class);
		return issueRaw;
		}
	
	@Transactional
	public void deleteIssueRaw(int id) {
		IssueRaw issueRaw = this.hibernateTemplate.get(IssueRaw.class, id);
		this.hibernateTemplate.delete(issueRaw);
		}
	
	@Transactional
	public void updateIssueRaw(IssueRaw issueRaw) {
		this.hibernateTemplate.update(issueRaw);
		}
	
}
