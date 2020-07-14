package it.polito.tdp.PremierLeague.model;

public class Adiacenza {
	
	private int id1;
	private int id2;
	private double peso;
	
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public Adiacenza(int id1, int id2, double peso) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.peso = peso;
	}

}
