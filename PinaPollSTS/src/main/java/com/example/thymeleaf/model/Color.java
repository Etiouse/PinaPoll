package com.example.thymeleaf.model;

import org.springframework.stereotype.Component;

@Component
public class Color {
	private int r;
	private int g;
	private int b;
	private int a;
	public String rString;
	public String gString;
	public String bString;
	public String aString;
	
	public Color(int r, int g, int b, int a) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		rString = "Rouge";
		gString = "Vert";
		bString = "Bleu";
		aString = "Alpha";
	}
	
	public Color() {
		
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}
