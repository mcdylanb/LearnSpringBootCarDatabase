package com.packet.carddatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packet.carddatabase.domain.CarRepository;
import com.packet.carddatabase.domain.Car;

@SpringBootApplication
public class CarddatabaseApplication implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(CarddatabaseApplication.class);
	
	@Autowired
	private CarRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CarddatabaseApplication.class, args);
		
	}
	@Override
	public void run(String...args) throws Exception {
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000));
		for (Car car: repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
		
	}

}
