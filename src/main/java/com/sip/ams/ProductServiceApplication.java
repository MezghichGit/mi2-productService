package com.sip.ams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.sip.ams.entities.Produit;
import com.sip.ams.repositories.ProduitRepository;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication implements CommandLineRunner{

	@Autowired
	ProduitRepository produitRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	List<Produit> produits = Arrays.asList(
			new Produit(null,"Samsung A31",900),
			new Produit(null,"Samsung A51",1400),
			new Produit(null,"Samsung A71",1600)
			);
		Stream<Produit> stream = produits.stream();
		stream.forEach(produit ->  produitRepository.save(produit));
		
		produitRepository.findAll().forEach(System.out::println);
	}

}
