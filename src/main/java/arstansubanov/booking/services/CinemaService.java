package arstansubanov.booking.services;

import arstansubanov.booking.model.Cinema;
import arstansubanov.booking.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Cinema> findAll(){
        return cinemaRepository.findAll();
    }

    public Cinema findCinemaById(int id){
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        return cinema.orElse(null);
    }

    @Transactional
    public void save(Cinema cinema){
        cinema.setCreatedAt(new Date());
        cinemaRepository.save(cinema);
    }

    @Transactional
    public void update(int id, Cinema cinema){
        cinema.setId(id);
        cinemaRepository.save(cinema);
    }

    @Transactional
    public void delete(int id){
        cinemaRepository.deleteById(id);
    }


}
