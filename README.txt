
 DOCKER
docker run --name mysqldb -v mysqldbvol:/var/lib/mysql -p 3306:3306 -e MYSQL_USER=hbstudent -e MYSQL_PASSWORD=changeit -e MYSQL_DATABASE=students -e MYSQL_ROOT_PASSWORD=pass123 --rm -d mysql/mysql-server:latest

![plot](./architecture.png)

LOCAL
http://localhost:8080/

ROLE_ADMIN : root   pass123

ROLE_USER_A_Politis : aris  pass123

ROLE_USER_B_Ypallilos :  ypallilos23  pass123

ROLE_USER_C_Axiomatikos : axiomatikos23 pass123

