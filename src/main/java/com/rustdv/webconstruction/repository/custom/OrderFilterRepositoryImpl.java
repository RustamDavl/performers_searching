package com.rustdv.webconstruction.repository.custom;

import com.querydsl.jpa.impl.JPAQuery;
import com.rustdv.webconstruction.entity.Order;
import com.rustdv.webconstruction.entity.OrdersResume;
import com.rustdv.webconstruction.entity.QOrdersResume;
import com.rustdv.webconstruction.filter.OrderFilter;
import com.rustdv.webconstruction.predicate.QPredicate;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

import static com.rustdv.webconstruction.entity.QOrdersResume.ordersResume;

@RequiredArgsConstructor
public class OrderFilterRepositoryImpl implements OrderFilterRepository {

    private final EntityManager entityManager;

    
    @Override
    public List<Order> findAllByFilter(OrderFilter orderFilter) {

//        QPredicate predicate = QPredicate.builder()
//                .add(orderFilter.)

//        return new JPAQuery<OrdersResume>(entityManager)
//                .select(ordersResume)
//                .from(ordersResume)
//                .where()

        return null;

    }
}
