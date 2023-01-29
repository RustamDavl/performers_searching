package com.rustdv.webconstruction.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;


@Data
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

    public Weekdays(Boolean mon, Boolean tues, Boolean wed, Boolean thurs, Boolean fri, Boolean sat, Boolean sun) {
        this.mon = Objects.requireNonNullElse(mon, false);
        this.tues = Objects.requireNonNullElse(tues, false);
        this.wed = Objects.requireNonNullElse(wed, false);
        this.thurs = Objects.requireNonNullElse(thurs, false);
        this.fri = Objects.requireNonNullElse(fri, false);
        this.sat = Objects.requireNonNullElse(sat, false);
        this.sun = Objects.requireNonNullElse(sun, false);


    }
}
