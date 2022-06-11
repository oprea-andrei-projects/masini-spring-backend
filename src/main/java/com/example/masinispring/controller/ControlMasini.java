package com.example.masinispring.controller;


import com.example.masinispring.model.Masina;
import com.example.masinispring.repository.MasiniRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ControlMasini {

    private MasiniRepository masiniRepository;

    public ControlMasini(MasiniRepository masiniRepository) {
        this.masiniRepository = masiniRepository;
    }


    @GetMapping("/allMasini")
    public List<Masina> getAllMasini(){

        return this.masiniRepository.findAll();
    }

    @PostMapping("/addMasina")
    public Masina addMasina(@RequestBody Masina masina){

        this.masiniRepository.save(masina);

        return masina;
    }

    @PutMapping("/updateTheCar")
    public void updateMasina(@RequestBody Masina m1){

        Masina m = this.masiniRepository.findById(m1.getId()).get();
        m.setBrand(m1.getBrand());
        m.setPrice(m1.getPrice());
        m.setYear(m1.getYear());

        this.masiniRepository.save(m);


    }

    @DeleteMapping("/deleteMasina/{id}")
    public void deleteCar(@PathVariable Long id){

        Masina m = this.masiniRepository.findById(id).get();

        this.masiniRepository.delete(m);

    }

    @GetMapping("/getPropperCarPrice/{min},{max}")
    public List<Masina> propperCarPrice(@PathVariable int min, @PathVariable int max){

        return this.masiniRepository.getMyCars(min,max);

    }

    @GetMapping("/orderCarsAZ")
    public List<Masina> orderedCars(){

        return this.masiniRepository.orderCars();
    }

    @GetMapping("/orderCarsZA")
    public List<Masina> orderCarsZA(){

        return this.masiniRepository.orderZA();
    }

    @GetMapping("/newestCars")
    public List<Masina> newestCars(){

        return this.masiniRepository.orderbyYearNew();
    }


}
