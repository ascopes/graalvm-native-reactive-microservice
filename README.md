# graalvm-native-reactive-microservice
Using Spring AOT and GraalVM native-image to transpile a reactive Java Spring Boot application to native machine code. Startup times of 100ms, and request latency of less than 0.25ms.

## Steps to build

- Install GraalVM for JDK 11.
- Install the `native-image` compiler with `# gu install native-image`
- Build the project and native image with `$ ./mvnw clean package -Pnative-image` (yes, this takes a while to run, be patient)
- Run the pure JVM build with `$ ./mvnw spring-boot:run`
- Run the native machine build with `$ ./target/io.ascopes.helloworld.app`


## JVM image

```
OpenJDK 64-Bit Server VM warning: forcing TieredStopAtLevel to full optimization because JVMCI is enabled
2021-03-13 18:56:02.508  INFO 22161 --- [           main] o.s.nativex.NativeListener               : This application is bootstrapped with code generated with Spring AOT

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.3)

2021-03-13 18:56:02.544  INFO 22161 --- [           main] io.ascopes.helloworld.App                : Starting App using Java 11.0.10 on z170x with PID 22161 (/home/ashley/code/graaltest/target/classes started by ashley in /home/ashley/code/graaltest)
2021-03-13 18:56:02.545  INFO 22161 --- [           main] io.ascopes.helloworld.App                : No active profile set, falling back to default profiles: default
2021-03-13 18:56:03.396  INFO 22161 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2021-03-13 18:56:03.403  INFO 22161 --- [           main] io.ascopes.helloworld.App                : Started App in 1.094 seconds (JVM running for 1.459)
```


## Native image
```
2021-03-13 19:10:45.462  INFO 23316 --- [           main] o.s.nativex.NativeListener               : This application is bootstrapped with code generated with Spring AOT

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.3)

2021-03-13 19:10:45.465  INFO 23316 --- [           main] io.ascopes.helloworld.App                : Starting App v0.0.1-SNAPSHOT using Java 11.0.10 on z170x with PID 23316 (/home/ashley/code/graaltest/target/io.ascopes.helloworld.app started by ashley in /home/ashley/code/graaltest)
2021-03-13 19:10:45.465  INFO 23316 --- [           main] io.ascopes.helloworld.App                : No active profile set, falling back to default profiles: default
2021-03-13 19:10:45.570  INFO 23316 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2021-03-13 19:10:45.571  INFO 23316 --- [           main] io.ascopes.helloworld.App                : Started App in 0.127 seconds (JVM running for 0.131)
```
