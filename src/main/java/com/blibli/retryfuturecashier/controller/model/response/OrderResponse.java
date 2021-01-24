package com.blibli.retryfuturecashier.controller.model.response;

import com.blibli.retryfuturecashier.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class OrderResponse {

    private List<Order> orderResponse;


}
