package com.wannacode.stockmicroservice.controller;

import com.wannacode.stockmicroservice.entity.StockEntity;
import com.wannacode.stockmicroservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    public boolean stockAvailable(@PathVariable String code) {
        // Creamos una variable para el resultado del método findByCode
        Optional<StockEntity> stock = stockRepository.findByCode(code);
        // Si el resultado no se encuentra
        stock.orElseThrow(() -> new RuntimeException("Cannot find the product" + code));
        // Si la cantidad del stock es mayor a 0 retorna true
        return stock.get().getQuantity() > 0;
    }
}
