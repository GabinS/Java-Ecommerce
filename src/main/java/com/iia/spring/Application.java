package com.iia.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iia.spring.entity.Customer;
import com.iia.spring.entity.MyOrder;
import com.iia.spring.entity.OrderProduct;
import com.iia.spring.entity.Product;
import com.iia.spring.entity.State;
import com.iia.spring.repository.CustomerRepository;
import com.iia.spring.repository.OrderRepository;
import com.iia.spring.repository.OrderProductRepository;
import com.iia.spring.repository.ProductRepository;

/**
 * Main application
 * @author gabz9
 *
 */
@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
		
	}
	
	@Bean
	public CommandLineRunner demoCustomer(CustomerRepository customerRepository, ProductRepository productRepository, OrderRepository orderRepository, OrderProductRepository orderproductRepository) {
		return (args) -> {	
			
			/**
			 * Delete all repository
			 */
			customerRepository.deleteAll();
			orderproductRepository.deleteAll();
			productRepository.deleteAll();
			orderRepository.deleteAll();			
			
			/**
			 * Create Customer
			 */
			Customer c1 = new Customer("Gabin", "Soutif", "01", 53700, "MyCity", null);
			Customer c2 = new Customer("Harry", "Covert", "02", 53, "City", null);
			Customer c3 = new Customer("Jean", "Neymar", "03", 53, "City", null);
			Customer c4 = new Customer("Anna", "Conda", "04", 53, "City", null);
			Customer c5 = new Customer("Alex", "Terieur", "05", 53, "City", null);
			
			/**
			 * Insert Customer
			 */
			customerRepository.save(c1);
			customerRepository.save(c2);
			customerRepository.save(c3);
			customerRepository.save(c4);
			customerRepository.save(c5);
			
			/**
			 * Fetch all customers
			 */
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
			
			/**
			 * Create Product
			 */
			Product p1 = new Product("CocaCola", "Boisson petillante", 7, false, 2);
			Product p2 = new Product("Pizza", "Mmmmmmmmm", 5, false, 15.15f);
			Product p3 = new Product("PC", "Tu sais a quoi ca sert", 1, false, 779.99f);
			Product p4 = new Product("Baguette de pain", "C'est juste du pain", 1, false,0.50f);
			Product p5 = new Product("Pack de feuille blanche", "Pour faire de beau dessin", 1, false, 3);
			
			/**
			 * Insert Product
			 */
			productRepository.save(p1);
			productRepository.save(p2);
			productRepository.save(p3);
			productRepository.save(p4);
			productRepository.save(p5);
			
			/**
			 *  Fetch all products
			 */
			log.info("Product found with findAll():");
			log.info("-----------------------------");
			for (Product product : productRepository.findAll()) {
				log.info(product.toString());
			}
			log.info("");
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");			
			String dateStr = simpleDateFormat.format(new Date());
			Date date = simpleDateFormat.parse(dateStr);
			
			/**
			 * Create Order
			 */
			MyOrder o1 = new MyOrder(date, State.Current, 15.2f);
			o1.setCustomer(c1);
			MyOrder o2 = new MyOrder(date, State.Draft, 35.62f);
			o2.setCustomer(c3);
			MyOrder o3 = new MyOrder(date, State.Close, 20.13f);
			o3.setCustomer(c1);
			
			/**
			 * Insert Order
			 */
			orderRepository.save(o1);
			orderRepository.save(o2);
			orderRepository.save(o3);
			
			/**
			 * fetch all order
			 */
			log.info("Order found with findAll():");
			log.info("-----------------------------");
			for (MyOrder order : orderRepository.findAll()) {
				log.info(order.toString());
			}
			log.info("");
			
			/**
			 * Create OrderProduct
			 */
			OrderProduct op1 = new OrderProduct(o1, p1);
			OrderProduct op2 = new OrderProduct(o1, p2);
			OrderProduct op3 = new OrderProduct(o2, p3);
			OrderProduct op4 = new OrderProduct(o3, p3);
			
			/**
			 * Insert OrderProduct
			 */
			orderproductRepository.save(op1);
			orderproductRepository.save(op2);
			orderproductRepository.save(op3);
			orderproductRepository.save(op4);
			
			/**
			 * Fetch all OrderProduct
			 */
			log.info("OrderProduct found with findAll():");
			log.info("----------------------------------");
			for (OrderProduct orderProduct : orderproductRepository.findAll()) {
				log.info(orderProduct.toString());
			}
			log.info("");
			
		};
	}

}
