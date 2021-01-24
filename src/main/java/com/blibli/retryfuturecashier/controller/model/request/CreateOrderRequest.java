package com.blibli.retryfuturecashier.controller.model.request;

import com.blibli.retryfuturecashier.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CreateOrderRequest {

    private Customer customer;
    private List<CreateOrderItemRequest> orderItems;

}
