create table ministore.product
(
    pid    int auto_increment
        primary key,
    pnm    varchar(255) not null,
    pcost  double       not null,
    pstock int          not null
);

