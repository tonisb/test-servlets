Test servlets (Java 8)
======================

Servlets for testing different response statuses and other errors.

## Building and usage
Run the following command to build the war
(your JAVA_HOME environment variable should point to JDK8):  
* Gradle: `./gradlew war`

Deploy the resulting war from `build/libs`

Servlet paths are:
* APPLICATON_PATH/sleep
    - Makes the processing thread sleep for default 30s
    - Adding parameter ?wait=60000 makes it sleep for 60 seconds
* APPLICATION_PATH/status/{statusCode}
    - Just sets the response status as specified (if it is between 200 - 599)
