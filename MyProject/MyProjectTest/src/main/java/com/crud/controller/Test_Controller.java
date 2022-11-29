package com.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Admin_Model;
import com.crud.model.Save_Model;
import com.crud.service.ServiceTest;


@RestController
@CrossOrigin
public class Test_Controller {
	
	@Autowired(required = false)
	ServiceTest service;
	
@PostMapping("/save")
	public void saveData(@RequestBody Save_Model save)
	{
		/*
		 * System.out.println(save.getUsername());
		 * System.out.println(save.getPassword());
		 * System.out.println(save.getRoleType());
		 */
		service.saveData(save); 
	}

@PostMapping("/log")
public  String getLog(@RequestBody Save_Model log)

{
	System.out.println("Hello");
	System.out.println(log.getRoleType());
	return service.doLog(log);
	
	/*
	 * System.out.println("Type:"+log.getRoleType()); return service.doLog(log);
	 */
}

@PostMapping("/admin")
public void saveAdminData(@RequestBody Admin_Model admin)
{
	service.saveAdmin(admin);
}

@GetMapping("/task")
public List<Admin_Model> getTask()
{
	return service.getTask();
}


@GetMapping("/emp")
public List<Admin_Model> getAdmin(@RequestParam String email)
{
	System.out.println(email);
	return service.getAdminData(email );
}

@GetMapping("/status/{id1}")
public boolean updateStatus(@PathVariable int id1 )

{
	 //int id=Integer.parseInt(id1); 
			
	System.out.println("id:"+id1);
	
	return service.doUpdate(id1);
}

}
