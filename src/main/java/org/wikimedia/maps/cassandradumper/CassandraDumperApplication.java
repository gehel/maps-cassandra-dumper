package org.wikimedia.maps.cassandradumper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.cassandra.io.sstable.CQLSSTableWriter;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${dumper.output.dir}")
	private Path outputDir;

	@Bean
	public CQLSSTableWriter cqlssTableWriter(

	) throws IOException {
		if (!Files.exists(outputDir)) Files.createDirectories(outputDir);
		if (!Files.isDirectory(outputDir)) throw new IllegalArgumentException("Output dir needs to be a directory");

		return CQLSSTableWriter.builder()
				.forTable(SCHEMA)
				.inDirectory(outputDir.toFile())
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
