package com.man.barber.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TR_BARBERSERVICE")
@XmlRootElement
public class TrBarberService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID", nullable = false, updatable = true)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private int price;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "BARBERSHOP_ID", referencedColumnName = "id", nullable = false)
	private MsBarberShop barbershopId;

	public TrBarberService() {

	}

	public TrBarberService(Long id, String name, int price, MsBarberShop barbershopId) {
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

	public MsBarberShop getBarbershopId() {
		return barbershopId;
	}

	public void setBarbershopId(MsBarberShop barbershopId) {
		this.barbershopId = barbershopId;
	}
	
	

}