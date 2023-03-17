package com.springbootacademy.pointofsale.repo;

import com.springbootacademy.pointofsale.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Integer> {
}
