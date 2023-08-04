ALTER TABLE product  ALTER COLUMN producer_id SET NOT NULL;
ALTER TABLE product  ALTER COLUMN remainder_id SET NOT NULL;
ALTER TABLE product  ALTER COLUMN groupCode_id SET NOT NULL;
ALTER TABLE product  ALTER COLUMN individualCode_id SET NOT NULL;

ALTER TABLE product  ADD CONSTRAINT uk_juog5agv08chyixo0a1ay7d8a UNIQUE (remainder_id);
ALTER TABLE product  ADD CONSTRAINT uk_lpqsxg8w3bwc622t55ko5a9rw UNIQUE (individualcode_id);
ALTER TABLE product  ADD CONSTRAINT uk_mt4591nv67slrnxhpd6kx3jrw UNIQUE (generalinformation_id);

ALTER TABLE product  ADD COLUMN seller_login varchar(255) NOT NULL;
ALTER TABLE product ADD CONSTRAINT fkemvmxv7yjxtvw6iqp4gvkx1we FOREIGN KEY (seller_login) REFERENCES seller(login);



