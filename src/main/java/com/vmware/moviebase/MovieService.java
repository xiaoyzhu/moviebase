package com.vmware.moviebase;

public class MovieService {
	private int count = 0;
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MovieService(String title) {
		this.title = title;
	}

	public int getCount() {
		
		return count;
	}

	public void addMovie(Movie movie) {
		count++;
	}

	public void removeByName(String name) throws MovieException {
		if (count == 0) {
			throw new MovieException("There are no movies in the service");
		}
		
		count--;
	}
	
}
