package com.example.Orderservice.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="orderItems")
public class OrderItem extends BaseEntity{

    private Long productId;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
