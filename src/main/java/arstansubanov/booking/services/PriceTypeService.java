package arstansubanov.booking.services;

import arstansubanov.booking.model.PriceType;
import arstansubanov.booking.repository.PriceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PriceTypeService {

    private final PriceTypeRepository priceTypeRepository;

    @Autowired
    public PriceTypeService(PriceTypeRepository priceTypeRepository) {
        this.priceTypeRepository = priceTypeRepository;
    }

    public List<PriceType> findAll(){
        return priceTypeRepository.findAll();
    }

    public PriceType findPriceTypeById(int id){
        Optional<PriceType> priceType = priceTypeRepository.findById(id);
        return priceType.orElse(null);
    }

    @Transactional
    public void save(PriceType priceType){
        priceTypeRepository.save(priceType);
    }

    @Transactional
    public void update(int id, PriceType priceType){
        priceType.setId(id);
        priceTypeRepository.save(priceType);
    }

    @Transactional
    public void delete(int id){
        priceTypeRepository.deleteById(id);
    }
}
