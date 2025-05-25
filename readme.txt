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


ーーーーーーーーーーーーーーーーーー
ステップ1：GitHubで新しいリポジトリを作成
1.GitHub にログイン
2.「＋」→「New repository」
3.リポジトリ名を customer-app-sample に設定
4.「Private」または「Public」を選択
5.✅ README, .gitignore, License はチェックを外す（ローカルで管理しているため）
6.「Create repository」ボタンを押す

ステップ2：ローカルプロジェクトを Git 初期化
コマンドプロンプトまたはターミナルでプロジェクトのルートへ：
cd C:\work\20250525\customer-app-sample
次に以下を実行：
git init
git add .
git commit -m "初回コミット"

ステップ3：GitHub リポジトリと接続してプッシュ
git remote add origin https://github.com/mamaruru/customer-app-sample.git
git branch -M main
git push -u origin main

