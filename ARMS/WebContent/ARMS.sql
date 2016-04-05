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

INSERT INTO USERINFO VALUES ('Wookiki', '1111', '김영욱', '없음', 0, '010-2081-1597', 1, null, 'Wookiki', null)
INSERT INTO USERINFO VALUES ('Rock', '1111', '박홍락', '101', 101, '010-4558-9543', 5, null, 'Wookiki', 'Rock' )
INSERT INTO USERINFO VALUES ('Yong', '1111', '조용우', '101', 102, '010-9999-6380', 3, 'Yong', 'Wookiki', 'Rock' )

SELECT * FROM USERINFO WHERE u_id = 'Wookiki';

create table NOTICEBOARD(
no_num				NUMBER			NOT NULL,
no_writerId			VARCHAR2(10)	NOT NULL,
no_subject			VARCHAR2(20)	NOT NULL,
no_date				DATE			NOT NULL,
no_readCount		NUMBER			NOT NULL,
no_content			VARCHAR2(200)	NOT NULL,
no_Ref				NUMBER			NOT NULL,
no_re_step			NUMBER			NOT NULL,
no_re_level			NUMBER			NOT NULL,
CONSTRAINT PK_no_num	PRIMARY KEY(no_num),
CONSTRAINT FK_no_writerId	FOREIGN KEY(no_writerId) REFERENCES USERINFO(u_id)
)

CREATE SEQUENCE seq_no_num
START WITH 1
INCREMENT BY 1
NOMAXVALUE

create table VOLUNTEERBOARD(
vol_num				NUMBER			NOT NULL,
vol_writerId			VARCHAR2(10)	NOT NULL,
vol_subject			VARCHAR2(20)	NOT NULL,
vol_date				DATE			NOT NULL,
vol_readCount		NUMBER			NOT NULL,
vol_content			VARCHAR2(200)	NOT NULL,
vol_Ref				NUMBER			NOT NULL,
vol_re_step			NUMBER			NOT NULL,
vol_re_level			NUMBER			NOT NULL,
CONSTRAINT PK_vol_num	PRIMARY KEY(vol_num),
CONSTRAINT FK_vol_writerId	FOREIGN KEY(vol_writerId) REFERENCES USERINFO(u_id)
)

CREATE SEQUENCE seq_vol_num
START WITH 1
INCREMENT BY 1
NOMAXVALUE

create table FACILITYBOARD(
fa_num				NUMBER			NOT NULL,
fa_writerId			VARCHAR2(10)	NOT NULL,
fa_subject			VARCHAR2(20)	NOT NULL,
fa_date				DATE			NOT NULL,
fa_readCount		NUMBER			NOT NULL,
fa_content			VARCHAR2(200)	NOT NULL,
fa_Ref				NUMBER			NOT NULL,
fa_re_step			NUMBER			NOT NULL,
fa_re_level			NUMBER			NOT NULL,
CONSTRAINT PK_fa_num	PRIMARY KEY(fa_num),
CONSTRAINT FK_fa_writerId	FOREIGN KEY(fa_writerId) REFERENCES USERINFO(u_id)
)

CREATE SEQUENCE seq_fa_num
START WITH 1
INCREMENT BY 1
NOMAXVALUE

create table CALENDARBOARD(
cal_num				NUMBER			NOT NULL,
cal_writerId			VARCHAR2(10)	NOT NULL,
cal_subject			VARCHAR2(20)	NOT NULL,
cal_date				DATE			NOT NULL,
cal_readCount		NUMBER			NOT NULL,
cal_content			VARCHAR2(200)	NOT NULL,
cal_Ref				NUMBER			NOT NULL,
cal_re_step			NUMBER			NOT NULL,
cal_re_level			NUMBER			NOT NULL,
CONSTRAINT PK_cal_num	PRIMARY KEY(cal_num),
CONSTRAINT FK_cal_writerId	FOREIGN KEY(cal_writerId) REFERENCES USERINFO(u_id)
)

CREATE SEQUENCE seq_cal_num
START WITH 1
INCREMENT BY 1
NOMAXVALUE

create table SUGGESTIONBOARD(
sug_num				NUMBER			NOT NULL,
sug_writerId			VARCHAR2(10)	NOT NULL,
sug_subject			VARCHAR2(20)	NOT NULL,
sug_date				DATE			NOT NULL,
sug_readCount		NUMBER			NOT NULL,
sug_content			VARCHAR2(200)	NOT NULL,
sug_Ref				NUMBER			NOT NULL,
sug_re_step			NUMBER			NOT NULL,
sug_re_level			NUMBER			NOT NULL,
CONSTRAINT PK_sug_num	PRIMARY KEY(sug_num),
CONSTRAINT FK_sug_writerId	FOREIGN KEY(sug_writerId) REFERENCES USERINFO(u_id)
)

CREATE SEQUENCE seq_sug_num
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