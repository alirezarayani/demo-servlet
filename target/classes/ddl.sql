/*Create Table*/
create table "Accessor"
(
    "AccessorCode" VARCHAR2(60) not null
        constraint ACCESSOR_PK
        primary key,
    "personID"     NUMBER(9)    not null,
    Password       VARCHAR2(60) not null,
    "Enabled"      CHAR,
    "NoOfAttempts" NUMBER,
    "ExpiryDate"   DATE,
    "ModPersonID"  NUMBER       not null,
    "ModTime"      DATE         not null,
    "VerifyCode"   VARCHAR2(60)
)

