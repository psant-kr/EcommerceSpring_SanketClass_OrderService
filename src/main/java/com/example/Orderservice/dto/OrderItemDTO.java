package com.example.Orderservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class OrderItemDTO {
    private Long productId;
    private Long categoryId;
    private int quantity;
}