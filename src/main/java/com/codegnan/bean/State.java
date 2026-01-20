package com.codegnan.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stateId;
	private String stateName;
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "state_id") // FK column in Governer table
	private List<Governer> governers = new ArrayList<>();

	public void addGoverner(Governer gov) {
		governers.add(gov);
	}

	public State(String stateName) {
		super();
		this.stateName = stateName;
	}	
}
