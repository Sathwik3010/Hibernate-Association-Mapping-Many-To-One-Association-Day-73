package com.codegnan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addrId;
	private String city;
	private String state;
	private String pincode;
	@OneToOne(cascade = CascadeType.ALL)
	private Governer governer;
	
	public Address(String city, String state, String pincode) {
		super();
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	
}
