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

docker rmi xiaomiller/eureka-server:v1.0.0
docker rmi xiaomiller/cloudserver:v1.0.0
docker rmi xiaomiller/cloudclient:v1.0.0
