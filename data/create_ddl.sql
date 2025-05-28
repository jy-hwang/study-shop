DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `partner`;
DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `order_detail`;
DROP TABLE IF EXISTS `order_group`;
DROP TABLE IF EXISTS `admin_user`;

CREATE TABLE `category`
(
  `id`         bigint(20) NOT NULL AUTO_INCREMENT,
  `type`       varchar(50)        DEFAULT NULL,
  `title`      varchar(100)       DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `created_by` varchar(20)        DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `updated_by` varchar(20)        DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `users`
(
  `id`              bigint(20) NOT NULL AUTO_INCREMENT,
  `account`         varchar(12)        DEFAULT NULL,
  `password`        varchar(100)       DEFAULT NULL,
  `status`          varchar(50)        DEFAULT NULL,
  `email`           bigint(100) DEFAULT 0,
  `phone_number`    varchar(100)       DEFAULT NULL,
  `registered_at`   timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `unregistered_at` datetime NULL DEFAULT NULL,
  `created_at`      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `created_by`      varchar(20)        DEFAULT NULL,
  `updated_at`      datetime NULL DEFAULT NULL,
  `updated_by`      varchar(20)        DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `partner`
(
  `id`              bigint(20) NOT NULL AUTO_INCREMENT,
  `name`            varchar(100)       DEFAULT NULL,
  `status`          varchar(50)        DEFAULT NULL,
  `address`         varchar(100)       DEFAULT NULL,
  `call_center`     varchar(13)        DEFAULT NULL,
  `partner_number`  varchar(13)        DEFAULT NULL,
  `business_number` varchar(16)        DEFAULT NULL,
  `ceo_name`        varchar(20)        DEFAULT NULL,
  `registered_at`   timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `unregistered_at` datetime NULL DEFAULT NULL,
  `created_at`      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `created_by`      varchar(20)        DEFAULT NULL,
  `updated_at`      datetime NULL DEFAULT NULL,
  `updated_by`      varchar(20)        DEFAULT NULL,
  `category_id`     bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `item`
(
  `id`              bigint(20) NOT NULL AUTO_INCREMENT,
  `status`          varchar(50)        DEFAULT NULL,
  `name`            varchar(100)       DEFAULT NULL,
  `title`           varchar(100)       DEFAULT NULL,
  `content`         text               DEFAULT NULL,
  `price`           decimal(12, 4)     DEFAULT 0,
  `brand_name`      varchar(50)        DEFAULT NULL,
  `registered_at`   timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `unregistered_at` datetime NULL DEFAULT NULL,
  `created_at`      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `created_by`      varchar(20)        DEFAULT NULL,
  `updated_at`      datetime NULL DEFAULT NULL,
  `updated_by`      varchar(20)        DEFAULT NULL,
  `partner_id`      bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `order_detail`
(
  `id`             bigint(20) NOT NULL AUTO_INCREMENT,
  `status`         varchar(50)        DEFAULT NULL,
  `name`           varchar(100)       DEFAULT NULL,
  `arrival_date`   datetime NULL DEFAULT NULL,
  `quantity`       int                DEFAULT 0,
  `total_price`    decimal(12, 4)     DEFAULT 0,
  `created_at`     timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `created_by`     varchar(20)        DEFAULT NULL,
  `updated_at`     datetime NULL DEFAULT NULL,
  `updated_by`     varchar(20)        DEFAULT NULL,
  `order_group_id` bigint(20) NOT NULL,
  `item_id`        bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `order_group`
(
  `id`             bigint(20) NOT NULL AUTO_INCREMENT,
  `status`         varchar(50)        DEFAULT NULL,
  `order_type`     varchar(50)        DEFAULT NULL,
  `rev_address`    text               DEFAULT NULL,
  `rev_name`       varchar(50)        DEFAULT NULL,
  `payment_type`   varchar(50)        DEFAULT NULL,
  `total_price`    decimal(12, 4)     DEFAULT 0,
  `total_quantity` int                DEFAULT 0,
  `order_at`       datetime NULL DEFAULT NULL,
  `arrival_date`   datetime NULL DEFAULT NULL,
  `created_at`     timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `created_by`     varchar(20)        DEFAULT NULL,
  `updated_at`     timestamp NULL DEFAULT NULL,
  `updated_by`     varchar(20)        DEFAULT NULL,
  `user_id`        bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `admin_user`
(
  `id`                  bigint(20) NOT NULL AUTO_INCREMENT,
  `account`             varchar(12)        DEFAULT NULL,
  `password`            varchar(100)       DEFAULT NULL,
  `status`              varchar(50)        DEFAULT NULL,
  `role`                varchar(50)        DEFAULT NULL,
  `last_login_at`       datetime NULL DEFAULT NULL,
  `password_updated_at` datetime NULL DEFAULT NULL,
  `login_fail_count`    int                DEFAULT 0,
  `registered_at`       timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `unregistered_at`     datetime NULL DEFAULT NULL,
  `created_at`          timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `created_by`          varchar(20)        DEFAULT NULL,
  `updated_at`          datetime NULL DEFAULT NULL,
  `updated_by`          varchar(20)        DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;