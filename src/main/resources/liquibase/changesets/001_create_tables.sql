create table users
(
    id serial primary key,
    username text not null,
    password text not null,
    telegram_chat_id bigint unique
);

create table company
(
    id serial primary key,
    company_tag text not null unique,
    company_name text not null
);

create table subscriptions
(
    id serial PRIMARY KEY,
    telegram_chat_id bigint REFERENCES users(telegram_chat_id),
    company_id bigint REFERENCES company(id),
    UNIQUE (telegram_chat_id, company_id)
);

create table news
(
    id bigserial primary key,
    companyTag text not null,
    content text not null
);