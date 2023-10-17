package pl.labs.lab1;

import java.util.List;

public interface OrderService {

    Order createOrder(List<Item> items);

    void retrieveOrderInformation(String id);

    Double getOrderPrice(List<Item> items);

}
