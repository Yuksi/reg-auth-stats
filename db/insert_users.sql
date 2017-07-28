INSERT INTO USERS (user_id, login, name, surname, email, reg_date, role, status, password) VALUES(USERS_SEQ.NEXTVAL, 'super', 'Super', 'Superadmin', 'super@ukr.net', SYSDATE, 2, 0, 'super');
	
INSERT INTO USERS (user_id, login, name, surname, email, reg_date, role, status, password) VALUES(USERS_SEQ.NEXTVAL, 'admin', 'Admin', 'Administrator', 'admin@ukr.net', SYSDATE, 1, 0, 'admin');
	
INSERT INTO USERS (user_id, login, name, surname, email, reg_date, role, status, password) VALUES(USERS_SEQ.NEXTVAL, 'ivan', 'Ivan', 'Ivanov', 'ivan@ukr.net', SYSDATE, 0, 0, 'ivan');
	
INSERT INTO USERS (user_id, login, name, surname, email, reg_date, role, status, password) VALUES(USERS_SEQ.NEXTVAL, 'petr', 'Petr', 'Petrov', 'petr@ukr.net', SYSDATE, 0, 0, 'petr');
	
INSERT INTO USERS (user_id, login, name, surname, email, reg_date, role, status, password) VALUES(USERS_SEQ.NEXTVAL, 'sidor', 'Sidor', 'Sidorov', 'sidor@ukr.net', SYSDATE, 0, 0, 'sidor');

commit;