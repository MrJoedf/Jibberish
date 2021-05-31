# Container image that runs your code
FROM debian:9.5-slim

# Copies your code file from your action repository to the filesystem path `/` of the container
COPY Frame1.java / Frame1.java

# Executes when the Docker container starts up
ENTRYPOINT ["/Frame1.java"]
