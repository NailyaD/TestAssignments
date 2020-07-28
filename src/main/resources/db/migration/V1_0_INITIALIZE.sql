CREATE TABLE customer (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL UNIQUE,
    active tinyint(1) unsigned NOT NULL DEFAULT '1',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE request_stats (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) unsigned NOT NULL,
    time datetime NOT NULL,
    is_valid boolean DEFAULT true,
    PRIMARY KEY (id),
    UNIQUE KEY unique_customer_time (customer_id,time),
    KEY customer_idx (customer_id),
    CONSTRAINT stats_customer_id
    FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE ip_blacklist (
    ip varchar(255) NOT NULL,
    PRIMARY KEY (ip)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE ua_blacklist (
    ua varchar(255) NOT NULL,
    PRIMARY KEY (ua)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO customer (id, name, active)
VALUES (1,'Big News Media Corp',1),
       (2,'Online Mega Store',1),
       (3,'Nachoroo Delivery',0),
       (4,'Euro Telecom Group',1);

INSERT INTO ip_blacklist (ip)
VALUES ('0'),
       ('213.070.64.33'),
       ('429.496.72.95');

INSERT INTO ua_blacklist (ua)
VALUES ('A6-Indexer'),
       ('Googlebot-News'),
       ('Googlebot');
