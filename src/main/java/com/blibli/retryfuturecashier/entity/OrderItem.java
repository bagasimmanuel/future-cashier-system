package com.blibli.retryfuturecashier.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderItem {

    private int id;
    private String namaProduk;
    private int kuantitas;
    private int harga;

}
