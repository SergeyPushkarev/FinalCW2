#Создаем БД, но перед этим удаляем, если создана
DROP DATABASE IF EXISTS Human_Friends;
CREATE DATABASE Human_Friends;
USE Human_Friends;

#Таблица общая животных
DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_name VARCHAR(50),
    date_of_birth DATE,
    weight INT NOT NULL,
    commands VARCHAR(30)
);

#Таблица для домашних животных (входит в animals)
DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

#Таблица для вьючных животных (входит в animals)
DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

#Таблица для собак (входит в pets)
DROP TABLE IF EXISTS dog;
CREATE TABLE dog(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);

#Таблица для кошек (входит в pets)
DROP TABLE IF EXISTS cat;
CREATE TABLE cat(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);

#Таблица для хомяков (входит в pets)
DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);

#Таблица для лошадей (входит в pack_animals)
DROP TABLE IF EXISTS horse;
CREATE TABLE horse(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES pack_animals(id)
);

#Таблица для верблюдов (входит в pack_animals)
DROP TABLE IF EXISTS camel;
CREATE TABLE camel(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES pack_animals(id)
);

#Таблица для ослов (входит в pack_animals)
DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES pack_animals(id)
);

#Заполняем всех животных. В одной таблице вся общая информация животных
INSERT INTO animals (animal_name,date_of_birth,weight,commands) VALUES 
	('Imperator', '2020-06-01', 5500, 'Принеси, Место'),
	('Krosha', '2019-12-10', 11000, 'Принеси, Апорт'),
    ('Summer', '2020-02-02', 7000, 'Рядом'),
    ('Ohles', '2022-03-03', 22000, 'Дай лапу, Место'),
    ('Yaromila', '2018-05-05', 15000, 'Ко мне, Сидеть, Лежать'),
    ('Stalker', '2021-05-05', 2000, 'Ко мне'),
    ('Mir', '2020-05-05', 4000, 'Стоять'),
    ('Uris', '2021-05-05', 3500, 'Ко мне, Прыжок, Принеси'),
    ('Zurna', '2022-05-05', 1500, 'Ползи, Дай лапу'),
    ('Smoke', '2019-05-05', 5000, 'Кувырок, Лежать'),
    ('Begun', '2019-12-10', 300, 'Бег, Стойка'),
    ('Silva', '2019-05-05', 450, 'Прыжок'),
    ('Cayda', '2021-01-01', 250, 'Фу, Бег'),
    ('Smayla', '2019-05-05', 550, 'Прыжок'),
    ('Lamulichka', '2018-05-05', 320, 'Кувырок, Стойка'),
    ('Sumina', '2018-05-05', 700000, 'Ну пошла'),
    ('Jihad', '2022-03-03', 650000, 'Вперед'),
    ('Portugalia', '2021-01-01', 1100000, 'Вперед, Стой'),
    ('Sorte', '2018-05-05', 900000, 'Рысь, Ну пошла'),
    ('Europa', '2019-12-10', 500000, 'Хоп, Шагом'),
    ('Fenser', '2019-12-10', 400000, 'Стой, Пошел'),
    ('Aksioma', '2019-12-10', 300000, 'Право, Лево'),
    ('Abervile', '2019-12-10', 600000, 'Лежать'),
    ('Urstan', '2019-12-10', 800000, 'Иди, Вперед'),
    ('Skor', '2019-12-10', 460000, 'Скорее, Лежать'),
    ('Ranavir', '2019-12-10', 230000, 'Стой, Вперед'),
    ('Zoya', '2019-12-10', 245000, 'Право, Лево'),
    ('Sotona', '2019-12-10', 450000, 'Стой, Вперед'),
    ('Falkor', '2019-12-10', 320000, 'Иди, Вперед'),
    ('Rio Grande', '2019-12-10', 310000, 'Право, Лево');
    
#Заполняем данные домашних животных, точнее эта таблица всего-лишь связывает виды животных с общей таблицей
INSERT INTO pets(id,animal_id) VALUES
	(1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10),
    (11, 11),
    (12, 12),
    (13, 13),
    (14, 14),
    (15, 15);

#Заполняем данные вьючныых животных, точнее эта таблица всего-лишь связывает виды животных с общей таблицей
INSERT INTO pack_animals(id,animal_id) VALUES
	(1, 16),
    (2, 17),
    (3, 18),
    (4, 19),
    (5, 20),
    (6, 21),
    (7, 22),
    (8, 23),
    (9, 24),
    (10, 25),
    (11, 26),
    (12, 27),
    (13, 28),
    (14, 29),
    (15, 30);

#Заполняем данные о собаках
INSERT INTO dog(id,pet_id) VALUES
	(1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

#Заполняем данные о кошках
INSERT INTO cat(id,pet_id) VALUES
	(1, 6),
    (2, 7),
    (3, 8),
    (4, 9),
    (5, 10);
    
#Заполняем данные о хомяках
INSERT INTO hamster(id,pet_id) VALUES
	(1, 11),
    (2, 12),
    (3, 13),
    (4, 14),
    (5, 15);
    
#Заполняем данные о лошадях
INSERT INTO horse(id,pack_animal_id) VALUES
	(1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

#Заполняем данные о верблюдах
INSERT INTO camel(id,pack_animal_id) VALUES
	(1, 6),
    (2, 7),
    (3, 8),
    (4, 9),
    (5, 10);
  
#Заполняем данные об ослах
INSERT INTO donkey(id,pack_animal_id) VALUES
	(1, 11),
    (2, 12),
    (3, 13),
    (4, 14),
    (5, 15);

#отключим контроль внешних связей чтобы избежать ошибок при удалении
SET FOREIGN_KEY_CHECKS=0;

#создаем временную таблицу для верблюдов
CREATE TEMPORARY TABLE camel_in_pack_animals AS
SELECT animal_id
FROM pack_animals
INNER JOIN camel ON camel.pack_animal_id = pack_animals.id;

#удаляем из общей таблицы всех верблюдов через внутреннюю связь с верблюдами из pack_animals
DELETE animals
FROM animals INNER JOIN camel_in_pack_animals ON camel_in_pack_animals.animal_id = animals.id;

#удаляем верблюдов из pack_animals
DELETE pack_animals
FROM pack_animals INNER JOIN camel_in_pack_animals ON camel_in_pack_animals.animal_id = pack_animals.animal_id;

#полностью удаляем таблицу верблюдов
DROP TABLE camel;

#удаляем временную таблицу
DROP TEMPORARY TABLE IF EXISTS camel_in_pack_animals;

SET FOREIGN_KEY_CHECKS=1;


#переносим ослов к лошадям
INSERT INTO horse (pack_animal_id)
SELECT pack_animal_id
FROM donkey;

#и удаляем ослов
DROP TABLE donkey;

#переименуем таблицу, т.к. теперь тут еще и ослы
RENAME TABLE horse TO horse_donkey;

#создадим таблицу для юных животых
CREATE TABLE young_animals (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_name VARCHAR(50),
    date_of_birth DATE,
    weight INT NOT NULL,
    commands VARCHAR(30),
    age TEXT
);

#это функция, которая принимает дату и расчитывает количество полных лет до текущей даты
DELIMITER $$
CREATE FUNCTION age_animal (date_b DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE res TEXT DEFAULT '';
	SET res = CONCAT(
            TIMESTAMPDIFF(YEAR, date_b, CURDATE()),
            ' years ',
            TIMESTAMPDIFF(MONTH, date_b, CURDATE()) % 12,
            ' month'
        );
	RETURN res;
END $$
DELIMITER ;

#Добавляем записи в новую таблицу тех животных, возраст которых от 0 до 2 полных лет
INSERT INTO young_animals (animal_name, date_of_birth, weight, commands, age)
SELECT animal_name, date_of_birth, weight, commands, age_animal(date_of_birth)
FROM animals
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 0 AND 2;

#Соберем полную таблицу всех животных с указанием их типа
SELECT animals.id, animals.animal_name, "Dog" AS Type, animals.date_of_birth, animals.commands
FROM dog
INNER JOIN pets ON dog.pet_id = pets.id
INNER JOIN animals ON pets.animal_id = animals.id
UNION
SELECT animals.id, animals.animal_name, "Cat" AS Type, animals.date_of_birth, animals.commands
FROM cat
INNER JOIN pets ON cat.pet_id = pets.id
INNER JOIN animals ON pets.animal_id = animals.id
UNION
SELECT animals.id, animals.animal_name, "Hamster" AS Type, animals.date_of_birth, animals.commands
FROM hamster
INNER JOIN pets ON hamster.pet_id = pets.id
INNER JOIN animals ON pets.animal_id = animals.id
UNION
SELECT animals.id, animals.animal_name, "Horse and Donkey" AS Type, animals.date_of_birth, animals.commands
FROM horse_donkey
INNER JOIN pack_animals ON horse_donkey.pack_animal_id = pack_animals.id
INNER JOIN animals ON pack_animals.animal_id = animals.id;