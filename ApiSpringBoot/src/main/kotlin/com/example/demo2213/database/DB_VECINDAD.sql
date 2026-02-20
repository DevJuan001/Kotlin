DROP DATABASE DB_VECINDAD;
CREATE DATABASE DB_VECINDAD;
USE DB_VECINDAD;

CREATE TABLE USERS (
  user_id INT NOT NULL AUTO_INCREMENT ,
  user_name VARCHAR(255) NOT NULL ,
  user_first_surname VARCHAR(255) NOT NULL ,
  user_second_surname VARCHAR(255) NOT NULL ,
  user_phone VARCHAR(255) NOT NULL ,
  user_email VARCHAR(255) NOT NULL ,
  user_address VARCHAR(255) NOT NULL,
  user_password VARCHAR(255) NOT NULL ,
  user_city VARCHAR(255) NOT NULL ,
  user_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id)
  )
ENGINE = InnoDB;

CREATE TABLE CATEGORIES (
  category_id INT NOT NULL AUTO_INCREMENT  ,
  category_name VARCHAR(100) NOT NULL ,
  category_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE INDEX category_id_UNIQUE (category_id ASC),
  PRIMARY KEY (category_id)
  )
ENGINE = InnoDB;

CREATE TABLE NOTICES (
  user_id INT NOT NULL,
  category_id INT NOT NULL,
  notice_id INT NOT NULL AUTO_INCREMENT,
  notice_body TEXT NOT NULL,
  notice_status TEXT NOT NULL,
  notice_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (notice_id),
  CONSTRAINT fk_notices_users
	FOREIGN KEY (user_id)
    REFERENCES USERS (user_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_notices_categories
	FOREIGN KEY (category_id)
    REFERENCES CATEGORIES(category_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

CREATE TABLE COMMENTS(
	user_id INT NOT NULL,
    notice_id INT NOT NULL,
    comment_id INT NOT NULL AUTO_INCREMENT,
    comment_text TEXT NOT NULL,
    comment_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (comment_id),
    CONSTRAINT fk_comments_users
		FOREIGN KEY (user_id)
        REFERENCES USERS (user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT fk_comments_notice
		FOREIGN KEY (notice_id)
        REFERENCES NOTICES (notice_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
)
ENGINE = innoDB;

DELIMITER //

CREATE PROCEDURE get_comments_by_notice_id(IN p_notice_id INT)
BEGIN
	SELECT
    ct.category_name,
    u.user_id,
    u.user_name,
    u.user_first_surname,
    n.notice_id,
    n.notice_body,
    c.comment_id,
    c.comment_text,
    c.comment_date
	FROM USERS AS u
	INNER JOIN NOTICES as n
	ON u.user_id = n.user_id
	INNER JOIN CATEGORIES AS ct
	ON n.category_id = ct.category_id
	INNER JOIN COMMENTS AS c
	ON n.notice_id = c.notice_id
	WHERE n.notice_id = p_notice_id;
END //

DELIMITER ;