package com.rustdv.webconstruction.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @AttributeOverride(name = "houseNumber", column = @Column(name = "house_number"))
    private Address address;

    private String description;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrdersResume> ordersResumeList = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<PhotoForOrder> photos = new ArrayList<>();


    @Column(name = "start_at")
    private LocalTime startAt;

    @Column(name = "end_at")
    private LocalTime endAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
