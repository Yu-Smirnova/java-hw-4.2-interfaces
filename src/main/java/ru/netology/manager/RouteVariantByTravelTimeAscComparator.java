package ru.netology.manager;

import ru.netology.domain.RouteVariant;

import java.util.Comparator;

public class RouteVariantByTravelTimeAscComparator implements Comparator<RouteVariant> {
    public int compare(RouteVariant o1, RouteVariant o2){
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
