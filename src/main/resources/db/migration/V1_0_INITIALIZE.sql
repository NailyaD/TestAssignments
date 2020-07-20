CREATE TABLE customer (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    active tinyint(1) unsigned NOT NULL DEFAULT '1',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE val_or_inval_customer (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) unsigned NOT NULL,
    name varchar(255) NOT NULL,
    time DATETIME NOT NULL
         DEFAULT CURRENT_TIMESTAMP,
    request_validation_status ENUM ('valid','invalid') NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE ip_blacklist (
    ip int(11) unsigned NOT NULL,
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
VALUES (0),
       (2130706433),
       (4294967295);

INSERT INTO ua_blacklist (ua)
VALUES ('A6-Indexer'),
       ('Googlebot-News'),
       ('Googlebot');
