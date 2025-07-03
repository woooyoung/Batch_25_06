package com.koreait.exam.batch_25_06.app.order.repository;

import com.koreait.exam.batch_25_06.app.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
