CREATE TABLE IF NOT EXISTS `todo` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `text` varchar(20),
    `completed` int

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;