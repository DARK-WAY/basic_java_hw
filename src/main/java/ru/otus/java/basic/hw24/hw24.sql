-- таблица тестов
create table hw.tests  (
id serial4 not null primary key,    -- ид
title text not null,				-- наименование  теста
code varchar(20) not null,			-- буквенный код теста
min_age int not null default(0),	-- минимальный возраст для прохождения
max_age int not null default(99)    -- максимальный возраст для прохождения
);

create unique index hw.tests_code_idx on hw.tests (code); -- индекс для поиска по буквенному коду

insert into hw.tests (title, code, min_age, max_age) values
('Простоые аналогии', 'ANALOGY_EASY', 6, 7),
('Деревня для младших дошколят', 'VILLAGE_BEGIN', 4, 5  );

select * from  hw.tests;

-- Таблица заданий в тесте
create table hw.questions (
id int not null primary key,    -- идентификатор вопроса
task text not null,	                 -- текст вопроса/задания
tests_id int not null,				-- ссылка  на тест
level_id int not null default(0)   	-- уровень сложности
);

-- поставим FK на привязку вопроса к тесту
alter table hw.questions add constraint questions_fk foreign key (tests_id) references hw.tests(id);

insert into hw.questions (id, task, tests_id, level_id) values
(1, 'Кошка — котенок, Собака — ...', (select id from hw.tests where code ='ANALOGY_EASY' ), 1 ),
(2, 'Орех — скорлупа, Банан — ...', (select id from hw.tests where code ='ANALOGY_EASY' ), 1 ),
(3, 'Дождь — лужи, Снег — ...', (select id from hw.tests where code ='ANALOGY_EASY' ), 1 ),
(4, 'Что растет в огороде?', (select id from hw.tests where code ='VILLAGE_BEGIN' ), 1 ),
(5, 'Что не растет в саду?', (select id from hw.tests where code ='VILLAGE_BEGIN' ), 1 );

-- ответы
create table hw.answers (
id serial4 not null primary key,    -- идентификатор ответа
answer_option text not null,	    -- вариант ответа
task_id int not null,				-- ссылка  на задание
is_correct boolean not null    	    -- правильный  ответ или  нет ( true/false)
);


-- поставим FK на привязку ответа к вопросу
alter table hw.answers add constraint answers_fk foreign key (task_id) references hw.questions(id);

insert into hw.answers(answer_option, task_id , is_correct) values
('мячик', 1, false),
('хвост', 1, false),
('будка', 1, false),
('щенок', 1, true),
('ребенок', 1, false),
('обезьяна', 2, false),
('пальма', 2, false),
('ананас', 2, false),
('кушать', 2, false),
('кожура', 2, true),
('холод', 3, false),
('зима', 3, false),
('лето', 3, false),
('спать', 3, false),
('сугробы', 3, true),
('яблоки', 4, false),
('капуста', 4, true),
('вишня', 4, false),
('клуюника', 4, true),
('слива', 5, false),
('груши', 5, false),
('черешня', 5, false),
('картошка', 5, true)


-- получить информацию о тесте Простоые аналогии
select * from hw.tests t where t.code = 'ANALOGY_EASY'

--получить все вопросы и к ним правильные  ответы в тесте Деревня для младших дошколят
select t.title, q.task, a.answer_option
from hw.tests t
inner join hw.questions q on q.tests_id  = t.id
inner join hw.answers a on a.task_id =q.id and a.is_correct
where t.code = 'VILLAGE_BEGIN'




