package pl.labs.lab1;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Item {

    String id;
    String description;
    Double price;
}
