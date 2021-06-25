create table users
(
    pk varchar not null
        constraint users_pk
            primary key,
    title varchar not null,
    description varchar,
    create_time timestamp not null,
    update_time timestamp not null,
    organization varchar not null
);

comment on table users is '用户表';

comment on column users.pk is '主键列';

comment on column users.title is '个人名称';

comment on column users.description is '个人描述';

comment on column users.create_time is '创建时间';

comment on column users.update_time is '更新时间';

comment on column users.organization is '组织';

alter table users owner to postgres;

create unique index users_key_uindex
    on users (pk);

