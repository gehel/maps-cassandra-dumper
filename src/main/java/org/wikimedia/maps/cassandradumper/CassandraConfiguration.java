package org.wikimedia.maps.cassandradumper;

import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "v4";
    }
}
