package pl.labs.lab1;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log
//@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{


    private final OrderRepository orderRepository;

    @Override
    @StatusCheck
    public Order createOrder(List<Item> items) {
        var totalPrice = getOrderPrice(items);
        var order = Order.builder()
                .id(UUID.randomUUID().toString())
                .totalPrice(totalPrice)
                .items(items)
                .status(Status.COMPLETED)
                .build();
        return orderRepository.save(order);
    }

    @Override
    @MinArgs
    public void retrieveOrderInformation(String id) {
        var order = orderRepository.findById(id).get();
        log.info("Information of  order \"%s\": price - %s, items - %s ,status - %s "
                .formatted(order.getId(),order.getTotalPrice(), order.getItems(), order.getStatus()));
    }

    @MinArgs
    public void retrieveOrderInformation() {
        log.info("Information");
    }

    @Override
    public Double getOrderPrice(List<Item> items) {
        var sum = 0.0;
        for (var el : items) {
            sum = +el.getPrice();
        }
        return sum;
    }
}
