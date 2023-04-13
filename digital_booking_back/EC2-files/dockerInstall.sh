#!/bin/bash

# Update existing list of packages
sudo apt update
# Install prerequisite packages over HTTPS
sudo apt install apt-transport-https ca-certificates curl software-properties-common -y
# Add the GPG key for the official Docker repository to your system
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
# Add the Docker repository to APT sources
# This will also update our package database with the Docker packages from the newly added repo
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable" -y
# Update existing list of packages
sudo apt update
# Make sure you are about to install from the Docker repo instead of the default Ubuntu repo
# You’ll see output like this, although the version number for Docker may be different
apt-cache policy docker-ce
# Finally, install Docker
sudo apt install docker-ce -y
# Docker should now be installed, the daemon started, and the process enabled to start on boot. 
# Check that it’s running
## ====> sudo systemctl status docker
# Installing Docker now gives you not just the Docker service (daemon) 
# but also the docker command line utility, or the Docker client
# If you want to avoid typing sudo whenever you run the docker command, 
# add your username to the docker group
sudo usermod -aG docker ${USER}
# To apply the new group membership
sudo su - ${USER}
# You will be prompted to enter your user’s password to continue

# Confirm that your user is now added to the docker group by typing
## ====> groups


# If you need to add a user to the docker group that you’re not logged in as, 
# declare that username explicitly using
## sudo usermod -aG docker <username>
