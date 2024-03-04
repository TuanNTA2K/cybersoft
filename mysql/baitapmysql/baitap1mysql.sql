CREATE DATABASE cungcapsanpham;
USE cungcapsanpham;

CREATE TABLE sanpham(
	idsanpham tinyint auto_increment,
	tensanpham varchar(50),
	gianhap float,
	giaban float,
	soluong smallint,
	phantramgiamgia decimal(4,2),
	idnhacungcap tinyint,
	idloaisanpham char(6),
	primary key (idsanpham)
);

CREATE TABLE nhacungcap(
	idnhacungcap tinyint(10),
	tennhacungcap varchar(30),
		
	primary key(idnhacungcap)
);

CREATE TABLE loaisanpham(
	idloaisanpham char(6),
	tenloaisanpham varchar(50),
	
	primary key(idloaisanpham)
);

ALTER TABLE sanpham ADD CONSTRAINT FK_idloaisanpham_sanpham FOREIGN KEY (idloaisanpham) REFERENCES loaisanpham(idloaisanpham);
ALTER TABLE sanpham ADD CONSTRAINT FK_idnhacungcap_sanpham FOREIGN KEY (idnhacungcap) REFERENCES nhacungcap(idnhacungcap);

INSERT INTO nhacungcap(idnhacungcap, tennhacungcap)
VALUES
(1,'samsung'),
(2,'apple'),
(3,'sony');

INSERT INTO loaisanpham(idloaisanpham, tenloaisanpham)
VALUES
('dt', 'dien thoai'),
('tb', 'tablet'),
('tv', 'tivi'),
('dh', 'dong ho');

INSERT INTO sanpham(tensanpham,gianhap,giaban,soluong,phantramgiamgia,idnhacungcap, idloaisanpham)
VALUES
('samsung Galaxy A14', 8000000, 8500000, 10, 4.50, 1, 'dt'),
('samsung Galaxy Note23 ultra', 18000000, 20000000, 100, 5.50, 1,'dt'),
('samsung tab s9', 13000000, 14000000, 30, 3.50, 1, 'tb'),
('samsung tab s9 ultra', 14000000, 15500000, 35, 6.25, 1,'tb'),
('samsung smart tv 4k', 6000000, 7000000, 65, 2.55, 1,'tv'),
('samsung galaxy watch6', 6000000, 7500000, 70, 3.15,1,'dh'),
('iphone pro 11', 19000000, 20000000, 27, 6.50, 2, 'dt'),
('iphone pro 12', 20000000, 22000000, 15, 7.30, 2,'dt'),
('macbook pro ', 20000000, 22000000, 25, 5.20, 2,'tb'),
('macbook air', 17000000, 18000000, 27, 6.40, 2,'tb'),
('apple watch', 5000000, 6000000, 48, 3.40, 2,'dh'),
('sony experia', 4000000, 5000000, 20, 3.60, 3,'dt');


-- 1.1
SELECT * FROM sanpham;
-- 1.2
SELECT idsanpham, tensanpham, gianhap, giaban, soluong, phantramgiamgia FROM sanpham; 
-- 1.3
SELECT idsanpham, tensanpham, gianhap, giaban, soluong 
FROM sanpham
WHERE soluong > 60;
-- 1.4
SELECT idsanpham, tensanpham
FROM sanpham 
ORDER BY idsanpham DESC
LIMIT 3;
-- 1.5
SELECT *
FROM sanpham
WHERE tensanpham LIKE '%samsung%';
-- 1.6
SELECT tensanpham, giaban
FROM sanpham
WHERE tensanpham LIKE '%macbook%' AND giaban > 7000000;
-- 1.7
SELECT tensanpham, giaban
FROM sanpham 
WHERE tensanpham LIKE '%macbook%' AND giaban > 8000000 AND giaban < 10000000;
-- 2.1
SELECT idsanpham, tensanpham, gianhap, giaban, soluong, tennhacungcap 
FROM sanpham s
JOIN  nhacungcap c ON s.idnhacungcap = c.idnhacungcap;
-- 2.2
SELECT idsanpham, tensanpham, gianhap, giaban, soluong, s.idnhacungcap, c.tennhacungcap 
FROM sanpham s
JOIN nhacungcap c ON s.idnhacungcap = c.idnhacungcap 
WHERE s.giaban > 5000000;
-- 2.3
SELECT idsanpham, tensanpham, gianhap, giaban, soluong, s.idnhacungcap, l.idloaisanpham , l.tenloaisanpham
FROM sanpham s
JOIN loaisanpham l ON s.idloaisanpham = l.idloaisanpham
WHERE s.idloaisanpham = 'tb';