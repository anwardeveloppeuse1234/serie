package com.example.series.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.series.entities.Genre;
import com.example.series.entities.Serie;
public interface SerieService {
Serie saveSerie(Serie s);
Serie updateSerie(Serie s);
void deleteSerie(Serie s);
 void deleteSerieById(Long id);
Serie getSerie(Long id);
List<Serie> getAllSeries();
Page<Serie> getAllSeriesParPage(int page, int size);
List<Serie> findByNomSerie(String nom);
List<Serie> findByNomSerieContains(String nom);
List<Serie> findByNomPrix (String nom, Double prix);
List<Serie> findByGenre (Genre genre);
List<Serie> findByGenreIdGen(Long id);
List<Serie> findByOrderByNomSerieAsc();
List<Serie> trierSeriesNomsPrix();
}