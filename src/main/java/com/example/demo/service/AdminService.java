package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminRepository;
import com.example.demo.model.Admin;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		if (admin != null) {
			adminRepository.save(admin);
		}
		return admin;
	}

}
