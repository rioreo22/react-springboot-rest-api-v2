CREATE TABLE clothes
(
    clothes_id   BINARY(16) PRIMARY KEY,
    clothes_name VARCHAR(20)  NOT NULL,
    category     VARCHAR(50)  NOT NULL,
    price        BIGINT       NOT NULL,
    description  VARCHAR(500) DEFAULT NULL,
    created_at   datetime(6)  NOT NULL,
    updated_at   datetime(6)  DEFAULT NULL,
    image_path   VARCHAR(500) NOT NULL
);

CREATE TABLE orders
(
    order_id     binary(16) primary key,
    email        varchar(50)  not null,
    address      varchar(200) not null,
    postcode     varchar(200) not null,
    order_status varchar(50)  not null,
    created_at   datetime(6)  not null,
    updated_at   datetime(6) default null
);


create table order_items
(
    seq        bigint      not null primary key auto_increment,
    order_id   binary(16)  not null,
    clothes_id binary(16)  not null,
    category   varchar(50) not null,
    price      bigint      not null,
    quantity   int         not null,
    created_at datetime(6) not null,
    updated_at datetime(6) default null,
    index (order_id),
    constraint fk_order_items_to_order FOREIGN KEY (order_id) references orders (order_id) on delete cascade,
    constraint fk_order_items_to_clothes foreign key (clothes_id) references clothes (clothes_id)
)

