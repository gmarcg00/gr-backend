
CREATE TABLE `user`(
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `game` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `background_image` varchar(255) DEFAULT NULL,
  `background_image_additional` varchar(255) DEFAULT NULL,
  `description` varchar(2500) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `playtime` int NOT NULL,
  `released` datetime(6) DEFAULT NULL,
  `slug` varchar(255) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dh6poan27owrcnl94ufmu24nk` (`slug`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(2500) DEFAULT NULL,
  `game` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gdwr693dfx73vwkk38u1ic59x` (`game`),
  UNIQUE KEY `UK_te8k2hvfpx44ebjyi1jfaqrqr` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;