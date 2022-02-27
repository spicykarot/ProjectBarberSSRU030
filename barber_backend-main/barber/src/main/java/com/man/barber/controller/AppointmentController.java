package com.man.barber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.man.barber.model.AppointmentDTO;
import com.man.barber.model.AppointmentModel;
import com.man.barber.model.BarberShopModel;
import com.man.barber.service.AppointmentService;
import com.man.barber.service.BarberShopService;

@RestController
@RequestMapping("/apiAppointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService ;
	
	@GetMapping(value = "/findAppointmentByCustomerId/{customerId}")
	public List<AppointmentDTO> findAppointmentByCustomerId(
			@PathVariable Long customerId){
		return appointmentService.findAppointmentDTOByUserId(customerId);
	}
	
	
	
	@PostMapping("/addAppointment")
	public Boolean addAppointment(@RequestBody(required = true) AppointmentModel appointmentModel) {
		return appointmentService.addAppointment(appointmentModel);
	}
	
	@RequestMapping(value = "/updateAppointment", method = RequestMethod.PUT)
    public Boolean updateAppointment(@RequestBody(required = true) AppointmentModel barberShopModel) {
        return appointmentService.updateAppointment(barberShopModel);
    }

}
