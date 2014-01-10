package com.vmware.moviebase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MovieServiceTest {

	private MovieService movieService;
	
	@BeforeMethod
	public void setUp() {
		movieService = new MovieService("VMware Movie Night");
	}
	
	@Test
	public void addTwoMovieAndGetTheTotal() {
		// Subject Under Test
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 2);
	}
	
	@Test
	public void addOneMovieAndGetTheTotal() {
		movieService.addMovie(new Movie("Enders Game"));
		assertEquals(movieService.getCount(),1);
	}
	
	@Test
	public void getTheTotalWithNoMovies() {
		assertEquals(movieService.getCount(),0);
	}
	
	@Test
	public void removeAMovieAndGetTheTotal() {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		movieService.removeByName("Wall-E");
		assertEquals(movieService.getCount(), 1);
	}
	
	@Test
	public void removeAMovieFromAnEmptyService() {
		
	}
	
	@Test
	public void removeAMovieThatDoesntExist() {
		
	}
	
}
