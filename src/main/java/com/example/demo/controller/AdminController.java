package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;

//@Controller + @ResponseBody == @RestController
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	Map<Integer, Admin> map = new HashMap<>();

//	@GetMapping
//	public Admin admin() {
//		System.out.println("MyController.admin()");
//		return new Admin(1, "Vikas Chaubey", "vk1111");
//	}
	
	@GetMapping("/{id}")
	public Admin getAdminById(@PathVariable int id) {
		System.out.println("MyController.getAdminById()");
		
		return map.get(id);
	}
	
	
	@GetMapping("/allAdmins")
	public Map<Integer,Admin> getAllAdmins() {
		System.out.println("MyController.getAllAdmins()");
		return map;
	}

	@PostMapping
	public Admin requestBodyInfo(@RequestBody Admin admin)
	{
		System.out.println("Hello : "+admin);
		adminService.saveAdmin(admin);
//		map.put(admin.getId(), admin);
		return admin;
	}
	
	@PatchMapping
	public Admin updateAdmin(@RequestBody Admin admin) {
		System.out.println("AdminController.updateAdmin()");
		map.put(admin.getId(), admin);
		return admin;
	}
	
	@DeleteMapping("/{id}")
	public Admin delAdminById(@PathVariable int id) {
		System.out.println("AdminController.delAdminById()");
		return map.remove(id);
	}
	
	
}
