package arstansubanov.booking.repository;

import arstansubanov.booking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieReposiory extends JpaRepository<Movie, Integer> {
    List<Movie> findByActiveTrue();
}
