package com.crud.dao;

import java.util.List;

import com.crud.model.Admin_Model;
import com.crud.model.Save_Model;

public interface Dao {

	void saveData(Save_Model save);

	String doLog(Save_Model log);

	void saveAdmin(Admin_Model admin);

	List<Admin_Model> getAdminData(String email);

	List<Admin_Model> getTask();

	boolean doUpdate(int id1);

	

	

}
