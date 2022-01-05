package com.alsaecas.Tema789_Ejercicios_Spring;

import com.alsaecas.Tema789_Ejercicios_Spring.entities.Laptop;
import com.alsaecas.Tema789_Ejercicios_Spring.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Tema789EjerciciosSpringApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Tema789EjerciciosSpringApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);


		// CRUD
		// crear laptops
		Laptop laptop1 = new Laptop(null, "Apple", "MacBook Pro", 8, 1.4F, 2500.50, true);
		Laptop laptop2 = new Laptop(null, "MSI", "Prestige", 32, 5.0F, 1250.89, true);

		//save laptops
		repository.save(laptop1);
		repository.save(laptop2);
	}

}
