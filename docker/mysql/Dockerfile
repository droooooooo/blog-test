FROM mysql:8.0
#mysql的工作位置
ENV WORK_PATH /usr/local/sql

#定义会被容器自动执行的目录
ENV AUTO_RUN_DIR /docker-entrypoint-initdb.d

#初始化数据库的SQL

#执行SQL
ENV INSTALL_DATA_SHELL docker-entrypoint.sh
ENV SQL ./sql

#COPY $SQL $WORK_PATH/
#把要执行的shell文件放到/docker-entrypoint-initdb.d/目录下，容器会自动执行这个shell

COPY $SQL $WORK_PATH/
COPY ./$INSTALL_DATA_SHELL $AUTO_RUN_DIR/

#给执行文件增加可执行权限
RUN chmod a+x $AUTO_RUN_DIR/$INSTALL_DATA_SHELL

#设置容器启动时执行的命令
#CMD ["sh", "/docker-entrypoint-initdb.d/import.sh"]