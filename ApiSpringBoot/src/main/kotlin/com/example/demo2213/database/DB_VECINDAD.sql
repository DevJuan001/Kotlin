USE mi_base_de_datos;


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
  user_date DATE NOT NULL ,
  PRIMARY KEY (user_id) 
  )
ENGINE = InnoDB;

CREATE TABLE CATEGORIAS (
  category_id INT NOT NULL AUTO_INCREMENT  ,
  category_name VARCHAR(100) NOT NULL ,
  category_date DATE NOT NULL,
  UNIQUE INDEX category_id_UNIQUE (category_id ASC),
  PRIMARY KEY (category_id)
  )
ENGINE = InnoDB;

CREATE TABLE NOTICES (
  notice_id INT NOT NULL AUTO_INCREMENT,
  notice_body VARCHAR(100) NOT NULL,
  notice_status VARCHAR(100) NOT NULL,
  notice_date DATE NOT NULL,
  category_id INT NOT NULL,
  PRIMARY KEY (notice_id)
)
ENGINE = InnoDB;