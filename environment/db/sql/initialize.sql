CREATE DATABASE IF NOT EXISTS realize;
USE realize;

CREATE TABLE IF NOT EXISTS diaries (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(255) NOT NULL,
		`body` text NOT NULL,
		`author` varchar(255) NOT NULL,
		`release_date` datetime NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO diaries (id, title, body, author, release_date) VALUES
	(1, 'タイトル1', '本文1', 'watanabe', cast('2009-08-03' as date));

INSERT INTO diaries (id, title, body, author, release_date) VALUES
	(2, 'タイトル2', '本文2', 'yamada', cast('2010-08-03' as date));