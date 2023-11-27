INSERT INTO `bookstore`.`publisher` (`id`, `name`, `address`, `city`, `state`, `zip`) VALUES (1, 'SFG Publishing','Russia', 'St Petersburg', 'FL', 'RUS');
INSERT INTO `bookstore`.`publisher` (`id`, `name`, `address`, `city`, `state`, `zip`) VALUES (2, 'Триумф','Россия', 'Москва','FT', 'RUS');
INSERT INTO `bookstore`.`publisher` (`id`, `name`, `address`, `city`, `state`, `zip`) VALUES (3, 'Toshkent Nashr','Uzbekistan', 'Tashkent','IR','UZB');

INSERT INTO `bookstore`.`author` (`id`, `first_name`, `last_name`) VALUES (1, 'Eric', 'Evans');
INSERT INTO `bookstore`.`author` (`id`, `first_name`, `last_name`) VALUES (2, 'Rod', 'Johnson');
INSERT INTO `bookstore`.`author` (`id`, `first_name`, `last_name`) VALUES (3, 'Robert', 'Pattinson');
INSERT INTO `bookstore`.`author` (`id`, `first_name`, `last_name`) VALUES (4, 'Bobur', 'Mirzo');
INSERT INTO `bookstore`.`author` (`id`, `first_name`, `last_name`) VALUES (5, 'Alisher', 'Navoiy');

INSERT INTO `bookstore`.`book` (`id`, `publisher_id`, `title`, `isbn`) VALUES (1, 1, 'J2EE Development without EJB', '3939459459');
INSERT INTO `bookstore`.`book` (`id`, `publisher_id`, `title`, `isbn`) VALUES (2, 1, 'Domain Driven Design', '242121212');
INSERT INTO `bookstore`.`book` (`id`, `publisher_id`, `title`, `isbn`) VALUES (3, 2, 'Война миров', '368-749654');
INSERT INTO `bookstore`.`book` (`id`, `publisher_id`, `title`, `isbn`) VALUES (4, 3, 'Ming bir kecha', '9878-362');
INSERT INTO `bookstore`.`book` (`id`, `publisher_id`, `title`, `isbn`) VALUES (5, 3, 'Xamsa', '8974-362');

INSERT INTO `bookstore`.`author_book` (`author_id`, `book_id`) VALUES (1, 1);
INSERT INTO `bookstore`.`author_book` (`author_id`, `book_id`) VALUES (2, 2);
INSERT INTO `bookstore`.`author_book` (`author_id`, `book_id`) VALUES (3, 3);
INSERT INTO `bookstore`.`author_book` (`author_id`, `book_id`) VALUES (4, 4);
INSERT INTO `bookstore`.`author_book` (`author_id`, `book_id`) VALUES (5, 5);