package com.nttdata.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Car
 *
 */
@Entity

public class Car implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String brand;
	private LocalDate registration;
	private String country;
	private LocalDate created_at;
	private LocalDate update_at;
	private static final long serialVersionUID = 1L;

	public Car() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}   
	public LocalDate getRegistration() {
		return this.registration;
	}

	public void setRegistration(LocalDate registration) {
		this.registration = registration;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public LocalDate getCreated_at() {
		return this.created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}   
	public LocalDate getUpdate_at() {
		return this.update_at;
	}

	public void setUpdate_at(LocalDate update_at) {
		this.update_at = update_at;
	}
   
}
