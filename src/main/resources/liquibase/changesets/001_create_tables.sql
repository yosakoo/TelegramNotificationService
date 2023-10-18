create table users
(
    id serial primary key,
    username text not null,
    password text not null,
    telegram_сhat_id bigint unique
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
    user_telegram_chat_id bigint REFERENCES users(telegram_сhat_id),
    company_tag text REFERENCES company(company_tag),
    UNIQUE (user_telegram_chat_id, company_tag)
);

create table news
(
    id bigserial primary key,
    companyTag text not null,
    content text not null
);