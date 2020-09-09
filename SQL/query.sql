DROP TABLE IF EXISTS erp_site_mapping;
CREATE TABLE erp_site_mapping (
    idx BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    site_idx BIGINT NOT NULL,
    type VARCHAR (32) NOT NULL,
    apt_idx BIGINT NOT NULL,
    UNIQUE (site_idx, type, apt_idx),
    INDEX (site_idx, type)
) engine=InnoDB;


DROP TABLE IF EXISTS erp_event;
CREATE TABLE erp_event (
    idx BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    site_idx BIGINT NOT NULL,
    apt_idx BIGINT NOT NULL,
    dong VARCHAR(45) NOT NULL,
    ho VARCHAR(45) NOT NULL,
    type VARCHAR (32) NOT NULL,
    event VARCHAR (12) NOT NULL,
    cretime DATETIME NOT NULL,
    INDEX (idx, event)
) engine=InnoDB;