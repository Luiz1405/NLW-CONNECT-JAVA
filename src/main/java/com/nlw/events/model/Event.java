package com.nlw.events.model;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer event_Id;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "pretty_name", length = 50, nullable = false, unique = true)
    private String prettyName;

    @Column(name = "location", length = 255, nullable = false)
    private String location;

    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endLocalTime;
}
