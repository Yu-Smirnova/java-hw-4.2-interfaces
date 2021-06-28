package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.RouteVariant;

public class RouteVariantsRepository {
    private RouteVariant[] routeVariants = new RouteVariant[0];

    public void save(RouteVariant item){
        RouteVariant[] tmp = new RouteVariant[routeVariants.length + 1];
        System.arraycopy(routeVariants, 0, tmp, 0, routeVariants.length);
        tmp[routeVariants.length] = item;
        routeVariants = tmp;
    }

    public RouteVariant[] findAll(){
        return routeVariants;
    }

    public void removeById(int id){
        if (findAll() == null){
            throw new NotFoundException("Вариант перелета с " + id + " не найден");
        }
        int length = routeVariants.length - 1;
        RouteVariant[] tmp = new RouteVariant[length];
        int index = 0;
        for (RouteVariant item : routeVariants){
            if (item.getId() != id){
                tmp[index] = item;
                index++;
            }
        }
        routeVariants = tmp;
    }
}
