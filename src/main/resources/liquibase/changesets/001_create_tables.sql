create table users
(
    id serial primary key,
    username text not null,
    password text not null,
    user_telegram_chat_id bigint unique
);

-- company table
create table company
(
    id serial primary key,
    company_tag text not null unique,
    company_name text not null
);

-- subscription table
create table subscription
(
    id serial PRIMARY KEY,
    telegram_chat_id bigint REFERENCES users(user_telegram_chat_id),
    company_id bigint REFERENCES company(id),
    UNIQUE (telegram_chat_id, company_id)
);

create table news
(
    id bigserial primary key,
    companyTag text not null,
    content text not null
);