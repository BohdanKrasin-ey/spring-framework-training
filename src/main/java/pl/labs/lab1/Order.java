package pl.labs.lab1;

import lombok.Builder;
import lombok.Value;
import java.util.List;


@Builder
@Value
public class Order {

    String id;
    List<Item> items;
    Double totalPrice;
    Status status;

}
