# Profiles

- [Back to README](?path=%2FREADME.md)

## Available Profiles
- __local__ - will configure to use local services
- __dev__ - will configure to use dev services
- __int__ - will configure to use int services

## IntelliJ Configuration
In order to  run the application and BDD tests locally , you will need to have local dynamoDB instance up and running.

Please check this doc file ( DYNAMO DB SETUP section)
 - [BE_DockerBuildRunAndDebug_V1.1.docx](https://dev.azure.com/vfuk-digital/b08a4a86-1259-476e-8aa1-2cc5d34d80c1/_apis/git/repositories/229a917c-af38-4ca8-b871-5e00a92437b4/Items?path=%2F.attachments%2FBE_DockerBuildRunAndDebug_V1.1-a412b044-1012-4b2e-bda6-e3697c949190.docx&download=false&resolveLfs=true&%24format=octetStream&api-version=5.0-preview.1&sanitize=true&versionDescriptor.version=wikiMaster) - Customer management JCS microservice docker build run debug

Then run the application with profile "local" - 
`VM options: -Dspring.profiles.active=local -Ddal.env=local`, 
then run the tests/build the application  with Maven profile "bdd" and spring profile "local"
In order to do this, 
                  
```
mvn test -Pbdd -Dspring.profiles.active=local -Ddal.env=local
```
or
```
mvn clean install -Pbdd -Dspring.profiles.active=local -Ddal.env=local
```