package com.aniket.daoclass;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

import com.aniket.model.IssueProcessed;

@Component
public class IssueProcessedDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	public IssueProcessedDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IssueProcessedDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String toString() {
		return "IssueProcessedDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Transactional
	public int insert(IssueProcessed issueProcessed)
	{
		Integer i = (Integer) this.hibernateTemplate.save(issueProcessed);
		return i;
	}
	
	public IssueProcessed getIssueProcessed(int id)
	{
		IssueProcessed issueProcessed = this.hibernateTemplate.get(IssueProcessed.class, id);
		return issueProcessed;
	}
	
	public List<IssueProcessed> getAllIssueProcessed() {
		List<IssueProcessed> issueProcessed = this.hibernateTemplate.loadAll(IssueProcessed.class);
		return issueProcessed;
		}
	
	@Transactional
	public void deleteIssueProcessed(int id) {
		IssueProcessed issueProcessed = this.hibernateTemplate.get(IssueProcessed.class, id);
		this.hibernateTemplate.delete(issueProcessed);
		}
	
	@Transactional
	public void updateIssueProcessed(IssueProcessed issueProcessed) {
		this.hibernateTemplate.update(issueProcessed);
		}
	
}
