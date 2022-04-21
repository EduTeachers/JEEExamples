# JEEExamples

1. Getting Started - Example GET endpoint

## Create a new JEE JAXRS project

`org.apache.maven.archetypes:maven-archetype-webapp`

```
            <plugin>
                <groupId>org.wildfly.plugins</groupId>
                <artifactId>wildfly-maven-plugin</artifactId>
                <version>2.1.0.Beta1</version>
            </plugin>
```

```
        <dependency>
            <groupId>jakarta.platform</groupId>
            <artifactId>jakarta.jakartaee-web-api</artifactId>
            <version>8.0.0</version>
            <scope>provided</scope>
        </dependency>
```