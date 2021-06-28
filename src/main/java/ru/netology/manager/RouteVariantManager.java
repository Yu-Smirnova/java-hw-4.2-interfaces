package ru.netology.manager;

import ru.netology.domain.RouteVariant;
import ru.netology.repository.RouteVariantsRepository;

import java.util.Arrays;
import java.util.Comparator;

public class RouteVariantManager {
    private RouteVariantsRepository repository;
    public RouteVariantManager(RouteVariantsRepository repository){
        this.repository = repository;
    }

    public void add(RouteVariant routeVariant){
        repository.save(routeVariant);
    }

    public void removeById(int id){
        repository.removeById(id);
    }

    public RouteVariant[] findAllBy(String departure, String destination, Comparator<RouteVariant> comparator){
        RouteVariant[] result = new RouteVariant[0];
        for (RouteVariant item : repository.findAll()){
            RouteVariant[] tmp = new RouteVariant[result.length + 1];
            if(item.getDeparture().equalsIgnoreCase(departure) && item.getDestination().equalsIgnoreCase(destination)){
                System.arraycopy(result, 0, tmp,0, result.length);
                tmp[tmp.length - 1] = item;
                Arrays.sort(tmp, comparator);
                result = tmp;
            }
        }
        return result;
    }


}
