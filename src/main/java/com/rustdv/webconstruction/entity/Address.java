package com.rustdv.webconstruction.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Setter
@Getter
@Embeddable
public class Address {

    private String city;

    private String street;

    private String houseNumber;


}
