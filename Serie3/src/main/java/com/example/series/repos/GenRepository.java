package com.example.series.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.series.entities.Genre;


@Repository
public interface GenRepository extends JpaRepository<Genre, Long>{

}