DROP TABLE abstractorder_product_id;

CREATE TABLE purchase (
	id int8 NOT NULL,
	count float8 NOT NULL,
	paidfor bool NOT NULL,
	product_id int8 NOT NULL,
	abstractorder_id int8 NULL,
	CONSTRAINT purchase_pkey PRIMARY KEY (id)
);
ALTER TABLE purchase ADD CONSTRAINT fk93t8gvf0r076j4uejkb0injck FOREIGN KEY (product_id) REFERENCES product(id);
ALTER TABLE purchase ADD CONSTRAINT fkt5q3wwfgf9p2k9h7o1q6rbm57 FOREIGN KEY (abstractorder_id) REFERENCES abstractorder(id);