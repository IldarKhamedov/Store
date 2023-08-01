CREATE TABLE anonymous (
	login varchar(255) NOT NULL,
	CONSTRAINT anonymous_pkey PRIMARY KEY (login)
);


CREATE TABLE superuser (
	activationcode varchar(255) NULL,
	email varchar(255) NULL,
	firstname varchar(255) NULL,
	lastname varchar(255) NULL,
	"password" varchar(255) NOT NULL,
	phonenumber varchar(11) NULL,
	login varchar(255) NOT NULL,
	CONSTRAINT superuser_pkey PRIMARY KEY (login)
);
ALTER TABLE superuser ADD CONSTRAINT fk6o0obqwfqco2cvw1f3hsodo7s FOREIGN KEY (login) REFERENCES anonymous(login);


CREATE TABLE client (
	login varchar(255) NOT NULL,
	CONSTRAINT client_pkey PRIMARY KEY (login)
);
ALTER TABLE client ADD CONSTRAINT fkm0is31p2jwxm1mcofj24j77fj FOREIGN KEY (login) REFERENCES superuser(login);


CREATE TABLE staff (
	login varchar(255) NOT NULL,
	CONSTRAINT staff_pkey PRIMARY KEY (login)
);
ALTER TABLE staff ADD CONSTRAINT fk4ltn9lie38jy7ammqxptmaiah FOREIGN KEY (login) REFERENCES superuser(login);


CREATE TABLE "owner" (
	login varchar(255) NOT NULL,
	CONSTRAINT owner_pkey PRIMARY KEY (login)
);
ALTER TABLE "owner" ADD CONSTRAINT fkkyo7b74vmb80p0o175r1m6kto FOREIGN KEY (login) REFERENCES superuser(login);


CREATE TABLE seller (
	login varchar(255) NOT NULL,
	CONSTRAINT seller_pkey PRIMARY KEY (login)
);
ALTER TABLE seller ADD CONSTRAINT fkimy6s1wordijqj8c42id4sj8m FOREIGN KEY (login) REFERENCES staff(login);

CREATE TABLE storekeeper (
	login varchar(255) NOT NULL,
	CONSTRAINT storekeeper_pkey PRIMARY KEY (login)
);
ALTER TABLE storekeeper ADD CONSTRAINT fkdrtrc80mtr87rebkdfq8snmjg FOREIGN KEY (login) REFERENCES staff(login);

CREATE TABLE moderator (
	login varchar(255) NOT NULL,
	CONSTRAINT moderator_pkey PRIMARY KEY (login)
);
ALTER TABLE moderator ADD CONSTRAINT fk4asskaymdwnb9uw5dqb3y5gy6 FOREIGN KEY (login) REFERENCES staff(login);


CREATE TABLE generalinformation (
	id int8 NOT NULL,
	deleted bool NOT NULL,
	description text NULL,
	"name" varchar(255) NULL,
	CONSTRAINT generalinformation_pkey PRIMARY KEY (id)
);

CREATE TABLE abstractcategoryofproduct (
	dtype varchar(31) NOT NULL,
	id int8 NOT NULL,
	generalinformation_id int8 NULL,
	categoryofproduct_id int8 NULL,
	CONSTRAINT abstractcategoryofproduct_pkey PRIMARY KEY (id)
);
ALTER TABLE abstractcategoryofproduct ADD CONSTRAINT fki4e006s43ysfn087uenc5v14n FOREIGN KEY (generalinformation_id) REFERENCES generalinformation(id);
ALTER TABLE abstractcategoryofproduct ADD CONSTRAINT fko82xf053nkbwbf1n5iaggu137 FOREIGN KEY (categoryofproduct_id) REFERENCES abstractcategoryofproduct(id);

CREATE TABLE producer (
	id int8 NOT NULL,
	city varchar(255) NULL,
	country varchar(255) NULL,
	CONSTRAINT producer_pkey PRIMARY KEY (id)
);

CREATE TABLE remainder (
	id int8 NOT NULL,
	quantity float8 NOT NULL,
	unitofmeasurement varchar(255) NULL,
	CONSTRAINT remainder_pkey PRIMARY KEY (id)
);

CREATE TABLE code (
	dtype varchar(31) NOT NULL,
	id int8 NOT NULL,
	"number" int8 NOT NULL,
	CONSTRAINT code_pkey PRIMARY KEY (id)
);

CREATE TABLE imagecontent (
	id int8 NOT NULL,
	"content" bytea NULL,
	CONSTRAINT imagecontent_pkey PRIMARY KEY (id)
);

CREATE TABLE imagefile (
	id int8 NOT NULL,
	contenttype varchar(255) NULL,
	length int8 NOT NULL,
	imagecontent_id int8 NULL,
	generalinformation_id int8 NULL,
	CONSTRAINT imagefile_pkey PRIMARY KEY (id)
);
ALTER TABLE imagefile ADD CONSTRAINT fkd8v3h8ab5gpu98lborrjvh00o FOREIGN KEY (generalinformation_id) REFERENCES generalinformation(id);
ALTER TABLE imagefile ADD CONSTRAINT fkdahmpgc21eskcek4j88i5ijo9 FOREIGN KEY (imagecontent_id) REFERENCES imagecontent(id);

CREATE TABLE product (
	id int8 NOT NULL,
	"cost" float8 NULL,
	generalinformation_id int8 NULL,
	groupcode_id int8 NULL,
	individualcode_id int8 NULL,
	producer_id int8 NULL,
	remainder_id int8 NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id),
	CONSTRAINT ukmgjrxvtlsl7fjh5elkffeykgn UNIQUE (groupcode_id, individualcode_id)
);
ALTER TABLE product ADD CONSTRAINT fk1p03nfq9a930ijjl6p3ykalmh FOREIGN KEY (producer_id) REFERENCES producer(id);
ALTER TABLE product ADD CONSTRAINT fka0p5orf7hqc62ma8aqtd8kh08 FOREIGN KEY (remainder_id) REFERENCES remainder(id);
ALTER TABLE product ADD CONSTRAINT fki597bxkh8upq3q8lgu61cv71n FOREIGN KEY (generalinformation_id) REFERENCES generalinformation(id);
ALTER TABLE product ADD CONSTRAINT fklyw9xfv0dugk3x0rjn0s3k4p9 FOREIGN KEY (individualcode_id) REFERENCES code(id);
ALTER TABLE product ADD CONSTRAINT fkt1yf8q8i64ifhmaqdga7tm7us FOREIGN KEY (groupcode_id) REFERENCES code(id);

CREATE TABLE abstractorder (
	id int8 NOT NULL,
	anonymous_login varchar(255) NOT NULL,
	CONSTRAINT abstractorder_pkey PRIMARY KEY (id)
);
ALTER TABLE abstractorder ADD CONSTRAINT fkpdd1vi9iw2034dwr0jygkwbyg FOREIGN KEY (anonymous_login) REFERENCES anonymous(login);


CREATE TABLE abstractorder_product_id (
	abstractorder_id int8 NOT NULL,
	count float8 NULL,
	product_id_key int8 NOT NULL,
	CONSTRAINT abstractorder_product_id_pkey PRIMARY KEY (abstractorder_id, product_id_key)
);
ALTER TABLE abstractorder_product_id ADD CONSTRAINT fkab29cep6v3nrmce7hty3uuno5 FOREIGN KEY (product_id_key) REFERENCES product(id);
ALTER TABLE abstractorder_product_id ADD CONSTRAINT fkq91a8h4awht6wgp9xv2go019a FOREIGN KEY (abstractorder_id) REFERENCES abstractorder(id);

CREATE TABLE basket (
	id int8 NOT NULL,
	CONSTRAINT basket_pkey PRIMARY KEY (id)
);
ALTER TABLE basket ADD CONSTRAINT fkg5n6odrcolm1etvwo6q5ue1ma FOREIGN KEY (id) REFERENCES abstractorder(id);

CREATE TABLE "ordering" (
	createdtime timestamp NULL,
	deliverytime timestamp NULL,
	id int8 NOT NULL,
	CONSTRAINT ordering_pkey PRIMARY KEY (id)
);
ALTER TABLE "ordering" ADD CONSTRAINT fklhk8q1798kqsbamk0jgdsiegh FOREIGN KEY (id) REFERENCES abstractorder(id);



CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;