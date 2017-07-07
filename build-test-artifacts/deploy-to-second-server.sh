#!/bin/bash

ssh-add  ~/.ssh/jenkins-secondserver

ssh root@176.58.104.158 'sh /opt/commands/stop-mule.sh'

scp $1/server/target/*.zip root@176.58.104.158:/opt/mule/apps

scp $1/server-mock/target/*.zip root@176.58.104.158:/opt/mule/apps

ssh root@176.58.104.158 'sh /opt/commands/start-mule.sh'
