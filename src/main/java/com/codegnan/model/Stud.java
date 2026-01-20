package com.codegnan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="branch")
@Entity
public class Stud {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	private String sname;
	private String city;
	private int marks;
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	public Stud(String sname, String city, int marks, Branch branch) {
		super();
		this.sname = sname;
		this.city = city;
		this.marks = marks;
		this.branch = branch;
	}
	
	
}
