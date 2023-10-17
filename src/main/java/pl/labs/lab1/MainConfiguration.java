package pl.labs.lab1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(orderRepository());
    }

    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepositoryImpl();
    }
}
