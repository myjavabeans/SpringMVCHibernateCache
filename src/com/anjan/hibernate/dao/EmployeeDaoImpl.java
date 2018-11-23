package com.anjan.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.anjan.hibernate.bean.EmployeeBean;

/**
 * DAO Class
 * 
 * @author Anjan
 *
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveEmployee(EmployeeBean eb) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(eb);
		tx.commit();
		session.close();
	}

	@Override
	public void updateEmployee(EmployeeBean eb) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(eb);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		EmployeeBean empBean = (EmployeeBean) session.get(EmployeeBean.class, new Integer(id));
		
		session.delete(empBean);
		tx.commit();
		session.close();
	}

	@Override
	public EmployeeBean getBeanById(int id) {

		Session session = sessionFactory.openSession();

		Query query = session.getNamedQuery("HQL_GET_EMPLOYEE_BY_ID");
		query.setInteger("id", id);
		
		query.setCacheable(true).setCacheRegion("EMPLOYEE");

		EmployeeBean eb = (EmployeeBean) query.uniqueResult();

		session.close();

		return eb;


	}

	@Override
	public List<EmployeeBean> getAllEmployee() {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from EmployeeBean").setCacheable(true).setCacheRegion("EMPLOYEE");
		List<EmployeeBean> list = query.list();
		session.close();
		return list;

	}

}
