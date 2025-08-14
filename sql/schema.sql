-- This file was created using Derby's dblook utility.
-- Timestamp: 2025-08-13 19:57:31.964
-- Source database is: CourseSchedulerDBMegan
-- Connection URL is: jdbc:derby://localhost:1527/CourseSchedulerDBMegan;user=java;password=java
-- Specified schema is: JAVA
-- appendLogs: false

-- ----------------------------------------------
-- DDL Statements for schemas
-- ----------------------------------------------

CREATE SCHEMA "JAVA";

-- ----------------------------------------------
-- DDL Statements for tables
-- ----------------------------------------------

CREATE TABLE "JAVA"."SCHEDULE" ("SEMESTER" VARCHAR(30) NOT NULL, "COURSECODE" VARCHAR(30) NOT NULL, "STUDENTID" VARCHAR(20) NOT NULL, "STATUS" VARCHAR(20), "TIMESTAMP" TIMESTAMP);

CREATE TABLE "JAVA"."CLASS" ("SEMESTER" VARCHAR(30) NOT NULL, "COURSECODE" VARCHAR(30) NOT NULL, "SEATS" INTEGER);

CREATE TABLE "JAVA"."SEMESTER" ("SEMESTER" VARCHAR(30) NOT NULL);

CREATE TABLE "JAVA"."STUDENT" ("STUDENTID" VARCHAR(30) NOT NULL, "FIRSTNAME" VARCHAR(30), "LASTNAME" VARCHAR(30));

CREATE TABLE "JAVA"."COURSE" ("COURSECODE" VARCHAR(30) NOT NULL, "DESCRIPTION" VARCHAR(30));

-- ----------------------------------------------
-- DDL Statements for keys
-- ----------------------------------------------

-- PRIMARY/UNIQUE
ALTER TABLE "JAVA"."STUDENT" ADD CONSTRAINT "SQL0000000010-2f2f02c8-0196-a724-5df3-fffffb636028" PRIMARY KEY ("STUDENTID");

ALTER TABLE "JAVA"."SCHEDULE" ADD CONSTRAINT "SQL0000000005-1eeac1ee-0196-a724-5df3-fffffb636028" PRIMARY KEY ("SEMESTER", "COURSECODE", "STUDENTID");

ALTER TABLE "JAVA"."SEMESTER" ADD CONSTRAINT "SQL0000000007-a2d60250-0196-a724-5df3-fffffb636028" PRIMARY KEY ("SEMESTER");
