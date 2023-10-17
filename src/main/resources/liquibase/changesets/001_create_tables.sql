create table users
(
    id serial primary key,
    username text not null,
    password text not null,
    telegramChatId bigint unique
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
    id serial primary key,
    user_telegramchatid bigint references users(telegramChatId),
    company_tag text not null ,
    unique (user_telegramchatid, company_tag)
);

create table news
(
    id bigserial primary key,
    company_tag text not null,
    content text not null
);