
    create table Account (
       id bigint not null auto_increment,
        createdDate datetime,
        updatedDate datetime,
        dateOfBirth date,
        firstName varchar(255),
        lastName varchar(255),
        userId bigint,
        primary key (id)
    ) engine=InnoDB;

    create table User (
       id bigint not null auto_increment,
        createdDate datetime,
        updatedDate datetime,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table User 
       add constraint UK_jreodf78a7pl5qidfh43axdfb unique (username);

    alter table Account 
       add constraint FK1txqu3l736h1mvpadcktj7js6 
       foreign key (userId) 
       references User (id);

    create table Account (
       id bigint not null auto_increment,
        createdDate datetime,
        updatedDate datetime,
        dateOfBirth date,
        firstName varchar(255),
        lastName varchar(255),
        userId bigint,
        primary key (id)
    ) engine=InnoDB;

    create table User (
       id bigint not null auto_increment,
        createdDate datetime,
        updatedDate datetime,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table User 
       add constraint UK_jreodf78a7pl5qidfh43axdfb unique (username);

    alter table Account 
       add constraint FK1txqu3l736h1mvpadcktj7js6 
       foreign key (userId) 
       references User (id);
