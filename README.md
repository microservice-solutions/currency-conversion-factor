### currency-conversion-factor

![GH Build](https://img.shields.io/github/workflow/status/microservice-solutions/currency-conversion-factor/Java%20CI%20with%20Maven?label=GH%20Build)
![Deploy to IKS](https://img.shields.io/github/workflow/status/microservice-solutions/currency-conversion-factor/Deploy%20to%20IKS?label=Deploy%20to%20IKS)

The project is built using Github Actions.\
A docker image is also created for this project and is pushed in docker hub microservicesolutions/currency-conversion-factor:latest


The swagger specs for this project can be seen with the below url (default port 8080):\
http://localhost:8080/swagger-ui/


The docker image can be pulled using:\
`docker pull microservicesolutions/currency-conversion-factor`

The docker image can be run using:\
`docker run -dt -p 8080:8080 microservicesolutions/currency-conversion-factor`
