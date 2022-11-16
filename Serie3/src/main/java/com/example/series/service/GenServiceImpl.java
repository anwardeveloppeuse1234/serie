package com.example.series.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.series.entities.Genre;
import com.example.series.repos.GenRepository;


@Service
public class GenServiceImpl implements GenService {

    @Autowired
    private GenRepository genRepository;

    @Override
    public List <Genre> findAll() {
        return genRepository.findAll();
    }

	@Override
	public Genre saveGenre(Genre c) {
		return genRepository.save(c);
	}

	@Override
	public Genre updateGenre(Genre c) {
		return genRepository.save(c);
	}

	@Override
	public void deleteGenre(Genre c) {
		genRepository.delete(c);
	}

	@Override
	public void deleteGenreById(Long idGen) {
		genRepository.deleteById(idGen);
	}

	@Override
	public Genre getGenre(Long idGen) {
		return genRepository.findById(idGen).get();
	}

   
}