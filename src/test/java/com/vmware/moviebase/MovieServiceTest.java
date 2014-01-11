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
	public void setAndGetMoveServiceTitle() {
		movieService.setTitle("New Movie Service");
		assertEquals(movieService.getTitle(), "New Movie Service");
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
	public void removeAMovieAndGetTheTotal() throws MovieException {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		movieService.removeByName("Wall-E");
		assertEquals(movieService.getCount(), 1);
	}
	
	@Test()
	public void removeAMovieFromAnEmptyService() {
		try {
			movieService.removeByName("Wall-E");
			fail("No movies yet, expecting an exception");
		} catch (MovieException e) {
			assertEquals(e.getMessage(), "There are no movies in the service");
		}
	}
	
	@Test
	public void removeAMovieThatDoesntExist() {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		try {
			movieService.removeByName("Wall-E");
			fail("Movie doesn't exist, excepting an exception");
		} catch (MovieException e) {
			assertEquals(e.getMessage(), "This movie does not exist in the service");
		}
	}
	
	@Test
	public void testShowMovieService() {
		assertFalse(movieService.showMovieList());
		
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		assertTrue(movieService.showMovieList());
	}
}
