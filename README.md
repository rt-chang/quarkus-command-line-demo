# Quarkus Command Line Demo

This was a simple demo project created to address a bug in the Quarkus framework v1.5.2
https://github.com/quarkusio/quarkus/issues/10166

The project takes 2 command line arguments (`--name`, `--day`) and was expected to produce a message (`Hello {name}! Today is {day}`)

This should be called via:
```
./mvnw quarkus:dev -Dquarkus.args="--name=Bob --day=Wednesday"
```
