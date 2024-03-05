package com.wannacode.stockmicroservice.repository;

import com.wannacode.stockmicroservice.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
    /*
    * Crearemos un método que nos permita buscar un stock por su código.
    * Donde code es el numero del código del producto.
    **/
    Optional<StockEntity> findByCode(String code);
}
