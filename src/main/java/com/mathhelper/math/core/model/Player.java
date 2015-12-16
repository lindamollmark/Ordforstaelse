package com.mathhelper.math.core.model;

public class Player {

	private int id;
	private String name;
	
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
}
