package com.example.Orderservice.mapper;

import com.example.Orderservice.dto.CreateOrderResponseDTO;
import com.example.Orderservice.entity.Order;

public class OrderMapper {

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order order) {
        return CreateOrderResponseDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }
}
