package com.challenge.seats;

import java.util.Set;

public abstract class Seats {
	
	private int startNumber;
	
	protected int[][] input;
	protected int totalCols;
	
	protected int totalSeats;
	protected Set<Integer> seatCols;
	
	public Seats(int[][] input, int totalCols) {
		super();
		this.input = input;
		this.totalCols = totalCols;
		
		init();
	}

	private void init() {
		setSeatCols();
		setTotalSeats();
	}
	
	public boolean isSeatCols(int col) {
		return seatCols.contains(col);
	}
	
	public Integer getNextColNumber(int totalPassengers) {
		if (startNumber <= totalPassengers) {
			return startNumber++;
		}
		return null;
	}
	
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	public Set<Integer> getSeatCols() {
		return seatCols;
	}

	public abstract void setSeatCols();
	
	public abstract void setTotalSeats();
}
