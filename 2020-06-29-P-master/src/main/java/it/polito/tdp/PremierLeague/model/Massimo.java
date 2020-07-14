package it.polito.tdp.PremierLeague.model;

public class Massimo {

	private Match m1;
	private Match m2;
	private double peso;
	public Massimo(Match m1, Match m2, double peso) {
		super();
		this.m1 = m1;
		this.m2 = m2;
		this.peso = peso;
	}
	public Match getM1() {
		return m1;
	}
	public Match getM2() {
		return m2;
	}
	public double getPeso() {
		return peso;
	}
	
	
	
}
