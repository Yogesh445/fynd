package com.example.fynd.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseItemRequest {
    String warehouseName;
    String itemName;
    String itemColor;

}
