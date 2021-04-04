load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "app",
    srcs = glob(["*.java"]),
    main_class = "example.App",
    deps = [
        "//src/example/health",
        "//src/example/resources",
        "//third_party:dropwizard_core",
        "//third_party:jackson_annotations",
        "//third_party:jakarta_validation",
    ],
)
