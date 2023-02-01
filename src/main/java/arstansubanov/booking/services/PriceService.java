package arstansubanov.booking.services;

import arstansubanov.booking.model.Price;
import arstansubanov.booking.model.PriceType;
import arstansubanov.booking.model.MovieSession;
import arstansubanov.booking.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price findPriceById(int id){
        Optional<Price> price = priceRepository.findById(id);
        return price.orElse(null);
    }
    @Transactional
    public void save(Price price, MovieSession movieSession, PriceType priceType){
        price.setMovieSession(movieSession);
        price.setPriceType(priceType);
        price.setCreatedAt(new Date());

        priceRepository.save(price);
    }
    @Transactional
    public void update(int id, Price price){
        price.setId(id);
        priceRepository.save(price);
    }
    @Transactional
    public void delete(int id){
        priceRepository.deleteById(id);
    }


}
