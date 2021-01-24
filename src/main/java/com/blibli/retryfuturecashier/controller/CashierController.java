package com.blibli.retryfuturecashier.controller;

import com.blibli.retryfuturecashier.controller.model.request.CreateOrderRequest;
import com.blibli.retryfuturecashier.controller.model.response.OrderResponse;
import com.blibli.retryfuturecashier.entity.Order;
import com.blibli.retryfuturecashier.service.impl.CashierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CashierController {

    @Autowired
    private CashierServiceImpl cashierService;

    @GetMapping(value="/orders/{id}")
    public Order getOrderById(@PathVariable int id){
        return cashierService.getOrderById(id);
    }

    @GetMapping(value="/orders")
    public OrderResponse getOrderResponse(
            @RequestParam(value = "orderByName", defaultValue = "false") String orderByName,
            @RequestParam(value = "orderByPrice", defaultValue = "false") String orderByPrice
    ){
        return cashierService.getOrderResponse(orderByName .equals("true"), orderByPrice.equals("true"));
    }


    @PostMapping(value = "/orders")
    public Order createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        return cashierService.createOrder(createOrderRequest);
    }






}
