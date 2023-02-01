package arstansubanov.booking.repository;

import arstansubanov.booking.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}
