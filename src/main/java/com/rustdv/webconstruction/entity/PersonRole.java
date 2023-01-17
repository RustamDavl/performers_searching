package com.rustdv.webconstruction.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "person_role",
        uniqueConstraints =
        @UniqueConstraint(columnNames={"role_id", "person_id"})
)
public class PersonRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "rating", scale = 1)
    @Builder.Default
    private BigDecimal rating = new BigDecimal("0.0");


    public void addRole(Role role) {
        this.role = role;
        this.role.getPersonRoleList().add(this);

    }

    public void addPerson(Person person) {
        this.person = person;
        this.person.getPersonRoleList().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonRole that = (PersonRole) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
