CREATE KEYSPACE v4
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1' }
AND durable_writes = false;

CREATE TABLE v4.tiles (
                        zoom int,
                        block int,
                        idx bigint,
                        tile blob,
                        PRIMARY KEY ((zoom, block), idx)
  ) WITH CLUSTERING ORDER BY (idx ASC);
