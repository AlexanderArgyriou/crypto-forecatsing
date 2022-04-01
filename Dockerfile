FROM jboss/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
#COPY crypto-forecast-war/target/crypto-forecast-war-1.war /opt/jboss/wildfly/standalone/deployments/

#JAVA_OPTS=”$JAVA_OPTS -Xdebug -Xrunjdwp:transport=dt_socket,address=*:8787,server=y,suspend=n” on standalone.conf

