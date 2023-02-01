package arstansubanov.booking.repository;

import arstansubanov.booking.model.Hall;
import arstansubanov.booking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    public void deleteSeatByHall(Hall hall);
}
