FROM centos
RUN yum install -y java-1.8.0-openjdk
ADD build/libs/*-all-*.jar toto.jar

CMD java -jar toto.jar