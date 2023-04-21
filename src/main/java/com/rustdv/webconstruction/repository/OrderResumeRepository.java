package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.OrdersResume;
import com.rustdv.webconstruction.entity.RespondStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderResumeRepository extends JpaRepository<OrdersResume, Integer> {

    List<OrdersResume> findAllByOrderId(Integer orderId);

    void deleteAllByOrderIdAndResumeId(Integer orderId, Integer resumeId);

    Optional<OrdersResume> findByOrderIdAndResumeId(Integer orderId, Integer resumeId);

    @Modifying(clearAutomatically = true)
    @Query(value = """
                        update OrdersResume ors
                        set ors.orderStatus = :orderStatus
                        where ors.order.id = :orderId and ors.resume.id = :resumeId
            """)
    Integer updateStatusByOrderIdAndResumeId(@Param("orderId") Integer orderId, @Param("resumeId") Integer resumeId, @Param("orderStatus") RespondStatus orderStatus);

    @Modifying(clearAutomatically = true)
    @Query(value = """
            update OrdersResume ors
            set ors.orderStatus = 'REJECTED'
            where ors.order.id = :orderId and ors.orderStatus = 'TO'
            """)
    void updateStatusesToRejectByOrderId(@Param("orderId") Integer orderId);

    void deleteAllByOrderIdAndOrderStatus(Integer orderId, RespondStatus orderStatus);



}
