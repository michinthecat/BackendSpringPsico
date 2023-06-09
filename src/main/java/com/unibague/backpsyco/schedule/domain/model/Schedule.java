package com.unibague.backpsyco.schedule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {

    private int id;
    private LocalDate date;
    private LocalTime time;
    private int psychologist;
    private int state;

}