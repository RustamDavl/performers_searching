package com.rustdv.webconstruction.repository.custom;

import com.rustdv.webconstruction.entity.Order;
import com.rustdv.webconstruction.filter.OrderFilter;

import java.util.List;

public interface OrderFilterRepository {

    List<Order> findAllByFilter(OrderFilter orderFilter);
}
