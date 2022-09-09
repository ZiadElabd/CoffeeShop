

INSERT INTO user (name, email, password)
VALUES ('admin', 'bgfbfgbgf@gfbgfb', 'encodedpassword');

SELECT * FROM user;


SELECT * 
FROM user
WHERE user_id = 3;

INSERT INTO role (role_name)
VALUES 
	('USER'), 
    ('ADMIN');

SELECT * FROM role;



INSERT INTO user_role (role_id, user_id)
VALUES (1, 1);


SELECT *
FROM user_role
JOIN role
	ON user_role.role_id = role.role_id
JOIN user 
	ON user_role.user_id = user.user_id
    
    




