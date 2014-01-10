package com.vmware.moviebase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieService {
	private int count = 0;
	private String title;
	
	private List<Movie> movieList;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MovieService(String title) {
		this.title = title;
		movieList = new ArrayList<Movie>();
	}

	public int getCount() {
		
		return count;
	}

	public void addMovie(Movie movie) {
		movieList.add(movie);
		count++;
	}

	public void removeByName(String name) throws MovieException {
		if (count == 0 || movieList.isEmpty()) {
			throw new MovieException("There are no movies in the service");
		}
		
		// for (Movie m : movieList)
		Iterator<Movie> it = movieList.iterator();
		while (it.hasNext()) {
			Movie movie = it.next();
			if (movie.getName().equals(name)) {
				it.remove();
				count--;
				return;
			}
		}

		throw new MovieException("This movie does not exist in the service");
	}
	
}
