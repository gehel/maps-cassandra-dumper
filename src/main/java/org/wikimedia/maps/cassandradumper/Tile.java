package org.wikimedia.maps.cassandradumper;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Table("tiles") @Data @EqualsAndHashCode(exclude = "tile")
public class Tile {

    @PrimaryKeyColumn(type = PARTITIONED)
    private Key key;

    @Column
    private ByteBuffer tile;

    @PrimaryKeyClass
    @Data @ToString @EqualsAndHashCode
    public static class Key implements Serializable {

        @PrimaryKeyColumn(ordinal = 0, type = PARTITIONED)
        private int zoom;

        @PrimaryKeyColumn(ordinal = 1, type = PARTITIONED)
        private int block;

        @PrimaryKeyColumn(ordinal = 2, type = CLUSTERED)
        private long idx;

    }

    public int getZoom() {
        return key.zoom;
    }

    public int getBlock() {
        return key.block;
    }

    public long getIdx() {
        return key.idx;
    }

}
