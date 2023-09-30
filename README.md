# si-ws-and-soa

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode

To run this project you need to setup a gmail account with an application password and set the following environment variables:

- QUARKUS_MAILER_FROM=(your created email)
- QUARKUS_MAILER_HOST=smtp.gmail.com
- QUARKUS_MAILER_PORT=465
- QUARKUS_MAILER_SSL=true
- QUARKUS_MAILER_USERNAME=(your created email)
- QUARKUS_MAILER_PASSWORD=(your created application password)
- QUARKUS_MAILER_MOCK=(false)

documentation = https://quarkus.io/guides/mailer-reference#gmail-specific-configuration


This application exposes two endpoints which can be called via swagger(swagger can be found via http://localhost:8080/q/swagger-ui/, when running the application in dev mode) or any tool you like

- init endpoint = http://localhost:8080/api/init 
  - consumes JSON with the following structure
  ```json
  [
      {
        "email": "string",
        "name": "string",
        "ipAddress": "string"
      }
  ]
  ```
  - sucessful response = 200 (this will send an email to all the email address' provided)

- Country info endpoint http:localhost:8080/cxf/country-client/CountryFlag
    - has one query param which is the country code
    - sucessful response = 200 this will return a link to the flag of the country


You can run your this application in dev mode using:
```shell script
./mvnw compile quarkus:dev
```
