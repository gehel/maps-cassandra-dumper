package org.wikimedia.maps.cassandradumper;

import java.math.BigInteger;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Tile {

    @PrimaryKeyColumn(ordinal = 0)
    private int zoom;

    @PrimaryKeyColumn(ordinal = 1)
    private int block;

    @PrimaryKeyColumn(ordinal = 2)
    private BigInteger idx;

    @Column
    private byte[] tile;

}
