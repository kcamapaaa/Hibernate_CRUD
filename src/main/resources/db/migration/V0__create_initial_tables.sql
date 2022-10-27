CREATE TABLE "specialties"(
    id bigserial primary key,
    name varchar(50) not null
);

CREATE TABLE "skills"(
    id bigserial primary key,
    name varchar(50) not null
);

CREATE TABLE "developers"(
    id bigserial primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    status varchar(7) not null,
    specialty_id int references specialties ON DELETE CASCADE,
    constraint fk_developers_specialties
        foreign key (specialty_id)
            REFERENCES specialties (id)
);

CREATE TABLE "skills_developers"(
    developer_id int,
    skill_id int,
    CONSTRAINT skills_developers_pk PRIMARY KEY (developer_id, skill_id),
    CONSTRAINT fk_developer
    FOREIGN KEY (developer_id) REFERENCES developers (id),
    CONSTRAINT fk_skill
    FOREIGN KEY (skill_id) REFERENCES skills (id)
)