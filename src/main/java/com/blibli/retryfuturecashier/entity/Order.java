package com.blibli.retryfuturecashier.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Order {

    private int id;
    private int totalHarga;
    private Customer customer;
    private List<OrderItem> orderItems;

}
