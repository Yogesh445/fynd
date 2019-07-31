package com.example.fynd.mapper;

import com.example.fynd.entity.WarehouseItems;
import com.example.fynd.request.WarehouseItemRequest;
import org.dozer.DozerBeanMapper;

public class WarehouseItemsMapper extends AbstractMapper {
    public WarehouseItemsMapper(DozerBeanMapper mapper) {
        super(mapper);
    }
    public WarehouseItems getWarehouseItems(WarehouseItemRequest warehouseItemRequest){
        return mapper.map(warehouseItemRequest,WarehouseItems.class);
    }
}
