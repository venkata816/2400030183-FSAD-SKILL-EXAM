package com.klef.fsad.exam.service;

import com.klef.fsad.exam.model.SupplierOrder;
import com.klef.fsad.exam.repository.SupplierOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierOrderService {
    
    private final SupplierOrderRepository repository;

    public SupplierOrderService(SupplierOrderRepository repository) {
        this.repository = repository;
    }

    public SupplierOrder addSupplierOrder(SupplierOrder order) {
        if (order.getId() == null) {
            throw new IllegalArgumentException("SupplierOrder ID MUST be provided manually and must not be null.");
        }
        return repository.save(order);
    }

    public List<SupplierOrder> getAllSupplierOrders() {
        return repository.findAll();
    }
}
