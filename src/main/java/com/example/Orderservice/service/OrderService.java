package com.example.Orderservice.service;

import com.example.Orderservice.clients.ProductServiceClient;
import com.example.Orderservice.dto.*;
import com.example.Orderservice.entity.Order;
import com.example.Orderservice.entity.OrderItem;
import com.example.Orderservice.enums.OrderStatus;
import com.example.Orderservice.mapper.OrderItemMapper;
import com.example.Orderservice.mapper.OrderMapper;
import com.example.Orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;
    private final ProductServiceClient productClient;


    public OrderService(OrderRepository orderRepository, ProductServiceClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> items = new ArrayList<>();

        for (OrderItemDTO itemDTO : request.getItems()) {
            ProductDTO product = productClient.getProductById(itemDTO.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * itemDTO.getQuantity();

            OrderItem item = OrderItemMapper.toEntity(
                    itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );

            items.add(item);
        }

        order.setItems(items);

        Order createdOrder = orderRepository.save(order);
        return OrderMapper.toCreateOrderResponseDTO(createdOrder);

    }
}
