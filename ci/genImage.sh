#!/usr/bin/env bash

IMAGE_REPO=grow-service

docker login --username=hkliya@gmail.com registry-internal.cn-shanghai.aliyuncs.com

./gradlew docker
docker tag com.oocl/$IMAGE_REPO:latest $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER
docker tag com.oocl/$IMAGE_REPO:latest $IMAGE_REGISTRY/$IMAGE_REPO:latest
docker push $IMAGE_REGISTRY/$IMAGE_REPO:latest
docker push $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER