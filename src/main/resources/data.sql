insert into user
values (10001, sysdate(), 'AB');
insert into user
values (10002, sysdate(), 'Jacek');
insert into user
values (10003, sysdate(), 'Jill');

insert into post
values (11001, sysdate(), 'My first post', 10001);
insert into post
values (11002, sysdate(), 'My second post', 10001);

-- insert into USER_POSTS values (10001, 11001);
-- insert into USER_POSTS values (10001, 11002);