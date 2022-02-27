package com.man.barber.model;


public class BarberTeamModel {
	private Long id;
	private BarberShopModel barbershopId;
	private UserModel hairdresserId;
	
	public BarberTeamModel() {
		
	}
	
	

	public BarberTeamModel(Long id, BarberShopModel barbershopId, UserModel hairdresserId) {
		super();
		this.id = id;
		this.barbershopId = barbershopId;
		this.hairdresserId = hairdresserId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BarberShopModel getBarbershopId() {
		return barbershopId;
	}

	public void setBarbershopId(BarberShopModel barbershopId) {
		this.barbershopId = barbershopId;
	}

	public UserModel getHairdresserId() {
		return hairdresserId;
	}

	public void setHairdresserId(UserModel hairdresserId) {
		this.hairdresserId = hairdresserId;
	}
	
		
}
