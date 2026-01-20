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
public class Governer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int govId;
	private String govName;
	private double govSalary;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	
	public Governer(String govName, double govSalary) {
		super();
		this.govName = govName;
		this.govSalary = govSalary;
	}
	
}
