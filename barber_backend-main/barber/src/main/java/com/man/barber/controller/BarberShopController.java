package com.man.barber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.man.barber.model.BarberShopModel;
import com.man.barber.service.BarberShopService;

@RestController
@RequestMapping("/apiBarberShop")
public class BarberShopController {
	
	@Autowired
	private BarberShopService barberShopService ;
	
	@RequestMapping(value = "/getBarberById/{id}", method = RequestMethod.GET)
	public BarberShopModel getBarberShopById(@PathVariable Long id) {
		return barberShopService.getBarberShopModelById(id);
	}
	
	@RequestMapping(value = "/getAllBarberShop", method = RequestMethod.GET)
	public @ResponseBody Page<BarberShopModel> getAllBarberShoptFilterWithPagingAndSearching(
			@RequestParam(value = "name", required=false) String name,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize) {
		return barberShopService.getAllBarberShopModelFilterWithPaggingAndSearching(name, pageNo, pageSize);
	}
	
	@PostMapping("/addBarberShop")
	public Boolean addMainTimesheet(@RequestBody(required = true) BarberShopModel barberShopModel) {
		return barberShopService.addBarberShop(barberShopModel);
	}
	
	@RequestMapping(value = "/updateBarberShop", method = RequestMethod.PUT)
    public Boolean updateMainTimesheet(@RequestBody(required = true) BarberShopModel mainTimesheetModel) {
        return barberShopService.updateBarberShop(mainTimesheetModel);
    }

}
