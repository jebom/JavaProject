--♥=====================================================================
-- 2021-01-25, 26 >
-- SHELTER TABLE
DROP TABLE SHELTER;
CREATE TABLE SHELTER(
    SID     NVARCHAR2(10) PRIMARY KEY,  -- 아이디
    SPW     NVARCHAR2(10),              -- 비밀번호
    SNAME   NVARCHAR2(5),               -- 이름
    SADDR   NVARCHAR2(10),              -- 주소
    SPHONE  NVARCHAR2(13),              -- 연락처
    SEMAIL  NVARCHAR2(20)               -- 이메일
);
SELECT * FROM SHELTER;

-- DOG TABLE
DROP TABLE DOG;
CREATE TABLE DOG(
    SNUM        NVARCHAR2(10) PRIMARY KEY,      -- 공고번호
    SDATE       NVARCHAR2(10) NOT NULL,         -- 접수일자
    SBREED      NVARCHAR2(10) NOT NULL,         -- 품종
    SGENDER     NVARCHAR2(2) NOT NULL,          -- 성별
    SCHAR       NVARCHAR2(20),                  -- 특징
    SESTIAGE    NVARCHAR2(3)                    -- 추정나이
);
INSERT INTO DOG VALUES('1007', '22', '골든리트리버', '남아', '11', '11');
SELECT * FROM DOG WHERE SBREED = '골든리트리버';
UPDATE DOG SET SNUM = 25, SDATE = '891125' WHERE SNUM = '최윤선';
SELECT * FROM DOG;
COMMIT;
ROLLBACK;     

-- DONATE TABLE
DROP TABLE DONATE;
CREATE TABLE DONATE(
    DID       NVARCHAR2(10),    -- 아이디   
    DONATION  NUMBER(10)        -- 기부금
);         
-- SELECT * FROM DONATE WHERE DID = ;

-- INSERT INTO DONATE VALUES ('seon', 20000);
-- UPDATE DONATE SET DONATION = DONATION + 10000 WHERE DID = 'seon';
SELECT * FROM DONATE;
COMMIT;
------------------------------------------------------------------------
