package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RouteVariant implements Comparable<RouteVariant> {
    private int id;
    private int price;
    private String departure;
    private String destination;
    private int travelTime;

    @Override
    public int compareTo(RouteVariant o) {
        return this.price - o.price;
    }
}
