package com.example.series.service;

import java.util.List;

import com.example.series.entities.Genre;


public interface GenService {

    List <Genre> findAll();
    
    Genre saveGenre(Genre c);
    Genre updateGenre(Genre c);
    void deleteGenre(Genre c);
     void deleteGenreById(Long id);
     Genre getGenre (Long idGen);

}