package org.wikimedia.maps.cassandradumper;

import org.apache.cassandra.io.sstable.CQLSSTableWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class CassandraDumperApplication {


	public static final String SCHEMA =
			"CREATE TABLE v4.tiles (" +
            "  zoom int," +
            "  block int," +
            "  idx bigint," +
            "  tile blob," +
            "  PRIMARY KEY ((zoom, block), idx)" +
            ") WITH CLUSTERING ORDER BY (idx ASC)";

	public static final String INSERT =
			"INSERT INTO v4.tiles (zoom, block, idx, tile)" +
            "  VALUES (?, ?, ?, ?)";

	@Bean
	public CQLSSTableWriter cqlssTableWriter() {
		return CQLSSTableWriter.builder()
				.forTable(SCHEMA)
				.inDirectory("/tmp/test")
				.using(INSERT)
				.withBufferSizeInMB(128)
				.build();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CassandraDumperApplication.class, args);
		TileDumper tileDumper = context.getBean(TileDumper.class);
		tileDumper.dump();
	}
}
