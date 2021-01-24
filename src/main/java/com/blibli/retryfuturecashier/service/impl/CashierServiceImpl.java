package com.blibli.retryfuturecashier.service.impl;

import com.blibli.retryfuturecashier.controller.model.request.CreateOrderItemRequest;
import com.blibli.retryfuturecashier.controller.model.request.CreateOrderRequest;
import com.blibli.retryfuturecashier.controller.model.response.OrderResponse;
import com.blibli.retryfuturecashier.entity.Order;
import com.blibli.retryfuturecashier.entity.OrderItem;
import com.blibli.retryfuturecashier.service.CashierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    private List<Order> orderList = new ArrayList<>();

    private int id = 0;

    @Override
    public Order createOrder(CreateOrderRequest createOrderRequest) {
        List<OrderItem> orderItemList = new ArrayList<>();

        int total = 0;
        int orderItemId = 0;
        for(CreateOrderItemRequest createOrderItemRequest : createOrderRequest.getOrderItems()){
            total += createOrderItemRequest.getHarga() * createOrderItemRequest.getKuantitas();
            orderItemList.add(
                    OrderItem.builder()
                            .id(orderItemId++)
                            .harga(createOrderItemRequest.getHarga())
                            .namaProduk(createOrderItemRequest.getNamaProduk())
                            .kuantitas(createOrderItemRequest.getKuantitas())
                            .build()
            );
        }

        Order order = Order.builder()
                .id(id++)
                .orderItems(orderItemList)
                .customer(createOrderRequest.getCustomer())
                .totalHarga(total)
                .build();

        orderList.add(order);

        return order;
    }

    @Override
    public Order getOrderById(int id) {
       return orderList.get(id);
    }

    @Override
    public OrderResponse getOrderResponse(boolean byName, boolean byPrice) {
        List<Order> list = new ArrayList<>(orderList);
        if(byName){
            list.sort(Comparator.comparing(a -> a.getCustomer().getNama()));
        }else if(byPrice){
            list.sort((a,b) -> b.getTotalHarga() - a.getTotalHarga());
        }
        return  new OrderResponse(list);
    }
}
