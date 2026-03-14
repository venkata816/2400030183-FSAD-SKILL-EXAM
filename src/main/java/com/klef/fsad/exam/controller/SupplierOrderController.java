package com.klef.fsad.exam.controller;

import com.klef.fsad.exam.model.SupplierOrder;
import com.klef.fsad.exam.service.SupplierOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class SupplierOrderController {

    private final SupplierOrderService service;

    public SupplierOrderController(SupplierOrderService service) {
        this.service = service;
    }

    // 1. Add SupplierOrder (via POST)
    @PostMapping
    public ResponseEntity<String> addSupplierOrder(@RequestBody SupplierOrder order) {
        try {
            service.addSupplierOrder(order);
            return ResponseEntity.ok("SupplierOrder added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred while adding the order.");
        }
    }

    // 2. Second operation using GET
    @GetMapping
    public ResponseEntity<List<SupplierOrder>> getSupplierOrders() {
        return ResponseEntity.ok(service.getAllSupplierOrders());
    }
}
