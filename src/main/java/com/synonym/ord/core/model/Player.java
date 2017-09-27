package com.synonym.ord.core.model;

import java.util.List;

public class Player {

	private int id;
	private String name;
	private List<Result> resultlist;
	
	public Player() {
		super();
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Result> getResult() {
		return resultlist;
	}

	public void setResultList(List<Result> result) {
		resultlist = result;		
	}
}
