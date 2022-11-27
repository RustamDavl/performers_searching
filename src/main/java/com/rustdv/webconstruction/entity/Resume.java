package com.rustdv.webconstruction.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

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
@Entity
@Builder
@Table(name = "resume",
        uniqueConstraints = @UniqueConstraint(columnNames =
                {"person_id",
                        "keyword_id",
                        "measurement_id"})
)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    @ManyToOne
    @JoinColumn(name = "measurement_id")
    private Measurement measurement;

    private Integer price;

    @Embedded
    private Weekdays weekdays;

    @Column(name = "start_at")
    private LocalTime startAt;

    @Column(name = "end_at")
    private LocalTime endAt;

    @Enumerated(EnumType.STRING)
    private Experience experience;

    @Embedded
    @AttributeOverride(name = "houseNumber", column = @Column(name = "house_number"))
    private Address address;

    @Builder.Default
    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PhotoForResume> photos = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OrdersResume> ordersResumeList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Team team;

    @Column(name = "about_me")
    private String aboutMe;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Resume resume = (Resume) o;
        return id != null && Objects.equals(id, resume.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
