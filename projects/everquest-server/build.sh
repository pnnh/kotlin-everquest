native-image --no-fallback --enable-all-security-services --report-unsupported-elements-at-runtime \
--install-exit-handlers --allow-incomplete-classpath --initialize-at-build-time=io.ktor,kotlinx,kotlin,org.slf4j\
-H:+ReportUnsupportedElementsAtRuntime -H:+ReportExceptionStackTraces -H:ReflectionConfigurationFiles=./reflection.json \
-cp ./build/libs/everquest-server-0.0.1-all.jar -H:Class=xyz.sfx.ApplicationKt -H:Name=./build/graal-server
