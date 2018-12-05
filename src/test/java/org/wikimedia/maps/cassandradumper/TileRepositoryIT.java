package org.wikimedia.maps.cassandradumper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.thetaphi.forbiddenapis.SuppressForbidden;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TileRepositoryIT {

    @Autowired
    private TileRepository repository;

    @Test @SuppressForbidden
    public void test() {
        repository.findAllTiles().forEach(System.out::println);
    }
}
