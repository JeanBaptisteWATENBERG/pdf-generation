#!/bin/zsh
./gradlew fatJar
docker build -t toto .
docker run -it -v $(pwd):/tmp toto
ls -larth