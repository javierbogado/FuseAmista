# Spring-Boot y Camel XML DEMO GC 

Esta demo muestra como desarrollar los endpoints FTP/Cxfrs/File mediante Camel routes en Spring Boot por Spring DSL.

La aplicacion utiliza la anotacion Spring [`@ImportResource`](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ImportResource.html) para cargar el Camel Context  [camel-context.xml](src/main/resources/spring/camel-context.xml) en el classpath.

### Building
habiendose previamente clonado/descargado el project a la pc local importamos el projecto maven con el jboss developer studio 11.
una vez importado el project debemos instalarnos el plugin de fuse integration (si ya tenes el plugin esta parte no te haria falta)
una vez que tengamos el plugin instalado debemos marcar al projecto para que el plugin lo pueda ver asi:
	parados sobre el proyecto en el jbds le damos click derecho --> Configure --> Add Fuse Integration Support 

### Correr el proyecto localmente en el container de springboot 
El ejemplo se corre localmente levantando el container de springboot asi:
- parados sobre el proyecto en el jbds le damos click derecho --> Run as --> Local Camel Context 
	
Esto compilara el proyecto y lo dejara disponible para pruebas locales, o sea podemos probar los distintos endpoints de la demo (FTP, REST, FILE) sin necesidad de levantar un server.


### Correr el proyecto en OpenShift

Asumiendo que:
- El OpenShift platform ya esta levantado.

El ejemplo se corre para openshift asi:
- parados sobre el proyecto en el jbds le damos click derecho --> Run as --> Run Configurations...  --> buscar 'Maven Build' y luego 'Deploy GestionCompDemo on OpenShift'
- En la solapa JRE ver que los parametros esten pasados asi:

- -Dkubernetes.master=https://IP:port
- -Dkubernetes.namespace=gestion-compartida
- -Dkubernetes.auth.basic.username=myuser
- -Dkubernetes.auth.basic.password=mypass

Los valores 'IP:port' 'myuser' 'mypass' obviamente deben ser reales
