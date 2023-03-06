package com.rustdv.webconstruction.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "orders_resume",
uniqueConstraints = @UniqueConstraint(columnNames = {
        "order_id",
        "resume_id"
})
)
public class OrdersResume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Enumerated(EnumType.STRING)
    @Column(name = "resume_status")
    private RespondStatus resumeStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private RespondStatus orderStatus;

    public void addOrder(Order order) {
        this.order = order;
        order.getOrdersResumeList().add(this);
    }

    public void addResume(Resume resume) {
        this.resume = resume;
        resume.getOrdersResumeList().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrdersResume that = (OrdersResume) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
