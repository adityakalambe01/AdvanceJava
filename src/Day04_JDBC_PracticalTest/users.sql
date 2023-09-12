CREATE DATABASE `tka` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */

create table tka.users
(
    username     varchar(255) not null,
    password     varchar(255) null,
    mobileNumber bigint       null,
    emailId      varchar(255) null
);

