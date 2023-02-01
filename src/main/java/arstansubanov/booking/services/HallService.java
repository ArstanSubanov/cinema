package arstansubanov.booking.services;

import arstansubanov.booking.model.Hall;
import arstansubanov.booking.model.Seat;
import arstansubanov.booking.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HallService {

    private final HallRepository hallRepository;
    private final SeatService seatService;

    @Autowired
    public HallService(HallRepository hallRepository, SeatService seatService) {
        this.hallRepository = hallRepository;
        this.seatService = seatService;
    }

    public List<Hall> findAll() {
        return hallRepository.findAll();
    }

    public Hall findHallById(int id) {
        Optional<Hall> hall = hallRepository.findById(id);
        return hall.orElse(null);
    }

    @Transactional
    public void save(Hall hall) {
        hall.setCreatedAt(new Date());
        hallRepository.save(addSeats(hall));
    }

    @Transactional
    public void update(int id, Hall hall){
        hall.setId(id);
        hall.setCreatedAt(new Date());
        seatService.deleteByHall(hall);
        hallRepository.save(addSeats(hall));
    }

    public void delete(int id){
        hallRepository.deleteById(id);
    }



    private Hall addSeats(Hall hall) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= hall.getSeatRows(); i++)
            for (int j = 1; j <= hall.getPlaceNumbers(); j++) {
                Seat seat = new Seat();
                seat.setSeatRow(i);
                seat.setPlaceNumber(j);
                seat.setHall(hall);
                seat.setCreatedAt(new Date());
                seats.add(seat);
            }
        seatService.save(seats);
        hall.setSeats(seats);
        return hall;
    }
}
