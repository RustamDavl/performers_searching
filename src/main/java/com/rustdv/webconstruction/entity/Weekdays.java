package com.rustdv.webconstruction.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Weekdays {

    private boolean mon;
    private boolean tues;
    private boolean wed;
    private boolean thurs;
    private boolean fri;
    private boolean sat;
    private boolean sun;

}
