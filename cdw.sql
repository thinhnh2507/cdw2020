/*
 Navicat Premium Data Transfer

 Source Server         : thinhnh
 Source Server Type    : MySQL
 Source Server Version : 100413
 Source Host           : localhost:3306
 Source Schema         : cdw

 Target Server Type    : MySQL
 Target Server Version : 100413
 File Encoding         : 65001

 Date: 25/08/2020 20:49:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chitiethoadon
-- ----------------------------
DROP TABLE IF EXISTS `chitiethoadon`;
CREATE TABLE `chitiethoadon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_hoadon` bigint(20) NULL DEFAULT NULL,
  `id_sanpham` bigint(255) NULL DEFAULT NULL COMMENT ' ',
  `soluong` float(255, 0) NULL DEFAULT NULL,
  `giaban` float(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKl6het11vcn4pd2c579fyvxf1q`(`id_hoadon`) USING BTREE,
  INDEX `FKcbyuy50y2in060e8mjmlnb6rf`(`id_sanpham`) USING BTREE,
  CONSTRAINT `FKl6het11vcn4pd2c579fyvxf1q` FOREIGN KEY (`id_hoadon`) REFERENCES `hoadon` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKcbyuy50y2in060e8mjmlnb6rf` FOREIGN KEY (`id_sanpham`) REFERENCES `sanpham` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of chitiethoadon
-- ----------------------------
INSERT INTO `chitiethoadon` VALUES (1, 1, 75, 1, 1000000);
INSERT INTO `chitiethoadon` VALUES (2, 1, 76, 1, 750000);
INSERT INTO `chitiethoadon` VALUES (3, 1, 77, 1, 769000);
INSERT INTO `chitiethoadon` VALUES (4, 1, 78, 1, 500000);
INSERT INTO `chitiethoadon` VALUES (5, 2, 81, 1, 250000);
INSERT INTO `chitiethoadon` VALUES (6, 2, 77, 1, 769000);
INSERT INTO `chitiethoadon` VALUES (7, 3, 93, 1, 3900000);
INSERT INTO `chitiethoadon` VALUES (8, 3, 76, 1, 750000);
INSERT INTO `chitiethoadon` VALUES (9, 4, 79, 1, 699000);
INSERT INTO `chitiethoadon` VALUES (10, 5, 90, 1, 200);
INSERT INTO `chitiethoadon` VALUES (11, 6, 95, 1, 1500000);
INSERT INTO `chitiethoadon` VALUES (12, 6, 81, 1, 250000);
INSERT INTO `chitiethoadon` VALUES (13, 7, 89, 1, 200000);
INSERT INTO `chitiethoadon` VALUES (14, 8, 78, 1, 500000);
INSERT INTO `chitiethoadon` VALUES (15, 8, 77, 1, 769000);
INSERT INTO `chitiethoadon` VALUES (16, 9, 75, 1, 1000000);
INSERT INTO `chitiethoadon` VALUES (17, 10, 76, 1, 750000);
INSERT INTO `chitiethoadon` VALUES (18, 11, 82, 1, 245000);
INSERT INTO `chitiethoadon` VALUES (19, 11, 81, 1, 250000);

-- ----------------------------
-- Table structure for danhmuc
-- ----------------------------
DROP TABLE IF EXISTS `danhmuc`;
CREATE TABLE `danhmuc`  (
  `id_danhmuc` bigint(20) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `motadanhmuc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_danhmuc`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of danhmuc
-- ----------------------------
INSERT INTO `danhmuc` VALUES (22, 'Giày Nam', 'Giày Nam');
INSERT INTO `danhmuc` VALUES (23, 'Giày Nữ', 'Giày Nữ');
INSERT INTO `danhmuc` VALUES (24, 'Giày Bé Trai', 'Giày Bé Trai');
INSERT INTO `danhmuc` VALUES (25, 'Giày Bé Gái', 'Giày Bé Gái');

-- ----------------------------
-- Table structure for hoadon
-- ----------------------------
DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE `hoadon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(255) NULL DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sdt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tongtien` float(255, 0) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKagf464jk4re83xp7freow7p0c`(`id_user`) USING BTREE,
  CONSTRAINT `FKagf464jk4re83xp7freow7p0c` FOREIGN KEY (`id_user`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hoadon
-- ----------------------------
INSERT INTO `hoadon` VALUES (1, 5, 'thu duc', '09090909', 3019000, 'admin');
INSERT INTO `hoadon` VALUES (2, 5, 'thu duc', '09090909', 1019000, 'admin');
INSERT INTO `hoadon` VALUES (3, 6, 'hcm', '099999', 4650000, 'user');
INSERT INTO `hoadon` VALUES (4, 6, 'hcm', '099999', 699000, 'user');
INSERT INTO `hoadon` VALUES (5, 6, 'hcm', '099999', 200, 'user');
INSERT INTO `hoadon` VALUES (6, 16, 'dh nong lam', '090909', 1750000, 'thinh');
INSERT INTO `hoadon` VALUES (7, 16, 'dh nong lam', '090909', 200000, 'thinh');
INSERT INTO `hoadon` VALUES (8, 16, 'dh nong lam', '090909', 1269000, 'thinh');
INSERT INTO `hoadon` VALUES (9, 5, 'thu duc', '09090909', 1000000, 'admin');
INSERT INTO `hoadon` VALUES (10, 16, 'dh nong lam', '090909', 835000, 'thinh');
INSERT INTO `hoadon` VALUES (11, 5, 'thu duc', '09090909', 554500, 'admin');

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images`  (
  `id_img` bigint(255) NOT NULL AUTO_INCREMENT,
  `name_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_sanpham` bigint(255) NOT NULL,
  PRIMARY KEY (`id_img`) USING BTREE,
  INDEX `FKg9jm24huaujoorxialei7oqh0`(`id_sanpham`) USING BTREE,
  CONSTRAINT `FKg9jm24huaujoorxialei7oqh0` FOREIGN KEY (`id_sanpham`) REFERENCES `sanpham` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_img` FOREIGN KEY (`id_sanpham`) REFERENCES `sanpham` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES (61, 'dsmh03601__2__78b2ad04120943db9bea01d9cc14e94d_1024x1024.jpg', 75);
INSERT INTO `images` VALUES (62, 'dsmh03601__3__ad797cc9fb1c42648a32a15dc78aed0c_1024x1024.jpg', 75);
INSERT INTO `images` VALUES (63, 'dsmh03601__5__8719ed33bb77479ca3ec5a8a9b93db7c_1024x1024.jpg', 75);
INSERT INTO `images` VALUES (64, 'dsmh03601__6__f6b1557581274c618614d1dc1332fed1_1024x1024.jpg', 75);
INSERT INTO `images` VALUES (65, 'dsmh03700__1__829f774f86434d21b14f108a750b02de_1024x1024.jpg', 76);
INSERT INTO `images` VALUES (66, 'dsmh03700__3__7892d2da655e4552b042a6acfff9e284_1024x1024.jpg', 76);
INSERT INTO `images` VALUES (67, 'dsmh03700__6__cfc2604ea8ad4abbb95e87407d4d14b8_1024x1024.jpg', 76);
INSERT INTO `images` VALUES (68, 'dsmh03700__7__0f9b3ca1446044b993f82652f357218c_1024x1024.jpg', 76);
INSERT INTO `images` VALUES (69, 'nau-1_32d9908c8a354337bd50a0230f08f191_master.jpg', 77);
INSERT INTO `images` VALUES (70, 'nau-2_5a12054678094217a61a47bcf3b82ea2_master.jpg', 77);
INSERT INTO `images` VALUES (71, 'nau-3_b3cb2d3e4f4141838dae155a3b1540e8_master.jpg', 77);
INSERT INTO `images` VALUES (72, 'nau-4_e9676701c3eb49e2a2e1a264e4a9a3b1_master.jpg', 77);
INSERT INTO `images` VALUES (73, 'dsc_0130_680d78ff57c846d5bf8edb58c2f6dbca_1024x1024.jpg', 78);
INSERT INTO `images` VALUES (74, 'dsc_0131_df76de934869484c89323579b8db0157_1024x1024.jpg', 78);
INSERT INTO `images` VALUES (75, 'dsmh03601__2__78b2ad04120943db9bea01d9cc14e94d_1024x1024.jpg', 78);
INSERT INTO `images` VALUES (76, 'dsmh03601__3__ad797cc9fb1c42648a32a15dc78aed0c_1024x1024.jpg', 78);
INSERT INTO `images` VALUES (77, '03602hog__1__223aa11e84d043d98bf92a032d7f084d_1024x1024.jpg', 79);
INSERT INTO `images` VALUES (78, '03602hog__2__e992a9f68bf14ae6b7cee69816b808fa_1024x1024.jpg', 79);
INSERT INTO `images` VALUES (79, '03602hog__3__7344b42ed4a14a838f1f565685998dd1_1024x1024.jpg', 79);
INSERT INTO `images` VALUES (80, '03602hog__4__d0f7ebe1585248c6a1c1c7af6c250946_1024x1024.jpg', 79);
INSERT INTO `images` VALUES (81, 'dsc_0130_680d78ff57c846d5bf8edb58c2f6dbca_1024x1024.jpg', 80);
INSERT INTO `images` VALUES (82, 'dsmh03601__3__ad797cc9fb1c42648a32a15dc78aed0c_1024x1024.jpg', 80);
INSERT INTO `images` VALUES (83, 'dsmh03601__5__8719ed33bb77479ca3ec5a8a9b93db7c_1024x1024.jpg', 80);
INSERT INTO `images` VALUES (84, 'dsmh03700__6__cfc2604ea8ad4abbb95e87407d4d14b8_1024x1024.jpg', 80);
INSERT INTO `images` VALUES (85, 'deb006900xam__1__50cc01f8d1dd4c1b98578ea88d4fa3e9_1024x1024.jpg', 81);
INSERT INTO `images` VALUES (86, 'deb006900xam__2__a5f61d2c7d1f476b95de008663f221c7_1024x1024.jpg', 81);
INSERT INTO `images` VALUES (87, 'deb006900xam__8__785c86e2a0b14cd2baaa759fd482ee9e_1024x1024.jpg', 81);
INSERT INTO `images` VALUES (88, 'deb006900xam__10__d4da8d8e6026407cb7218055513c4f39_1024x1024.jpg', 81);
INSERT INTO `images` VALUES (89, 'deb006900doo__1__8ffecb63a0e644228f126fe514c3884c_1024x1024.jpg', 82);
INSERT INTO `images` VALUES (90, 'deb006900doo__2__59710823483747fc8f2a6b0121d2eb00_1024x1024.jpg', 82);
INSERT INTO `images` VALUES (91, 'deb006900doo__3__cf5fc49cdf9f464cadf8d3fabbf4c6ef_1024x1024.jpg', 82);
INSERT INTO `images` VALUES (92, 'deb006900doo__6__19ba4e8db4064fdc83ce596792a032ba_1024x1024.jpg', 82);
INSERT INTO `images` VALUES (99, '03602hog__1__223aa11e84d043d98bf92a032d7f084d_1024x1024.jpg', 87);
INSERT INTO `images` VALUES (100, '03602hog__2__e992a9f68bf14ae6b7cee69816b808fa_1024x1024.jpg', 87);
INSERT INTO `images` VALUES (101, '03602hog__3__7344b42ed4a14a838f1f565685998dd1_1024x1024.jpg', 87);
INSERT INTO `images` VALUES (102, '03602hog__4__d0f7ebe1585248c6a1c1c7af6c250946_1024x1024.jpg', 87);
INSERT INTO `images` VALUES (103, 'dsmh03601__2__78b2ad04120943db9bea01d9cc14e94d_1024x1024.jpg', 88);
INSERT INTO `images` VALUES (104, 'dsmh03601__3__ad797cc9fb1c42648a32a15dc78aed0c_1024x1024.jpg', 88);
INSERT INTO `images` VALUES (105, 'dsmh03601__5__8719ed33bb77479ca3ec5a8a9b93db7c_1024x1024.jpg', 88);
INSERT INTO `images` VALUES (106, 'dsmh03601__6__f6b1557581274c618614d1dc1332fed1_1024x1024.jpg', 88);
INSERT INTO `images` VALUES (107, 'deb006900doo__1__8ffecb63a0e644228f126fe514c3884c_1024x1024.jpg', 89);
INSERT INTO `images` VALUES (108, 'deb006900doo__2__59710823483747fc8f2a6b0121d2eb00_1024x1024.jpg', 89);
INSERT INTO `images` VALUES (109, 'deb006900doo__3__cf5fc49cdf9f464cadf8d3fabbf4c6ef_1024x1024.jpg', 89);
INSERT INTO `images` VALUES (110, 'deb006900doo__6__19ba4e8db4064fdc83ce596792a032ba_1024x1024.jpg', 89);
INSERT INTO `images` VALUES (111, 'deb006900xam__1__50cc01f8d1dd4c1b98578ea88d4fa3e9_1024x1024.jpg', 90);
INSERT INTO `images` VALUES (112, 'deb006900xam__2__a5f61d2c7d1f476b95de008663f221c7_1024x1024.jpg', 90);
INSERT INTO `images` VALUES (113, 'deb006900xam__8__785c86e2a0b14cd2baaa759fd482ee9e_1024x1024.jpg', 90);
INSERT INTO `images` VALUES (114, 'deb006900xam__10__d4da8d8e6026407cb7218055513c4f39_1024x1024.jpg', 90);
INSERT INTO `images` VALUES (121, 'dsmh03700__6__cfc2604ea8ad4abbb95e87407d4d14b8_1024x1024.jpg', 93);
INSERT INTO `images` VALUES (122, 'dsmh03700__7__0f9b3ca1446044b993f82652f357218c_1024x1024.jpg', 93);
INSERT INTO `images` VALUES (123, 'product.jpg', 93);
INSERT INTO `images` VALUES (124, 'related.jpg', 93);
INSERT INTO `images` VALUES (125, 'deb006900xam__1__50cc01f8d1dd4c1b98578ea88d4fa3e9_1024x1024.jpg', 94);
INSERT INTO `images` VALUES (126, 'dsc_0130_680d78ff57c846d5bf8edb58c2f6dbca_1024x1024.jpg', 94);
INSERT INTO `images` VALUES (127, 'dsc_0131_df76de934869484c89323579b8db0157_1024x1024.jpg', 94);
INSERT INTO `images` VALUES (128, 'dsc_0133_eceb5fdbac12408ea3b8ad90242ccf92_1024x1024.jpg', 94);
INSERT INTO `images` VALUES (129, '03602hog__1__223aa11e84d043d98bf92a032d7f084d_1024x1024.jpg', 95);
INSERT INTO `images` VALUES (130, '03602hog__2__e992a9f68bf14ae6b7cee69816b808fa_1024x1024.jpg', 95);
INSERT INTO `images` VALUES (131, '03602hog__3__7344b42ed4a14a838f1f565685998dd1_1024x1024.jpg', 95);
INSERT INTO `images` VALUES (132, '03602hog__4__d0f7ebe1585248c6a1c1c7af6c250946_1024x1024.jpg', 95);
INSERT INTO `images` VALUES (133, '03602hog__4__d0f7ebe1585248c6a1c1c7af6c250946_1024x1024.jpg', 96);
INSERT INTO `images` VALUES (134, 'deb006900xam__10__d4da8d8e6026407cb7218055513c4f39_1024x1024.jpg', 96);
INSERT INTO `images` VALUES (135, 'dsc_0134_6a4eb9bfb144401caf484e4a37d74c2c_1024x1024.jpg', 96);
INSERT INTO `images` VALUES (136, 'dsmh03601__2__78b2ad04120943db9bea01d9cc14e94d_1024x1024.jpg', 96);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role` VALUES (2, 'ROLE_MEMBER');

-- ----------------------------
-- Table structure for sanpham
-- ----------------------------
DROP TABLE IF EXISTS `sanpham`;
CREATE TABLE `sanpham`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tensanpham` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `giasanpham` float(255, 0) NOT NULL,
  `giamgia` float(255, 0) NOT NULL,
  `motasanpham` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ngaythemsanpham` date NOT NULL,
  `soluong` float(255, 0) NOT NULL,
  `id_thuonghieu` bigint(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKbco726s38w17d0ehmcjb9i5na`(`id_thuonghieu`) USING BTREE,
  CONSTRAINT `FKbco726s38w17d0ehmcjb9i5na` FOREIGN KEY (`id_thuonghieu`) REFERENCES `thuonghieu` (`id_thuonghieu`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sanpham
-- ----------------------------
INSERT INTO `sanpham` VALUES (75, 'Giày Thể Thao Nữ Biti\'s Hunter Street Mid Kumquat Soda DSWH03601TRG (Trắng)', 1000000, 20, 'Chưa có mô tả cho sản phẩm này', '2020-08-07', 12, 1);
INSERT INTO `sanpham` VALUES (76, 'Giày Thể Thao Nữ Biti\'s Hunter Street Mid Berry Soda DSWH03602HOG (Hồng)', 750000, 15, 'Chưa có mô tả cho sản phẩm này', '2020-08-07', 2, 2);
INSERT INTO `sanpham` VALUES (77, 'Giày Thể Thao Nam Biti\'s Hunter Street Latte DSMH03700KEM (Kem)', 769000, 13, 'Chưa có mô tả cho sản phẩm này', '2020-08-07', 12, 3);
INSERT INTO `sanpham` VALUES (78, 'Giày Thể Thao Nam Biti\'s Hunter Street Milk Tea DSMH03700KEL (Kem Lợt)', 500000, 15, 'Chưa có mô tả cho sản phẩm này', '2020-08-07', 15, 4);
INSERT INTO `sanpham` VALUES (79, 'Giày Thể Thao Nữ Biti\'s Hunter Street Mid Berry Soda DSWH03602HOG (Hồng)', 699000, 50, 'Chưa có mô tả cho sản phẩm này', '2020-08-07', 15, 5);
INSERT INTO `sanpham` VALUES (80, 'Giày Thể Thao Quai Dệt Trẻ Em Biti\'s DSB134800CAM (Cam)', 450000, 15, 'Chưa có mô tả cho sản phẩm này', '2020-08-07', 20, 6);
INSERT INTO `sanpham` VALUES (81, 'Sandal Eva Phun Bé Trai Biti\'s DEB006900XAM (Xám)', 250000, 20, 'Chưa có mô tả cho sản phẩm này', '2020-08-07', 2, 7);
INSERT INTO `sanpham` VALUES (82, 'Sandal Eva Phun Bé Trai Biti\'s DEB006900DOO (Đỏ)', 245000, 60, 'Chưa có mô tả cho sản phẩm này', '2020-08-07', 123, 1);
INSERT INTO `sanpham` VALUES (87, 'Giày thể thao nữ MWC NUTT- 0424', 250000, 20, 'THÊM MỘT SIÊU PHẨM SNEAKER ĐẾ CAO CHẤT LỪ CHO CÔ NÀNG CÁ TÍNH ', '2020-08-24', 20, 1);
INSERT INTO `sanpham` VALUES (88, 'Giày thể thao nữ MWC NUTT- 0422', 4000000, 20, 'THÊM MỘT SIÊU PHẨM SNEAKER ĐẾ CAO CHẤT LỪ CHO CÔ NÀNG CÁ TÍNH ', '2020-08-24', 2, 3);
INSERT INTO `sanpham` VALUES (89, 'Dép nam MWC NADE- 7636', 200000, 20, 'Dép đúc nguyên khối không sử dụng keo dán, thoáng khí cả mặt trong và mặt ngoài giúp bạn luôn dễ chịu và thoải mái dù mang trong thời gian dài.', '2020-08-24', 20, 4);
INSERT INTO `sanpham` VALUES (90, 'Giày Thể Thao Nam MWC NATT - 5255', 200, 20, 'Chưa có mô tả cho sản phẩm này', '2020-08-24', 10, 5);
INSERT INTO `sanpham` VALUES (93, 'AIR FORCE 1 SHADOW SAPPHIRE', 3900000, 20, 'AIR FORCE 1 SHADOW SAPPHIRE', '2020-08-25', 15, 2);
INSERT INTO `sanpham` VALUES (94, 'STAN SMITH WHITE HOLOGRAM', 2000000, 10, 'STAN SMITH WHITE HOLOGRAM', '2020-08-25', 12, 1);
INSERT INTO `sanpham` VALUES (95, 'STAN SMITH GREEN', 1500000, 10, 'dựa theo tên gọi của huyền thoại Tennis những năm 60s – Robert Haillet.', '2020-08-25', 15, 7);
INSERT INTO `sanpham` VALUES (96, 'FALCON W BEIGE/PINK', 1500000, 15, 'FALCON W BEIGE/PINK', '2020-08-25', 10, 25);

-- ----------------------------
-- Table structure for thuonghieu
-- ----------------------------
DROP TABLE IF EXISTS `thuonghieu`;
CREATE TABLE `thuonghieu`  (
  `id_thuonghieu` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenthuonghieu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_danhmuc` bigint(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_thuonghieu`) USING BTREE,
  INDEX `FKr6onixjq1c9ts95nx8p1v5gjx`(`id_danhmuc`) USING BTREE,
  CONSTRAINT `FKr6onixjq1c9ts95nx8p1v5gjx` FOREIGN KEY (`id_danhmuc`) REFERENCES `danhmuc` (`id_danhmuc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thuonghieu
-- ----------------------------
INSERT INTO `thuonghieu` VALUES (1, 'Adidas', 22);
INSERT INTO `thuonghieu` VALUES (2, 'Nike', 22);
INSERT INTO `thuonghieu` VALUES (3, 'Bitit\'s', 22);
INSERT INTO `thuonghieu` VALUES (4, 'New Blance', 23);
INSERT INTO `thuonghieu` VALUES (5, 'Puma', 23);
INSERT INTO `thuonghieu` VALUES (6, 'Bata', 23);
INSERT INTO `thuonghieu` VALUES (7, 'Sandal', 24);
INSERT INTO `thuonghieu` VALUES (14, 'Dép', 24);
INSERT INTO `thuonghieu` VALUES (16, 'McQueen', 24);
INSERT INTO `thuonghieu` VALUES (17, 'Balenciaga', 22);
INSERT INTO `thuonghieu` VALUES (18, 'Fendi', 22);
INSERT INTO `thuonghieu` VALUES (19, 'Raf Simons', 22);
INSERT INTO `thuonghieu` VALUES (20, 'Prada', 22);
INSERT INTO `thuonghieu` VALUES (21, 'Valentino', 23);
INSERT INTO `thuonghieu` VALUES (22, 'Lanvin', 23);
INSERT INTO `thuonghieu` VALUES (24, 'Reebok', 24);
INSERT INTO `thuonghieu` VALUES (25, 'Lacoste', 25);
INSERT INTO `thuonghieu` VALUES (26, 'Filling Pieces', 25);
INSERT INTO `thuonghieu` VALUES (29, 'Vans', 25);
INSERT INTO `thuonghieu` VALUES (30, 'ASICS', 25);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sdt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hovaten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 'admin', '$2a$10$ZubqXlkBw9JIpnUx3H1Mhul3TX1j4GVvFoUceZD5PDm353Syukgu6', 'admin', '09090909', 'thu duc', NULL);
INSERT INTO `user` VALUES (6, 'user', '$2a$10$FkEP6SEDJ9rFybDHt/A44e0PYoLcPyN9wySr52VM1WQ4E2nztzYNW', 'user', '099999', 'hcm', NULL);
INSERT INTO `user` VALUES (14, 'test', '$2a$10$pFvBGIyBiQoC66/3FjnQjOZHrEgsF0/ERZs/TkGw3rjaOK50cLtDu', '1', '1', '1', NULL);
INSERT INTO `user` VALUES (15, 'thinhtest', '$2a$10$bIHVuQTa4KdxdJW/ZoFPOutJzUk.dIBKAQtBFUqy10YK/DG9O1vl6', '2', '12', '2', NULL);
INSERT INTO `user` VALUES (16, 'thinh', '$2a$10$auQSA1hs8fI6pMDJ1IkMqeJKfb2/FFOs6SM4z6JC0FCaj6edAg.Wi', '1', '090909', 'dh nong lam', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FKa68196081fvovjhkek5m97n3y`(`role_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = FIXED;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (5, 1);
INSERT INTO `user_role` VALUES (6, 2);
INSERT INTO `user_role` VALUES (14, 2);
INSERT INTO `user_role` VALUES (15, 2);
INSERT INTO `user_role` VALUES (16, 2);

SET FOREIGN_KEY_CHECKS = 1;
