package com.blibli.retryfuturecashier.controller.model.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrderItemRequest {

    private String namaProduk;
    private int kuantitas;
    private int harga;

}
