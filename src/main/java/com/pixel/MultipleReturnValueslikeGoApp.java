package com.pixel;

import com.pixel.model.Order;
import com.pixel.model.PaymentDetails;
import com.pixel.model.ShippingDetails;
import com.pixel.service.OrderService;
import com.pixel.service.PaymentService;
import com.pixel.service.UserProfileService;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MultipleReturnValueslikeGoApp {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private PaymentService paymentService;

	public static void main(String[] args) {
		SpringApplication.run(MultipleReturnValueslikeGoApp.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Pair<Order, ShippingDetails> orderAndShippingDetails = getOrderAndShippingDetails("1234");
			System.out.println(orderAndShippingDetails.getLeft());
			System.out.println(orderAndShippingDetails.getRight());
			System.out.println("***********************************************************");
			Triple<Order,ShippingDetails, PaymentDetails> orderAndShippingAndPaymentDetails = getOrderAndShippingAndPaymentDetails("1234");
			System.out.println(orderAndShippingAndPaymentDetails.getLeft());
			System.out.println(orderAndShippingAndPaymentDetails.getMiddle());
			System.out.println(orderAndShippingAndPaymentDetails.getRight());
		};
	}

	public Pair<Order, ShippingDetails> getOrderAndShippingDetails(String orderId) {
		return Pair.of(orderService.getOrder(orderId), userProfileService.getShippingDetails("John"));
	}
	public Triple<Order,ShippingDetails, PaymentDetails> getOrderAndShippingAndPaymentDetails(String orderId) {
		return Triple.of(orderService.getOrder(orderId), userProfileService.getShippingDetails("John"), paymentService.getPaymentDetails("1234"));
	}

}
