package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.dao.Dao;
import com.crud.model.Admin_Model;
import com.crud.model.Save_Model;
@Service
public class ServiceImpl implements ServiceTest {

	@Autowired
	 Dao dao;
	
	@Transactional
	@Override
	public void saveData(Save_Model save) {
		// TODO Auto-generated method stub
		
		dao.saveData(save);
	}

	@Transactional
	@Override
	public String doLog(Save_Model log) {
		// TODO Auto-generated method stub
		
		return  dao.doLog(log);
	}

	@Transactional
	@Override
	public void saveAdmin(Admin_Model admin) {
		// TODO Auto-generated method stub
		dao.saveAdmin(admin);
		
	}

	@Transactional
	@Override
	public List<Admin_Model> getAdminData(String email) {
		// TODO Auto-generated method stub
		return dao.getAdminData(email);
	}

	

	@Transactional
	@Override
	public List<Admin_Model> getTask() {
		// TODO Auto-generated method stub
		return dao.getTask();
	}

	@Override
	public boolean doUpdate(int id1) {
		// TODO Auto-generated method stub
		return dao.doUpdate(id1);
	}

	
	
	

}
