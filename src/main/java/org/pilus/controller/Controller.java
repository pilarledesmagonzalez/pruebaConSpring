package org.pilus.controller;

import org.pilus.pojos.PruebaPOJO;
import org.pilus.service.DBConnection;
import org.pilus.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired 
	//private PruebaService service;
	public DBConnection dbconnection;
	
	
	@GetMapping(value="/getByID")
	public void getByID() {
		dbconnection.Connect();
		
		System.out.println(new PruebaService().getByID());
		dbconnection.CloseDBConnection();
	
	}

}
