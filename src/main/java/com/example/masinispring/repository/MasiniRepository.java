package com.example.masinispring.repository;

import com.example.masinispring.model.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MasiniRepository extends JpaRepository<Masina, Long> {

    @Query("select m from Masina m where m.price > ?1 and m.price < ?2")
    public List<Masina> getMyCars(int price1, int price2);

    @Query("select m from Masina m order by m.brand")
    public List<Masina> orderCars();

    @Query("select m from Masina m order by m.year desc ")
    public List<Masina> orderbyYearNew();

    @Query("select m from Masina m order by m.price desc ")
    public List<Masina> orderZA();

}
