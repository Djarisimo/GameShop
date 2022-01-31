package com.simeon.GameShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simeon.GameShop.models.Genre;
import com.simeon.GameShop.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	// Return all genres
	public List<Genre> getGenre(){
		return genreRepository.findAll();
	}
	
	// Save genres
	public void save(Genre genre) {
		genreRepository.save(genre);
	}
		
	// Delete genres
	public void deleteGenre(int id) {
		genreRepository.deleteById(id);
	}
}
