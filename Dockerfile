FROM openjdk:21

RUN mkdir /opt/code &&\
    mkdir /opt/app
ADD FirstTechChallenge /opt/code/
ENV  M2_HOME '/opt/apache-maven-3.9.6'
ENV PATH "$M2_HOME/bin:$PATH"


RUN curl https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz -o apache-maven-3.9.6-bin.tar.gz &&\
    tar xzvf apache-maven-3.9.6-bin.tar.gz -C /opt/ &&\
    rm -rf apache-maven-3.9.6-bin.tar.gz &&\
    cd /opt/code/ &&\
    mvn clean package &&\
    mv /opt/code/target/*.jar /opt/app/ &&\
    mv /opt/app/*.jar /opt/app/FirstTechChallenge.jar &&\
    rm -rfv /opt/code &&\
    chmod 777 -R /opt/app/

ENTRYPOINT ["java","-jar","/opt/app/FirstTechChallenge.jar"]
