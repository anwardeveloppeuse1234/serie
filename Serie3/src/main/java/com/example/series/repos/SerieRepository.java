package com.example.series.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.series.entities.Genre;
import com.example.series.entities.Serie;
@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
	List<Serie> findByNomSerie(String nom);
	 List<Serie> findByNomSerieContains(String nom);
	 @Query("select s from Serie s where s.nomSerie like %:nom and s.prixSerie > :prix")
	 List<Serie> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select s from Serie s where s.genre= ?1")
	 List<Serie> findByGenre (Genre genre);
	 List<Serie> findByGenreIdGen(Long id);
	 List<Serie> findByOrderByNomSerieAsc();
	 @Query("select s from Serie s order by s.nomSerie ASC, s.prixSerie DESC")
	 List<Serie> trierSeriesNomsPrix();
}