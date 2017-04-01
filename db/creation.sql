DROP TABLE SESSIONS CASCADE CONSTRAINTS;
DROP TABLE CHANGES_TOTAL CASCADE CONSTRAINTS;
DROP TABLE CHANGES_TOTAL CASCADE CONSTRAINTS;

CREATE TABLE USERS
(
	user_id	NUMBER(10),
	login	VARCHAR2(30) NOT NULL,
	name	VARCHAR2(30),
	surname	VARCHAR2(30),
	email	VARCHAR2(100),
	reg_date	DATE NOT NULL,
	change_date	DATE,
	role	NUMBER(2) NOT NULL,
	status	NUMBER(2) NOT NULL,
	CONSTRAINT pk_users PRIMARY KEY (user_id)
) ;

CREATE TABLE SOCIAL_ACCOUNTS
(
	id_acc	NUMBER(10),
	user_id	NUMBER(10),
	network	VARCHAR2(255),
	social_id	VARCHAR2(255),
	CONSTRAINT pk_acc PRIMARY KEY(id_acc),
	CONSTRAINT soc_user_id_ref FOREIGN KEY(user_id) REFERENCES USERS(user_id)
);

CREATE TABLE CHANGES_TOTAL
(
	id_changing	NUMBER(10),
	id_to_change	NUMBER(10),
	id_who_changes	NUMBER(10),
	change_date	DATE NOT NULL,
	CONSTRAINT pk_change PRIMARY KEY(id_changing),
	CONSTRAINT to_change_user_id_ref FOREIGN KEY(id_to_change) REFERENCES USERS(user_id),
	CONSTRAINT who_change_user_id_ref FOREIGN KEY(id_who_changes) REFERENCES USERS(user_id)
);

CREATE TABLE SESSIONS
(
	session_id NUMBER(10),
	user_id NUMBER(10),
	login_date DATE,
	logout_date DATE,
	CONSTRAINT pk_sessions PRIMARY KEY(session_id),
	CONSTRAINT ses_user_id_ref FOREIGN KEY(user_id) REFERENCES USERS(user_id)
)