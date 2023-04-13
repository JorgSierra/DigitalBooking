#!/bin/bash
printf "\n===============================>\nback_container:\n"
EXIST=$(docker ps -a | grep back_container | wc -l)
if [[ $EXIST -gt 0 ]] 
then 
    echo "  EXIST"
	RUNING=$(docker ps | grep back_container | wc -l)
	if [[ $RUNING -gt 0 ]]
	then
		echo "  IS RUNNING"
		echo -n "  STOPING .. "
		docker stop back_container
		echo "  STOPPED"
	fi
    docker rm back_container
	EXIST=$(docker ps -a | grep back_container | wc -l)
	if [[ $EXIST -eq 0 ]] 
	then
		echo "  REMOVED CONTAINER"
	else
		echo "  FAILED TO REMOVE CONTAINER"
		exit 1
	fi
fi

printf "\n===============================>\nback_image:\n"
EXIST=$(docker images | grep back_image | wc -l)
if [[ $EXIST -gt 0 ]]
then 
	echo "  EXIST"
	echo -n "  REMOVING .. "
	docker rmi back_image
	EXIST=$(docker images | grep back_image | wc -l)
	if [[ $EXIST -eq 0 ]]
	then
		echo "  REMOVED IMAGE"
	else
		echo "  FAILED TO REMOVE IMAGE"
		exit 1
	fi
fi

docker build -t "back_image:latest" .
docker run -d -p 80:8090 --name back_container back_image:latest

EXIST=$(docker ps | grep back_container | wc -l)
if [[ $EXIST -gt 0 ]] 
then
	echo "<<<<<< CONTAINER SUCCESSFULLY DEPLOYED >>>>>>"
else
	echo "  FAILED TO DEPLOY CONTAINER"
	exit 1
fi

