#!/bin/bash

INFO="Installation\n\n
1. After unzipping the release file, the model-dsl-json folder was created\n
2. Copy the model-dsl-json folder to home directory ~/\n
3. Add the model-dsl-json folder to the PATH environment variable\n"

# Linux
cd output
mkdir model-dsl-json
cp model-dsl-json-linux model-dsl-json/model-dsl-json
echo $INFO | tee model-dsl-json/installation.txt > /dev/null
zip -r model-dsl-json-linux.zip model-dsl-json
rm -Rf model-dsl-json

# Macos
cd output
mkdir model-dsl-json
cp model-dsl-json-macos model-dsl-json/model-dsl-json
echo $INFO | tee model-dsl-json/installation.txt > /dev/null
zip -r model-dsl-json-macos.zip model-dsl-json
rm -Rf model-dsl-jsons

# Window
cd output
mkdir model-dsl-json
cp ../../target/model-dsl-json/* model-dsl-json
zip -r model-dsl-json-windows.zip model-dsl-json
rm -Rf model-dsl-json

# Finish
rm -Rf model-dsl-json
