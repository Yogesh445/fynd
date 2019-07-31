package com.example.fynd.repository;

import com.example.fynd.entity.WarehouseItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseItemsRepository extends CrudRepository<WarehouseItems,Long> {
}
