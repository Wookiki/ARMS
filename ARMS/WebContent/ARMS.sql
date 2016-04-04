create table USERINFO(
u_id		VARCHAR2(20) PRIMARY KEY NOT NULL,
u_passwd	VARCHAR2(15) NOT NULL,
u_name		VARCHAR2(10) NOT NULL,
u_dong		VARCHAR2(20) NOT NULL,
u_ho		NUMBER 	NOT NULL,
u_tel		VARCHAR2(15) NULL,
u_car		NUMBER	NULL,
u_host		VARCHAR2(10)  NULL,
u_adminId	VARCHAR2(10) NULL
)
ALTER TABLE USERINFO RENAME COLUMN u_host TO u_hostId;
ALTER TABLE USERINFO ADD (u_presidentId VARCHAR(10));
create table ARTICLE(
ar_articleName		VARCHAR2(20) 	NOT NULL,
ar_num				NUMBER			NOT NULL,
ar_writer			VARCHAR2(10)	NOT NULL,
ar_subject			VARCHAR2(20)	NOT NULL,
ar_date				DATE			NOT NULL,
ar_readCount			NUMBER			NOT NULL,
ar_content			VARCHAR2(200)	NOT NULL,
ar_Ref				NUMBER			NOT NULL,
ar_re_step			NUMBER			NOT NULL,
ar_re_level			NUMBER			NOT NULL,
u_id				VARCHAR2(20)	NOT NULL,
CONSTRAINT PK_ar_articleName	PRIMARY KEY(ar_articleName),
CONSTRAINT FK_u_id	FOREIGN KEY(u_id) REFERENCES USERINFO(u_id)
)

CREATE SEQUENCE seq_ar_num
START WITH 1
INCREMENT BY 1
NOMAXVALUE


create table CHATROOM(
ch_host		VARCHAR2(20) NOT NULL,
ch_topic		VARCHAR2(100) NULL,
ch_participant	VARCHAR2(10) NOT NULL,
CONSTRAINT PK_ch_host	PRIMARY KEY(ch_host),
CONSTRAINT FK_ch_participant	FOREIGN KEY(ch_participant) REFERENCES USERINFO(u_id)
)

create table FACILITY(
fa_name		VARCHAR2(10),
fa_user		VARCHAR2(10) NOT NULL,
fa_date		DATE		 NOT NULL,
fa_id				VARCHAR2(20)	NOT NULL,
CONSTRAINT PK_fa_name	PRIMARY KEY(fa_name),
CONSTRAINT FK_fa_id	FOREIGN KEY(fa_id) REFERENCES USERINFO(u_id)
)