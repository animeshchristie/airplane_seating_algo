package com.challenge.algo;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SeatArragementAlgorithmTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void arrangePassengers_WithTotalPassengersMoreThanSeats_ThrowsException() {
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Invalid value for total passengers");
		
		int[][] input = {{3,2}, {4,3}, {2,3}, {3,4}};
		
		SeatArragementAlgorithm a = new SeatArragementAlgorithm(input);
		a.arrangePassengers(60);
	}
	
	@Test
	public void arrangePassengers_WithGivenDefination_ReturnsOutput() {
		Integer[][] firstBlock = {{19, 25, 1}, {21, 29, 7}};
		Integer[][] secondBlock = {{2, 26, 27, 3}, {8, 30, null, 9}, {13, null, null, 14}};
		Integer[][] thirdBlock = {{4, 5}, {10, 11}, {15, 16}};
		Integer[][] fourthBlock = {{6, 28, 20}, {12, null, 22}, {17, null, 23}, {18, null, 24}};
		
		int[][] input = {{3,2}, {4,3}, {2,3}, {3,4}};
		
		SeatArragementAlgorithm a = new SeatArragementAlgorithm(input);
		List<Integer[][]> output = a.arrangePassengers(30);
		
		assertThat(output, hasSize(4));
		assertThat(output.get(0), is(firstBlock));
		assertThat(output.get(1), is(secondBlock));
		assertThat(output.get(2), is(thirdBlock));
		assertThat(output.get(3), is(fourthBlock));
	}
	
	@Test
	public void arrangePassengers_WithOneBlock_ReturnsOutput() {
		Integer[][] firstBlock = {{1, 5, 2}, {3, null, 4}};
		
		int[][] input = {{3,2}};
		
		SeatArragementAlgorithm a = new SeatArragementAlgorithm(input);
		List<Integer[][]> output = a.arrangePassengers(5);
		
		assertThat(output, hasSize(1));
		assertThat(output.get(0), is(firstBlock));
	}
	
	@Test
	public void arrangePassengers_WithTwoBlock_ReturnsOutput() {
		Integer[][] firstBlock = {{6, 11, 1}, {8, 14, 3}};
		Integer[][] secondBlock = {{2, 12, 13, 7}, {4, 15, null, 9}, {5, null, null, 10}};
		
		int[][] input = {{3,2}, {4,3}};
		
		SeatArragementAlgorithm a = new SeatArragementAlgorithm(input);
		List<Integer[][]> output = a.arrangePassengers(15);
		
		assertThat(output, hasSize(2));
		assertThat(output.get(0), is(firstBlock));
		assertThat(output.get(1), is(secondBlock));
	}
}
