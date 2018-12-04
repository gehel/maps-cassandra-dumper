CREATE TABLE v4.tiles (
                        zoom int,
                        block int,
                        idx bigint,
                        tile blob,
                        PRIMARY KEY ((zoom, block), idx)
  ) WITH CLUSTERING ORDER BY (idx ASC);


INSERT INTO v4.tiles (zoom, block, idx, tile)
VALUES (1, 2, 3, textAsBlob('123'));

INSERT INTO v4.tiles (zoom, block, idx, tile)
VALUES (4, 5, 6, textAsBlob('456'));
