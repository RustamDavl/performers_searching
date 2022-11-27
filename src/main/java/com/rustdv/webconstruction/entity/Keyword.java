package com.rustdv.webconstruction.entity;

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
@Builder
@Entity
@Table(name = "keyword")
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private Keywords keyword;


    @Builder.Default
    @OneToMany(mappedBy = "keyword", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Order> orders = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "keyword", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Resume> resumes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Keyword keyword = (Keyword) o;
        return id != null && Objects.equals(id, keyword.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
