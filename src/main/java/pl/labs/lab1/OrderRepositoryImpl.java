package pl.labs.lab1;

import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.training.shop.payments.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@Component
public class OrderRepositoryImpl implements OrderRepository{

    @Setter
    private Map<String, Order> orders = new HashMap<>();

    @Override
    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orders.get(id));
    }

}
