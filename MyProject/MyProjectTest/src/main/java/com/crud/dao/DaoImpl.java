package com.crud.dao;


import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.model.Admin_Model;
import com.crud.model.Save_Model;

@Repository
public class DaoImpl implements Dao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void saveData(Save_Model save) {
		// TODO Auto-generated method stub
		
		 Session session=entityManager.unwrap(Session.class); 
		 session.save(save);
		 
				
	}

	@Override
	public String doLog(Save_Model log) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Query<Save_Model>query=session.createQuery("from Save_Model S where S.username='"+log.getUsername()+"' and S.password='"+log.getPassword()+"' and S.roleType='"+log.getRoleType()+"'");
		List<Save_Model>list=query.getResultList();
		String rtype="none";
		if(list.size()>0)
		{
			for(Save_Model s:list)
			
				rtype = s.getRoleType();
			
			
		}
		return rtype;
		}
		//session.save(log);
		//return null;

	@Override
	public void saveAdmin(Admin_Model admin) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class); 
		session.save(admin);
	}

	@Override
	public List<Admin_Model> getAdminData(String email) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Query<Admin_Model>query=session.createQuery("from Admin_Model A where A.assignedTo='"+email+"'",Admin_Model.class);
		List<Admin_Model>list=query.getResultList();
		return list;
	}

	

	@Override
	public List<Admin_Model> getTask() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Query<Admin_Model>query=session.createQuery("from Admin_Model ",Admin_Model.class);
		List<Admin_Model>list=query.getResultList();
		return list;
	}

	@Override
	public boolean doUpdate(int id1) {
		// TODO Auto-generated method stub
		
	    
	     System.out.println(id1);
	    // Admin_Model admin1=new Admin_Model();
	    // admin1.setStatus("complete"); 
	     Session session=entityManager.unwrap(Session.class);
	     Admin_Model admin1=session.get(Admin_Model.class, id1); 
	     System.out.println("TaskDate "+admin1.getAssignDate());
	     System.out.println("ID "+admin1.getId());
	     admin1.setStatus("complete");
	     session.update(admin1);
		 
		return true;
	}

	
	
}
