### build the repository
./mvnw clean install -Dmaven.test.skip=true

### set docker env
eval $(minikube docker-env)

### check the presence of mongo-secret and mongo-config
if [[ $(kubectl get configMap | grep -E "^mongo-config[ ]+" | wc -l) != 1 ]]; then
  echo "The mongo-config configMap is missing from k8. Launch it before"
  exit 1
fi
if [[ $(kubectl get secret | grep -E "^mongo-secret[ ]+" | wc -l) != 1 ]]; then
  echo "The mongo-secret secret is missing from k8. Launch it before"
  exit 1
fi

### build the docker images on minikube
versionApp=$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout)
docker build --build-arg APP_VERSION=${versionApp} -t pyronaid/custom_springboot_app:${versionApp} --rm=true .
cat password.txt | docker login --username pyronaid --password-stdin
docker push pyronaid/custom_springboot_app:${versionApp}
docker rmi pyronaid/custom_springboot_app:${versionApp}

#refresh installation
echo "command delete -f springboot.yaml"
kubectl delete -f springboot.yaml
echo "###############################################"
echo "###############################################"
echo "command delete -f springboot-config.yaml"
kubectl delete -f springboot-config.yaml
echo "###############################################"
echo "###############################################"
echo "command apply -f springboot-config.yaml"
kubectl apply -f springboot-config.yaml
echo "###############################################"
echo "###############################################"
echo "command apply -f springboot.yaml"
kubectl apply -f springboot.yaml
echo "###############################################"
echo "###############################################"
