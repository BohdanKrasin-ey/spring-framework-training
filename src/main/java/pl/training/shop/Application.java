package pl.training.shop;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.Before;
import org.javamoney.moneta.Money;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.training.shop.payments.PaymentRequest;
import pl.training.shop.payments.PaymentService;

@Log
public class Application {

    private static final String DEFAULT_CURRENCY_CODE = "PLN";



    public static void main(String[] args) {
        try (var container = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var paymentService = container.getBean(PaymentService.class);
            var paymentRequest = new PaymentRequest(1L, Money.of(1_000, DEFAULT_CURRENCY_CODE));
            var payment = paymentService.process(paymentRequest);
            var id = payment.getId();
            log.info(paymentService.getById(id).toString());
            log.info(paymentService.getById(id).toString());
            //log.info(paymentService.getById("123").toString());
        }
    }

}
