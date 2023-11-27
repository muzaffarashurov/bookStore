-- liquibase formatted sql

-- changeset Khasanboy-Akbarov:populate-publisher-table
INSERT INTO `bookstore`.`publisher` (`id`, `name`, `address`, `city`, `state`, `zip`)
    VALUES(1, 'SFG Publishing','Russia', 'St Petersburg', 'FL', 'RUS'),
    (2, 'Триумф','Россия', 'Москва','FT', 'RUS'),
    (3, 'Toshkent Nashr','Uzbekistan', 'Tashkent','IR','UZB');

-- changeset Khasanboy-Akbarov:populate-author-table
INSERT INTO `bookstore`.`author` (`id`, `first_name`, `last_name`) VALUES
     (1, 'Eric', 'Evans'),
    (2, 'Rod', 'Johnson'),
    (3, 'Robert', 'Pattinson'),
     (4, 'Bobur', 'Mirzo'),
     (5, 'Alisher', 'Navoiy');

-- changeset Khasanboy-Akbarov:populate-book-table
INSERT INTO `bookstore`.`book` (`id`, `publisher_id`, `title`, `isbn`) VALUES
 (1, 1, 'J2EE Development without EJB', '3939459459'),
 (2, 1, 'Domain Driven Design', '242121212'),
 (3, 2, 'Война миров', '368-749654'),
 (4, 3, 'Ming bir kecha', '9878-362'),
 (5, 3, 'Xamsa', '8974-362');

-- changeset Khasanboy-Akbarov:populate-author_book-table
INSERT INTO `bookstore`.`author_book` (`author_id`, `book_id`) VALUES
 (1, 1),
 (2, 2),
 (3, 3),
 (4, 4),
 (5, 5);