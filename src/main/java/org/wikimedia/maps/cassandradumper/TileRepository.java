package org.wikimedia.maps.cassandradumper;

import java.util.stream.Stream;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TileRepository extends CassandraRepository<Tile, Tile.Key> {

    @Query("select * from tiles")
    Stream<Tile> findAllTiles();
}
