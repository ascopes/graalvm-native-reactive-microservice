# graalvm-native-reactive-microservice
Using Spring AOT and GraalVM native-image to transpile a reactive Java Spring Boot application to native machine code. Startup times of 100ms, and request latency of less than 0.25ms.

## Steps to build

- Install GraalVM for JDK 11.
- Install the `native-image` compiler with `# gu install native-image`
- Build the project and native image with `$ ./mvnw clean package -Pnative-image` (yes, this takes a while to run, be patient)
- Run the pure JVM build with `$ ./mvnw spring-boot:run`
- Run the native machine build with `$ ./target/io.ascopes.helloworld.app`
