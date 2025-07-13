package com.example.Orderservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long OrderId;
    private Long userId;
    private List<OrderItemDTO> items;



}
