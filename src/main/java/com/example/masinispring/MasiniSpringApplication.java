package com.example.masinispring;

import com.example.masinispring.model.Masina;
import com.example.masinispring.repository.MasiniRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MasiniSpringApplication {


    public static void main(String[] args) {
        SpringApplication.run(MasiniSpringApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(
        MasiniRepository masiniRepository){

            return  args -> {

                masiniRepository.getMyCars(12000,14000).stream().forEach(System.out::println);
            };
    }

}
