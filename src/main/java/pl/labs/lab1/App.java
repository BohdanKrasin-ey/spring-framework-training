package pl.labs.lab1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try(var container = new AnnotationConfigApplicationContext(AppConfig.class);) {
            var orderSevice =  container.getBean(OrderService.class);
            List items = new ArrayList<Item>();
            items.add(new Item("1","Meat",12.9));
            items.add(new Item("2","Milk",2.1));
            items.add(new Item("3","Bread",1.8));

            var order = orderSevice.createOrder(items);

            orderSevice.retrieveOrderInformation(order.getId());
        }

    }
}
