# Write your MySQL query statement below
select * from Users where cast(mail as BINARY) regexp cast('^[a-zA-Z][a-zA-Z0-9-._]*@leetcode\\.com$' as BINARY);
-- OR
select * from Users where mail COLLATE utf8mb3_bin regexp '^[a-zA-Z][a-zA-Z0-9-._]*@leetcode\\.com$';
