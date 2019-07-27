#!/bin/bash
user=root
password=abc123456
sqls=`ls /usr/local/sql/*.sql`
echo '开始导入!'
for sql in $sqls
do
echo $sql
mysql -u$user -p$password -f blog-test -e "source $sql"
done
echo '导入成功!'