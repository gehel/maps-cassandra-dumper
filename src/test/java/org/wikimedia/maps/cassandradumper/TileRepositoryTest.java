package org.wikimedia.maps.cassandradumper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TileRepositoryTest {

    @Autowired
    private TileRepository repository;

    @Test
    public void test() {
        repository.findAllTiles().forEach(t -> {
            System.out.println(t);
        });
    }
}
