package com.vmware.moviebase;

//import java.util.ArrayList;
//import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class MovieService {
	private String title;
	private Set<String> movies;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MovieService(String title) {
		this.title = title;
		movies = new HashSet<String>();
	}

	public int getCount() {
		return movies.size();
	}

	public void addMovie(Movie movie) {
		movies.add(movie.getName());
	}

	public void removeByName(String name) throws MovieException {
		if (movies.isEmpty()) {
			throw new MovieException("There are no movies in the service");
		}
		
		// for (Movie movie : movieList)
//		Iterator<String> it = movies.iterator();
//		while (it.hasNext()) {
//			String movieName = it.next();
//			if (movieName.equals(name)) {
//				it.remove();
//				return;
//			}
//		}

		if (!movies.remove(name)) {
			throw new MovieException("This movie does not exist in the service");			
		}
	}
	
	public boolean showMovieList() {
		System.out.println("\nMovie Service: " + title);
		
		if (movies.isEmpty()) {
			System.out.println("There are no movies currently.");
			return false;
		}
		
		for (String movieName : movies) {
			System.out.println(movieName);
		}
		return true;
	}
}
