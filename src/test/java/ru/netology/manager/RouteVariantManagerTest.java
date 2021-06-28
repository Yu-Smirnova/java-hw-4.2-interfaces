package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.RouteVariant;
import ru.netology.repository.RouteVariantsRepository;

import static org.junit.jupiter.api.Assertions.*;

class RouteVariantManagerTest {
    RouteVariantsRepository repo = new RouteVariantsRepository();
    RouteVariant var1 = new RouteVariant(1, 1000, "LED", "SVO", 90);
    RouteVariant var2 = new RouteVariant(2, 2000, "LED", "GOJ", 120);
    RouteVariant var3 = new RouteVariant(3, 5000, "LED", "OGZ", 210);
    RouteVariant var4 = new RouteVariant(4, 3500, "LED", "OGZ", 260);
    RouteVariant var5 = new RouteVariant(5, 4000, "LED", "OGZ", 240);

    @BeforeEach
    public void setUp(){
        repo.save(var1);
        repo.save(var2);
        repo.save(var3);
        repo.save(var4);
        repo.save(var5);
    }

    @Test
    void shouldFindAllByWhenOneIsEqual() {
        RouteVariantManager manager = new RouteVariantManager(repo);

        RouteVariant[] result = manager.findAllBy("led", "Svo");

        RouteVariant[] expected = {var1};
        RouteVariant[] actual = result;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByWhenMoreThenOneEqual(){
        RouteVariantManager manager = new RouteVariantManager(repo);

        RouteVariant[] result = manager.findAllBy("LED", "ogz");

        RouteVariant[] expected = {var4, var5, var3};
        RouteVariant[] actual = result;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByWhenNoneEqual(){
        RouteVariantManager manager = new RouteVariantManager(repo);

        RouteVariant[] result = manager.findAllBy("svo", "Dme");

        RouteVariant[] expected = new RouteVariant[0];
        RouteVariant[] actual = result;
        Assertions.assertArrayEquals(expected, actual);
    }
}