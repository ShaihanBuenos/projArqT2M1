FROM openjdk:17-oracle

ARG JAR_FILE
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENV JAVA_TOOL_OPTIONS "$JAVA_TOOL_OPTIONS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/etc/dumps/dump"

ENTRYPOINT java -jar -Djava.security.egd=file:/dev/./urandom -Xms512m -Xmx2048m --add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED app.jar