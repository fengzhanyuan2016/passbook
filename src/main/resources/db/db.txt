表结构设计
商户信息(Mysql)
id
name
logo_url
business_license_url
phone
address
is_audit

优惠卷信息(Hbase)
passtemplate
base:id title summary desc has_token background
o: limit start end


Token信息(file)






用户应用系统
pass
info:user_id template_id token assigned_date con_date
feedback
info:user_id type template_id comment

id生成器
user
base:name age sex
o:phone address
Rowkey:用户总数+5随机数


docker run -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=192.168.2.15 -e ADVERTISED_PORT=9092 spotify/kafka



CREATE TABLE `merchants` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(256) COLLATE utf8_bin NOT NULL,
  `business_license_url` varchar(256) COLLATE utf8_bin NOT NULL,
  `phone` varchar(20) COLLATE utf8_bin NOT NULL,
  `address` varchar(256) COLLATE utf8_bin NOT NULL,
  `is_audit` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

