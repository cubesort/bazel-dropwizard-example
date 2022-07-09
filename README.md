# bazel-dropwizard-example

A [Dropwizard](https://www.dropwizard.io/en/latest/) server built with [Bazel](https://bazel.build).

Development:

- Build: `bazel build //src/example:app`
- Format BUILD files: `bazel run //:buildifier`
- Re-pin Maven dependencies: `bazel run @unpinned_maven//:pin`

Run:

- Build runnable binary: `bazel build //src/example:app_deploy.jar`
- Run: `java -jar bazel-bin/src/example/app_deploy.jar server config.yaml`

Endpoints:

```
localhost:8080/hello
localhost:8080/hello?name=example
localhost:8081/healthcheck
```
