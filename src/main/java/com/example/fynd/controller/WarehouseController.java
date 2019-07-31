package com.example.fynd.controller;

import com.example.fynd.exception.WarehouseDoesNotHaveSpace;
import com.example.fynd.exception.WarehouseNotFoundException;
import com.example.fynd.request.WarehouseItemRequest;
import com.example.fynd.request.WarehouseRequest;
import com.example.fynd.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    final WarehouseService warehouseService;

    @RequestMapping(method = RequestMethod.POST, value = "/addCapacity")
    public ResponseEntity<?> addCapacity(@RequestBody WarehouseRequest warehouseRequest) {
        return new ResponseEntity<>(this.warehouseService.addWarehouseCapacity(warehouseRequest), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/addItem")
    public ResponseEntity<?> addItem(@RequestBody WarehouseItemRequest warehouseItemRequest) throws WarehouseDoesNotHaveSpace, WarehouseNotFoundException {
        return new ResponseEntity<>(this.warehouseService.addItem(warehouseItemRequest), HttpStatus.OK);
    }

}
