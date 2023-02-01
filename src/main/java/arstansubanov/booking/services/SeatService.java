package arstansubanov.booking.services;

import arstansubanov.booking.model.Hall;
import arstansubanov.booking.model.Seat;
import arstansubanov.booking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> findAll(){
        return seatRepository.findAll();
    }

    public Seat findSeatById(int id){
        Optional<Seat> seat = seatRepository.findById(id);
        return seat.orElse(null);
    }

    @Transactional
    public void save(List<Seat> seats){
        seatRepository.saveAll(seats);
    }

    @Transactional
    public void update(int id, Seat seat){
        seat.setId(id);
        seatRepository.save(seat);
    }

    @Transactional
    public void delete(int id){
        seatRepository.deleteById(id);
    }

    @Transactional
    public void deleteByHall(Hall hall){
        seatRepository.deleteSeatByHall(hall);
    }
}
