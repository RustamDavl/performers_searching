package com.rustdv.webconstruction.entity;

import liquibase.repackaged.org.apache.commons.lang3.builder.EqualsExclude;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    private String email;

    private String password;

    private String photo;

    @Builder.Default
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Resume> resumes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<PersonRole> personRoleList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Order> orders = new ArrayList<>();

    @Column(name = "personal_info")
    private String personalInfo;


    @OneToMany(mappedBy = "recipientId")
    @Builder.Default
    @ToString.Exclude
    private List<Comment> receivedComments = new ArrayList<>();


    @OneToMany(mappedBy = "senderId")
    @Builder.Default
    @ToString.Exclude
    private List<Comment> sentComments = new ArrayList<>();




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return id != null && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
