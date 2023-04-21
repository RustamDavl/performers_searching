package com.rustdv.webconstruction.filter;

import com.rustdv.webconstruction.entity.RespondStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderFilter {

    private String filter;

    private RespondStatus respondStatus;

}
