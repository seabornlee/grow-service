#!/usr/bin/env bash

IMAGE_REPO=grow-service

docker login --username=hkliya@gmail.com --password=r2t8.HEDQGWifd $IMAGE_REGISTRY

./gradlew docker
docker tag com.oocl/$IMAGE_REPO:latest $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER
docker tag com.oocl/$IMAGE_REPO:latest $IMAGE_REGISTRY/$IMAGE_REPO:latest
docker push $IMAGE_REGISTRY/$IMAGE_REPO:latest
docker push $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER