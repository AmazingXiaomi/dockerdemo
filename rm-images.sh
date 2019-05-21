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

docker rmi xiaomiller/eureka-server:0.0.1
docker rmi xiaomiller/cloudserver:0.0.1
docker rmi xiaomiller/cloudclient:0.0.1
docker rmi xiaomiller/cloud-service-a:0.0.1
docker rmi xiaomiller/cloud-service-b:0.0.1
