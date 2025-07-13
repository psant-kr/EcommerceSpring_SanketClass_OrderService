package com.example.Orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orderItems")
public class OrderItem extends BaseEntity{

    private Long productId;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

}
