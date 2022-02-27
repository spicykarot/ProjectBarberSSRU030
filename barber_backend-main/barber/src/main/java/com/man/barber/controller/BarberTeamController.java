package com.man.barber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.man.barber.model.BarberShopModel;
import com.man.barber.model.BarberTeamModel;
import com.man.barber.service.BarberShopService;
import com.man.barber.service.BarberTeamService;

@RestController
@RequestMapping("/apiBarberTeam")
public class BarberTeamController {
	@Autowired
	private BarberTeamService barberTeamService;
	
	@PostMapping("/addBarberTeam")
	public Boolean addMainTimesheet(@RequestBody(required = true) BarberTeamModel barberTeamModel) {
		return barberTeamService.addBarberTeam(barberTeamModel);
	}
	
}
