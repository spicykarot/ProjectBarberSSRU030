package com.man.barber.model;

import java.util.List;

import com.man.barber.entity.MsUser;

public class BarberShopModel {
	private Long id;
	private String name;
	private String address;
	private long tel;
	private String image;
	private Long barberOwnerId;
	private List<BarberServiceModel> barberServiceList;
	private List<BarberTeamModel> barberTeamList;
	
	public BarberShopModel() {
		
	}

	public BarberShopModel(Long id, String name, String address, long tel, String image, Long barberOwnerId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.image = image;
		this.barberOwnerId = barberOwnerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getBarberOwnerId() {
		return barberOwnerId;
	}

	public void setBarberOwnerId(Long barberOwnerId) {
		this.barberOwnerId = barberOwnerId;
	}

	public List<BarberServiceModel> getBarberServiceList() {
		return barberServiceList;
	}

	public void setBarberServiceList(List<BarberServiceModel> barberServiceList) {
		this.barberServiceList = barberServiceList;
	}

	public List<BarberTeamModel> getBarberTeamList() {
		return barberTeamList;
	}

	public void setBarberTeamList(List<BarberTeamModel> barberTeamList) {
		this.barberTeamList = barberTeamList;
	}

	
}
