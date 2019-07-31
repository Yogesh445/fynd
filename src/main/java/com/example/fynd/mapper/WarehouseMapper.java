package com.example.fynd.mapper;

import com.example.fynd.entity.Warehouse;
import com.example.fynd.request.WarehouseRequest;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class WarehouseMapper extends AbstractMapper {
    public WarehouseMapper(DozerBeanMapper mapper) {
        super(mapper);
    }
    public Warehouse getWarehouse(WarehouseRequest warehouseRequest){
        return mapper.map(warehouseRequest, Warehouse.class);
    }

}
