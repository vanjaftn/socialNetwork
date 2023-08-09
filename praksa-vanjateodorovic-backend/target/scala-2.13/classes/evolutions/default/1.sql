# --- !Ups

CREATE TABLE `users` (
`userId` bigint NOT NULL AUTO_INCREMENT,
`emai` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
`firstname` varchar(255) NOT NULL,
`lastname` varchar(255) NOT NULL,
`photoURL` varchar(255),
PRIMARY KEY (`userId`)
);

CREATE TABLE `posts` (
`postId` bigint NOT NULL AUTO_INCREMENT,
`userId` bigint NOT NULL,
`content` varchar(1000) NOT NULL,
`timeOfCreation` timestamp NOT NULL,
PRIMARY KEY (`postId`)
);

CREATE TABLE `likes` (
`likeId` bigint NOT NULL AUTO_INCREMENT,
`userId` bigint NOT NULL,
`postId` bigint NOT NULL,
PRIMARY KEY (`likeId`)
);

CREATE TABLE `friendships` (
`friendshipId` bigint NOT NULL AUTO_INCREMENT,
`targetUserId` bigint NOT NULL,
`sourceUserId` bigint NOT NULL,
`status` varchar(10),
PRIMARY KEY (`friendshipId`)
);

# --- !Downs

DROP TABLE users;
DROP TABLE posts;
DROP TABLE likes;
DROP TABLE friendships;

