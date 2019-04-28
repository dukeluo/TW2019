#!/usr/bin/env bash
service mysql start
mysql -uroot -proot -e "source ./database.sql"
./gradlew test
