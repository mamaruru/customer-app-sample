PS C:\WINDOWS\system32> sqlcmd -S localhost -E
EXEC sp_addrolemember 'db_ddladmin', 'springuser';
go

sqlcmd -S localhost -U springuser  -P NewSecurePassword!

CREATE TABLE ackss.customers (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    address NVARCHAR(255) NOT NULL
);


INSERT INTO ackss.customers (name, birth_date, address) VALUES
(N'山田 太郎', '1985-03-15', N'東京都渋谷区'),
(N'佐藤 花子', '1990-07-20', N'大阪府大阪市'),
(N'田中 一郎', '1975-12-05', N'愛知県名古屋市'),
(N'鈴木 次郎', '1988-01-22', N'北海道札幌市'),
(N'高橋 美咲', '1995-11-30', N'福岡県福岡市');

