INSERT INTO USER (userName, passWord) VALUES ('admin', '9cf3e758a497c6274bd066d0b2168432f8a34aad95f63a65677a9a56acec94a7');
INSERT INTO USER (userName, passWord,accountExpired,locked,credentialsExpired) VALUES ('testUser', 'test',0,0,1);

INSERT INTO ROLE(roleName) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE(roleName) VALUES ('ROLE_USER');

INSERT INTO USER_ROLE(userName,roleName) VALUES ('admin','ROLE_ADMIN');
INSERT INTO USER_ROLE(userName,roleName) VALUES ('admin','ROLE_USER');