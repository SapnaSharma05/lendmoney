# Endpoints

- [Back to README](?path=%2FREADME.md)

## URL

__https://environment-url-goes-here/apollo-explore__
(building the service locally you might need to use "http" instead of "https")

See [infrastructure](https://dev.azure.com/vfuk-digital/Digital/_wiki/wikis/DXL%20Wiki?wikiVersion=GBmaster&pagePath=%2FDevelopment%2FInfrastructure) page for the different server urls.

## Questionnaire

 - `/{platformSessionId}/{segment}/journeys/journey (GET)` - get "About-your-Business" journey from application resources.
 - `/{platformSessionId}/{segment}/journeys/journey (POST)` - submit the answers for "About-your-Business" journey.

##Availability

 - `/{platformSessionId}/{segment}/journeys/service-availability/lookup-address (GET)` - lookup addresses of a postcode.
 - `/{platformSessionId}/{segment}/journeys/service-availability/addresses (POST)` - lookup addresses of a postcode.
 - `/{platformSessionId}/{segment}/journeys/service-availability/addresses/{id}/availability (GET)` - perform feasibility check on selected addresses.
 - `/{platformSessionId}/{segment}/journeys/service-availability/addresses/{id} (PATCH)` - replace one of selected addresses with another.
 - `/{platformSessionId}/{segment}/journeys/service-availability/addresses/{id} (DELETE)` - remove address by indexId.

##Session

 - `/{platformSessionId} (DELETE)` - discard quote.

## Swagger

- [/swagger-ui.html](https://dal.dx-dev1-blue.internal.vodafoneaws.co.uk/apollo-explore/swagger-ui.html) - Swagger docs
- [/v3/api-docs](http://dal.dx-dev1-blue.internal.vodafoneaws.co.uk/apollo-explore/v3/api-docs) - API docs paths

## Actuators

- [/actuator/health](https://dal.dx-dev1-blue.internal.vodafoneaws.co.uk/apollo-explore/actuator/health) - Health
- [/actuator/vhealth](https://dal.dx-dev1-blue.internal.vodafoneaws.co.uk/apollo-explore/actuator/vhealth) - Extended
  Health with downstream services
- [/actuator/info](https://dal.dx-dev1-blue.internal.vodafoneaws.co.uk/apollo-explore/actuator/info) - Info
- [/actuator/metrics](https://dal.dx-dev1-blue.internal.vodafoneaws.co.uk/apollo-explore/actuator/metrics) - Metrics
- [/actuator/env](https://dal.dx-dev1-blue.internal.vodafoneaws.co.uk/apollo-explore/actuator/env) - Environment

## Product configuration

-/v2/{platformSessionId}/{segment}/{basketId}/journeys/product-config/{pillarId}/products/{productId} - update
Mobile|Telephony products
![](diagrams/product-config/POST/V2_pillarId_products_productId.png)
