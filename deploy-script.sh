### build the repository
mvn clean install

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
docker build -t pyronaid/custom_springboot_app:${versionApp} .
cat password.txt | docker login --username pyronaid --password-stdin
docker push pyronaid/custom_springboot_app:${versionApp}
docker rmi pyronaid/custom_springboot_app:${versionApp}



#kubectl create -f travel-agency-service/secret.yaml
#kubectl create -f travel-agency-service/mongo-deployment.yaml

### travel-agency-service
#kubectl delete -f travel-agency-service/travel-agency-deployment.yaml
#kubectl create -f travel-agency-service/travel-agency-deployment.yaml

### client-service
#kubectl delete configmap client-service
#kubectl delete -f client-service/client-service-deployment.yaml

#kubectl create -f client-service/client-config.yaml
#kubectl create -f client-service/client-service-deployment.yaml

# Check that the pods are running
#kubectl get pods