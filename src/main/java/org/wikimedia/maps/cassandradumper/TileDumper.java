package org.wikimedia.maps.cassandradumper;

import org.apache.cassandra.io.sstable.CQLSSTableWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
public class TileDumper {

    private final TileRepository repository;
    private final CQLSSTableWriter writer;

    @Autowired
    public TileDumper(TileRepository repository, CQLSSTableWriter writer) {
        this.repository = repository;
        this.writer = writer;
    }

    public void dump() {
        repository.findAllTiles().forEach(this::write);
    }

    @SneakyThrows
    private void write(Tile tile) {
        writer.addRow(tile.getZoom(), tile.getBlock(), tile.getIdx(), tile.getTile());
    }
}
