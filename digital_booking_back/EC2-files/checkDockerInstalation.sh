#!/bin/sh
#Check for docker version
DOCKER_INSTALLED=$(ssh -i $INSTANCE_PRIVATE_KEY $INSTANCE_USER@$INSTANCE_IP "docker --version | grep 'version' | wc -l")
if [[ $DOCKER_INSTALLED -gt 0 ]] 
then 
    echo "DOCKER: Is installed"
else
	echo "DOCKER: Installing ..."
	scp -i $INSTANCE_PRIVATE_KEY dockerInstall.sh $INSTANCE_USER@$INSTANCE_IP:/home/ubuntu
	ssh -i $INSTANCE_PRIVATE_KEY $INSTANCE_USER@$INSTANCE_IP "chmod u+x dockerInstall.sh"
	ssh -i $INSTANCE_PRIVATE_KEY $INSTANCE_USER@$INSTANCE_IP "./dockerInstall.sh"
	DOCKER_INSTALLED=$(ssh -i $INSTANCE_PRIVATE_KEY $INSTANCE_USER@$INSTANCE_IP "docker --version | grep 'version' | wc -l")
	if [[ $DOCKER_INSTALLED -gt 0 ]]
	then
		echo "DOCKER: Installed"
	else
		echo "DOCKER: Installation failed!"
		exit 1
	fi
fi
