
INSERT INTO product (name, small_price, medium_price, large_price, image)
VALUES 
	('cofee', 10, 15, 20, 'url'),
    ('tea', 5, 10, 15, 'url');


SELECT * FROM product;


INSERT INTO cart (user_id, product_id, quantity, size, sugar)
VALUES 
	(1, 1, 3, 2, 3);
    
SELECT * FROM cart;


SELECT * 
FROM cart
WHERE user_id = 1;


