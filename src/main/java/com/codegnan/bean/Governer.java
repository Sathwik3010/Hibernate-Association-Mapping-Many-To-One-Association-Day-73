package com.codegnan.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Governer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int govId;
	private String govName;
	private double govSalary;
	
	public Governer(String govName, double govSalary) {
		super();
		this.govName = govName;
		this.govSalary = govSalary;
	}
}
