package com.example.fynd.services;

import com.example.fynd.entity.Warehouse;
import com.example.fynd.entity.WarehouseItems;
import com.example.fynd.exception.WarehouseDoesNotHaveSpace;
import com.example.fynd.exception.WarehouseNotFoundException;
import com.example.fynd.mapper.WarehouseItemsMapper;
import com.example.fynd.mapper.WarehouseMapper;
import com.example.fynd.repository.WarehouseItemsRepository;
import com.example.fynd.repository.WarehouseRepository;
import com.example.fynd.request.WarehouseItemRequest;
import com.example.fynd.request.WarehouseRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseMapper warehouseMapper;
    @Autowired
    WarehouseItemsMapper warehouseItemsMapper;

    @Autowired
    WarehouseItemsRepository warehouseItemsRepository;

    public Warehouse addWarehouseCapacity(WarehouseRequest request) {
        Warehouse warehouse = warehouseMapper.getWarehouse(request);
        warehouse.setId((long) Math.random() * 1000000000000L);
        return warehouseRepository.save(warehouse);
    }

    public WarehouseItems addItem(WarehouseItemRequest request) throws WarehouseNotFoundException, WarehouseDoesNotHaveSpace {

        Warehouse warehouse = warehouseRepository.getWarehouseByName(request.getWarehouseName());
        if (warehouse == null) {
            String errorMsg = String.format("Warehouse is not present into DB with given Name %s", warehouse.getName());
            throw new WarehouseNotFoundException(errorMsg);
        }
        if (warehouse.getCapacity() == warehouse.getCurrentItems()) {
            String errorMsg = String.format("Warehouse has been completely full %s", warehouse.getName());
            throw new WarehouseDoesNotHaveSpace(errorMsg);
        }
        warehouse.setCurrentItems(warehouse.getCurrentItems() + 1);
        WarehouseItems warehouseItems = warehouseItemsMapper.getWarehouseItems(request);
        warehouseItems.setId(new Random().nextLong());
        warehouseRepository.save(warehouse);
        return warehouseItemsRepository.save(warehouseItems);
    }

}
