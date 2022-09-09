DROP SCHEMA IF EXISTS testing;

CREATE SCHEMA testing;

USE testing;

CREATE TABLE user
(
  user_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  image VARCHAR(150),
  role_id INT NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE role
(
	role_id INT NOT NULL,
    roleName VARCHAR(30) NOT NULL,
    PRIMARY KEY (role_id)
);

CREATE TABLE user_role
(
	role_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (role_id, user_id)
);

# Link the user table with role table
# this is a many to many relation so we need a table to link them

ALTER TABLE user_role
	Add FOREIGN KEY(role_id) 
		REFERENCES role (role_id)
        ON DELETE CASCADE
		ON UPDATE CASCADE;
        
ALTER TABLE user_role
	Add FOREIGN KEY(user_id) 
		REFERENCES user (user_id)
        ON DELETE CASCADE
		ON UPDATE CASCADE;


CREATE TABLE product
(
  product_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  quantity INT NOT NULL,
  small_price INT NOT NULL,
  medium_price INT NOT NULL,
  large_price INT NOT NULL,
  image VARCHAR(150) NOT NULL,
  PRIMARY KEY (product_id)
);


CREATE TABLE cart
(
  user_id INT NOT NULL,
  product_id INT NOT NULL,
  size INT NOT NULL,   # values = 1, 2, 3
  sugar INT NOT NULL,   # values = 0, 1, 2, 3
  PRIMARY KEY (user_id, product_id),
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (product_id) REFERENCES product(product_id)
);


/*  NOT YET

CREATE TABLE orders
(
  orderId INT NOT NULL,
  date DATE NOT NULL,
  userId INT NOT NULL,
  PRIMARY KEY (orderId),
  FOREIGN KEY (userId) REFERENCES user(userId)
);

CREATE TABLE orderitem
(
  orderId INT NOT NULL,
  itemId INT NOT NULL,
  size VARCHAR(45) NOT NULL,
  PRIMARY KEY (orderId, itemId, size),
  FOREIGN KEY (orderId) REFERENCES orders(orderId),
  FOREIGN KEY (itemId, size) REFERENCES item(itemId, size)
);


*/