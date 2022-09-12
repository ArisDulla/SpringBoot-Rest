
 DOCKER
docker run --name mysqldb -v mysqldbvol:/var/lib/mysql -p 3306:3306 -e MYSQL_USER=hbstudent -e MYSQL_PASSWORD=changeit -e MYSQL_DATABASE=students -e MYSQL_ROOT_PASSWORD=pass123 --rm -d mysql/mysql-server:latest

 CREATE TABLE IF NOT EXISTS `user` (
 `username` varchar(50) NOT NULL,
 `password` varchar(100) NOT NULL,
 `enabled` tinyint(1) NOT NULL,
 PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `authorities` (
 `username` varchar(50) NOT NULL,
 `authority` varchar(90) NOT NULL,
 UNIQUE KEY `ix_auth_username` (`username`,`authority`),
 CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`username`, `password`, `enabled`) VALUES
   ('root', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1),
   ('ypallilos23', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1),
   ('axiomatikos23', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1),
   ('aris', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1);

INSERT INTO `authorities` (`username`, `authority`) VALUES
   ('root', 'ROLE_ADMIN'),
   ('aris', 'ROLE_USER_A_Politis'),
   ('ypallilos23', 'ROLE_USER_B_Ypallilos'),
   ('axiomatikos23', 'ROLE_USER_C_Axiomatikos');


LOCAL
http://localhost:8080/

ROLE_ADMIN : root   pass123

ROLE_USER_A_Politis : aris  pass123

ROLE_USER_B_Ypallilos :  ypallilos23  pass123

ROLE_USER_C_Axiomatikos : axiomatikos23 pass123

