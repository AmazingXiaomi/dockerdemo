#!/bin/bash

echo '============================================================='
echo '$                                                           $'
echo '$                      liumapp                              $'
echo '$                                                           $'
echo '$                                                           $'
echo '$  email:    a1205938863@gmail.com                          $'
echo '$  homePage: https://xiaomiller.cn                          $'
echo '$  Github:   https://github.com/AmazingXiaomi               $'
echo '$                                                           $'
echo '============================================================='
echo '.'

# if you have engine project . plz add
# cd ${your engine path}
 mvn clean install

cd eureka-server

mvn clean package docker:build

cd ..

cd cloudserver

mvn clean package docker:build

cd ..

cd cloudclient

mvn clean package docker:build

cd ..

cd ..


