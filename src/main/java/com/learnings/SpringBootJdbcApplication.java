package com.learnings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.learnings.entity.Alien;
import com.learnings.repository.AlienRepository;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(1);
		alien1.setName("ram");
		alien1.setTech("Spring boot");
		
		AlienRepository arepo = context.getBean(AlienRepository.class);
		arepo.save(alien1);
		System.out.println(arepo.getAllAliens());
	}

}
