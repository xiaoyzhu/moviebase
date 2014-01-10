package com.vmware.moviebase;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MovieServiceTest {

	@Test
	public void addTwoMovieAndGetTheTotal() {
		// Subject Under Test
		MovieService movieService = new MovieService("VMware Movie Night");
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 2);
	}
	
	@Test
	public void addOneMovieAndGetTheTotal() {
		MovieService movieService = new MovieService("VMware Movie Night");
		movieService.addMovie(new Movie("Enders Game"));
		assertEquals(movieService.getCount(),1);
	}
	
	@Test
	public void getTheTotalWithNoMovies() {
		MovieService movieService = new MovieService("VMware Movie Night");
		assertEquals(movieService.getCount(),0);
	}
	
}
