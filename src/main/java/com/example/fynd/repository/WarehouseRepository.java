package com.example.fynd.repository;

import com.example.fynd.entity.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {
   public Warehouse getWarehouseByName(String name);
}
