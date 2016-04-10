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
num				NUMBER			NOT NULL,
writerId			VARCHAR2(10)	NOT NULL,
subject			VARCHAR2(20)	NOT NULL,
wirteDate				DATE			NOT NULL,
readCount		NUMBER			NOT NULL,
content			VARCHAR2(200)	NOT NULL,
Ref				NUMBER			NOT NULL,
re_step			NUMBER			NOT NULL,
re_level			NUMBER			NOT NULL,
CONSTRAINT PK_no_num	PRIMARY KEY(num),
CONSTRAINT FK_no_writerId	FOREIGN KEY(writerId) REFERENCES USERINFO(u_id)
)

alter table NOTICEBOARD ADD PASSWD NUMBER;

CREATE SEQUENCE seq_notice
START WITH 1
INCREMENT BY 1
NOMAXVALUE

drop sequence seq_no_num;

create table VOLUNTEERBOARD(
num				NUMBER			NOT NULL,
writerId			VARCHAR2(10)	NOT NULL,
subject			VARCHAR2(20)	NOT NULL,
writedate				DATE			NOT NULL,
readCount		NUMBER			NOT NULL,
content			VARCHAR2(200)	NOT NULL,
Ref				NUMBER			NOT NULL,
re_step			NUMBER			NOT NULL,
re_level			NUMBER			NOT NULL,
CONSTRAINT PK_vo_num	PRIMARY KEY(num),
CONSTRAINT FK_vo_writerId	FOREIGN KEY(writerId) REFERENCES USERINFO(u_id)
)
alter table VOLUNTEERBOARD ADD PASSWD NUMBER;

CREATE SEQUENCE seq_volunteer
START WITH 1
INCREMENT BY 1
NOMAXVALUE

drop sequence seq_vol_num;

create table FACILITYBOARD(
num				NUMBER			NOT NULL,
writerId			VARCHAR2(10)	NOT NULL,
subject			VARCHAR2(20)	NOT NULL,
writedate				DATE			NOT NULL,
readCount		NUMBER			NOT NULL,
content			VARCHAR2(200)	NOT NULL,
Ref				NUMBER			NOT NULL,
re_step			NUMBER			NOT NULL,
re_level			NUMBER			NOT NULL,
CONSTRAINT PK_fa_num	PRIMARY KEY(num),
CONSTRAINT FK_fa_writerId	FOREIGN KEY(writerId) REFERENCES USERINFO(u_id)
)
alter table FACILITYBOARD ADD PASSWD NUMBER;

CREATE SEQUENCE seq_facility
START WITH 1
INCREMENT BY 1
NOMAXVALUE

drop sequence seq_fa_num;

create table CALENDARBOARD(
num				NUMBER			NOT NULL,
writerId			VARCHAR2(10)	NOT NULL,
subject			VARCHAR2(20)	NOT NULL,
writedate				DATE			NOT NULL,
readCount		NUMBER			NOT NULL,
content			VARCHAR2(200)	NOT NULL,
Ref				NUMBER			NOT NULL,
re_step			NUMBER			NOT NULL,
re_level			NUMBER			NOT NULL,
CONSTRAINT PK_cal_num	PRIMARY KEY(num),
CONSTRAINT FK_cal_writerId	FOREIGN KEY(writerId) REFERENCES USERINFO(u_id)
)
alter table CALENDARBOARD ADD PASSWD NUMBER;

CREATE SEQUENCE seq_calendar
START WITH 1
INCREMENT BY 1
NOMAXVALUE
drop sequence seq_cal_num;


create table SUGGESTIONBOARD(
num				NUMBER			NOT NULL,
writerId			VARCHAR2(10)	NOT NULL,
subject			VARCHAR2(20)	NOT NULL,
writeDate				DATE			NOT NULL,
readCount		NUMBER			NOT NULL,
content			VARCHAR2(200)	NOT NULL,
Ref				NUMBER			NOT NULL,
re_step			NUMBER			NOT NULL,
re_level			NUMBER			NOT NULL,
CONSTRAINT PK_sug_num	PRIMARY KEY(num),
CONSTRAINT FK_sug_writerId	FOREIGN KEY(writerId) REFERENCES USERINFO(u_id)
)
alter table SUGGESTIONBOARD ADD PASSWD NUMBER;
CREATE SEQUENCE seq_suggestion
START WITH 1
INCREMENT BY 1
NOMAXVALUE

drop sequence seq_sug_num;


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