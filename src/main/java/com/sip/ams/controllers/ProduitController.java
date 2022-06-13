package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {
	@Value("${formateur}")
	private String trainer;
	@Value("${cible}")
	private String team;
	@Value("${formation}")
	private String course;
	
	@RequestMapping("info")
	public String getInfo() {
		return "<h1>"+ trainer+" "+team+" "+course+"</h1>";
	}

}
