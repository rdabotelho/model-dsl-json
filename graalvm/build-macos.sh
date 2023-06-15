#!/bin/bash

# ATENTION
# Before everything, execute the follow command to generate a reflect-config.json file
# java -agentlib:native-image-agent=config-output-dir=graalvm -jar target/codegen-2.1.5-jar-with-dependencies.jar

ARTIFACT=model-dsl-json
VERSION=1.0.0-SNAPSHOT

INPUT_DIR=$(pwd)/input
OUTPUT_DIR=$(pwd)/output

cp ../target/$ARTIFACT-$VERSION-jar-with-dependencies.jar $INPUT_DIR/$ARTIFACT.jar

cd $OUTPUT_DIR
native-image --enable-http --enable-https --no-server --no-fallback -jar $INPUT_DIR/$ARTIFACT.jar

mv $ARTIFACT $ARTIFACT-macos
rm $ARTIFACT.build_artifacts.txt
