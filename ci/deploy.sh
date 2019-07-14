#!/usr/bin/env bash

IMAGE_URI=$IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER

sed "s@IMAGE_URI@$IMAGE_URI@g" ci/kube-deploy.yaml | sudo kubectl --insecure-skip-tls-verify --kubeconfig $KUBE_CONFIG_FILE apply -f -