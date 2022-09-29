# JEEExamples

1. Getting Started - Example GET endpoint

## Create a new JEE JAXRS/JSF project

`org.apache.maven.archetypes:maven-archetype-webapp`

```xml
<plugin>
    <groupId>org.wildfly.plugins</groupId>
    <artifactId>wildfly-maven-plugin</artifactId>
    <version>2.1.0.Beta1</version>
</plugin>
```

```xml
<dependency>
    <groupId>jakarta.platform</groupId>
    <artifactId>jakarta.jakartaee-web-api</artifactId>
    <version>8.0.0</version>
    <scope>provided</scope>
</dependency>
```
