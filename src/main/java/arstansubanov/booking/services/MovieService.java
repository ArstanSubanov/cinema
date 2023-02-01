package arstansubanov.booking.services;

import arstansubanov.booking.model.Movie;
import arstansubanov.booking.repository.MovieReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MovieService {
    private final MovieReposiory movieReposiory;

    @Autowired
    public MovieService(MovieReposiory movieReposiory) {
        this.movieReposiory = movieReposiory;
    }

    public List<Movie> findAll(){
        return movieReposiory.findAll();
    }

    public List<Movie> findByActiveTrue(){
        return movieReposiory.findByActiveTrue();
    }

    public Movie findMovieById(int id){
        Optional<Movie> movie = movieReposiory.findById(id);
        return movie.orElse(null);
    }

    @Transactional
    public void save(Movie movie){
        movie.setCreatedAt(new Date());
        movie.setActive(true);
        movieReposiory.save(movie);
    }

    @Transactional
    public void update(int id, Movie movie){
        movie.setId(id);
        movie.setCreatedAt(new Date());
        movieReposiory.save(movie);
    }

    @Transactional
    public void delete(int id){
        movieReposiory.deleteById(id);
    }


}
