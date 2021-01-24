package com.blibli.retryfuturecashier.service;

import com.blibli.retryfuturecashier.controller.model.request.CreateOrderRequest;
import com.blibli.retryfuturecashier.controller.model.response.OrderResponse;
import com.blibli.retryfuturecashier.entity.Order;

public interface CashierService {

    public Order createOrder(CreateOrderRequest createOrderRequest);
    public Order getOrderById(int id);
    public OrderResponse getOrderResponse(boolean byName,boolean byPrice);

}
