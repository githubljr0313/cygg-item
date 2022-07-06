create DATABASE cygg;

truncate table sku_po;
CREATE TABLE IF NOT EXISTS `sku_po` (
    `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
    `created_at` datetime DEFAULT NULL,
    `created_by` varchar(256) DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    `updated_by` varchar(256) DEFAULT NULL,
    `sku_code` varchar(256) DEFAULT NULL,
    `sku_name` varchar(256) DEFAULT NULL,
    `color` varchar(256) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;