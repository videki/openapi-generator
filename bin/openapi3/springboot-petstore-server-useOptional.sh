#!/bin/sh

SCRIPT="$0"
echo "# START SCRIPT: $SCRIPT"

while [ -h "$SCRIPT" ] ; do
  ls=`ls -ld "$SCRIPT"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    SCRIPT="$link"
  else
    SCRIPT=`dirname "$SCRIPT"`/"$link"
  fi
done

if [ ! -d "${APP_DIR}" ]; then
  APP_DIR=`dirname "$SCRIPT"`/..
  APP_DIR=`cd "${APP_DIR}"; pwd`
fi

executable="./modules/openapi-generator-cli/target/openapi-generator-cli.jar"

if [ ! -f "$executable" ]
then
  mvn -B clean package
fi

# if you've executed sbt assembly previously it will use that instead.
export JAVA_OPTS="${JAVA_OPTS} -Xmx1024M -DloggerPath=conf/log4j.properties"
ags="generate -t modules/openapi-generator/src/main/resources/JavaSpring -i modules/openapi-generator/src/test/resources/3_0/petstore.yaml -g spring -c bin/openapi3/springboot-petstore-server-useOptional.json -o samples/openapi3/server/petstore/springboot-useoptional --additional-properties hideGenerationTimestamp=true $@"

echo "Removing files and folders under samples/openapi3/server/petstore/springboot-useoptional/src/main"
rm -rf samples/openapi3/server/petstore/springboot-useoptional/src/main
find samples/openapi3/server/petstore/springboot-useoptional -maxdepth 1 -type f ! -name "README.md" -exec rm {} +
java $JAVA_OPTS -jar $executable $ags
