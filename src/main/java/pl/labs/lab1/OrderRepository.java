package pl.labs.lab1;

import pl.training.shop.payments.Payment;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);
    Optional<Order> findById(String id);
}
