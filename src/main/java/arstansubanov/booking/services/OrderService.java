package arstansubanov.booking.services;

import arstansubanov.booking.model.Order;
import arstansubanov.booking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findOrderById(int id){
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    @Transactional
    public void save(Order order){
        order.setCreatedAt(new Date());
        orderRepository.save(order);
    }
    @Transactional
    public void update(int id, Order order){
        order.setId(id);
        orderRepository.save(order);
    }

    public void delete(int id){
        orderRepository.deleteById(id);
    }
}
