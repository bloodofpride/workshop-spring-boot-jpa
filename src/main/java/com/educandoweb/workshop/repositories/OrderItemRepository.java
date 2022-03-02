package com.educandoweb.workshop.repositories;

import com.educandoweb.workshop.entities.OrderItem;
import com.educandoweb.workshop.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
