# Model DSL JSON

## To generate a native parse with GraalVM

1. Build the project

```bash
mvn clean package -P executable
```

2. Generate the GraalVM native executable

```bash
native-image -jar target/model-dsl-json-1.0.0-SNAPSHOT.jar
```

### Prerequisites

1. Installed the GraalVM

2. Defined the GRAALVM_HOME

```bash
export GRAALVM_HOME=/path/graevm
```

3. Included the Graalvm bin and the PATH

```bash
export PATH=$GRAALVM_HOME/Contents/Home/bin:$PATH
```

4. Installed the native-image

```bash
gu install native-image
```
