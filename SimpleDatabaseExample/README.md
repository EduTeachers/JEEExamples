Sample database scheme:

```sql
create table article
(
    article_id   int auto_increment
        primary key,
    title       varchar(255) not null,
    description varchar(255) not null,
    body        text         not null
);
```

