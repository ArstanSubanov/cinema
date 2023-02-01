package arstansubanov.booking.repository;

import arstansubanov.booking.model.PriceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceTypeRepository extends JpaRepository<PriceType, Integer> {
}
