package com.example.CDWSecurity.model;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

public class Cart {
    private SanPham sanPham;
    private int quantity;

    public Cart(Optional<SanPham> byId, int quantity) {
    }

    public Cart(SanPham sanPham, int quantity) {
        this.sanPham = sanPham;
        this.quantity = quantity;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
