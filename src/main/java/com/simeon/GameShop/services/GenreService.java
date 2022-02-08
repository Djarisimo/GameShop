package com.simeon.GameShop.services;

import com.simeon.GameShop.models.Genre;
import com.simeon.GameShop.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public void addEditGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }
}
