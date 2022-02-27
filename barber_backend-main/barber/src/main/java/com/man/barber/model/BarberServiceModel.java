package com.man.barber.model;

import com.man.barber.entity.MsBarberShop;

public class BarberServiceModel {

	private Long id;
	private String name;
	private int price;
	private Long barbershopId;
	
	public BarberServiceModel() {
		
	}
	
	public BarberServiceModel(Long id, String name, int price, Long barbershopId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.barbershopId = barbershopId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getBarbershopId() {
		return barbershopId;
	}
	public void setBarbershopId(Long barbershopId) {
		this.barbershopId = barbershopId;
	}
	
	
}
