insert into product (id, description, price) values (1, 'notebook', 3500);
insert into product (id, description, price) values (2, 'mouse', 30);

insert into role (id, name) values (1, 'ADMIN');
insert into role (id, name) values (2, 'USER');

-- senha 123
insert into user (id, username, password) values (1, 'admin', '$2a$12$HfRkK9TdZGJCN52q2ZZcNOndkfOZPcfEeKgJhE1ZImgZ9iyxRHDGu');
insert into user (id, username, password) values (2, 'chris', '$2a$12$HfRkK9TdZGJCN52q2ZZcNOndkfOZPcfEeKgJhE1ZImgZ9iyxRHDGu');

insert into user_roles (user_id, roles_id) values (1, 1);
insert into user_roles (user_id, roles_id) values (2, 2);