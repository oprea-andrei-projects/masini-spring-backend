package com.example.masinispring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="masini")
@Data
@NoArgsConstructor
public class Masina implements Comparable<Masina> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;
    private int year;
    private int price;

    public Masina(String brand, int year, int price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    @Override
    public int compareTo(Masina o) {
        return this.price-o.price;
    }
}
