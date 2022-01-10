<!-- markdownlint-configure-file {
  "MD013": {
    "code_blocks": false,
    "tables": false
  },
  "MD033": false,
  "MD041": false
} -->

<div align="center">

# JWT CLI

[![Release](https://github.com/rrajesh1979/ref-java-jwt/actions/workflows/release.yml/badge.svg)](https://github.com/rrajesh1979/ref-java-jwt/actions/workflows/release.yml)
[![Code quality checks](https://github.com/rrajesh1979/ref-java-jwt/actions/workflows/code-quality-checks.yml/badge.svg?branch=master)](https://github.com/rrajesh1979/ref-java-jwt/actions/workflows/code-quality-checks.yml)

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=rrajesh1979_ref-java-jwt)](https://sonarcloud.io/summary/new_code?id=rrajesh1979_ref-java-jwt)

![GitHub release (latest by date)](https://img.shields.io/github/v/release/rrajesh1979/ref-java-jwt)

![GitHub last commit](https://img.shields.io/github/last-commit/rrajesh1979/ref-java-jwt)
![GitHub commit activity](https://img.shields.io/github/commit-activity/y/rrajesh1979/ref-java-jwt)
![GitHub pull requests](https://img.shields.io/github/issues-pr/rrajesh1979/ref-java-jwt)
![GitHub issues](https://img.shields.io/github/issues/rrajesh1979/ref-java-jwt)

![GitHub contributors](https://img.shields.io/github/contributors/rrajesh1979/ref-java-jwt)
![GitHub watchers](https://img.shields.io/github/watchers/rrajesh1979/ref-java-jwt)

<a href="https://github.com/rrajesh1979/ref-java-jwt/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=rrajesh1979/ref-java-jwt"  alt="Contributors"/>
</a>

Made with [contrib.rocks](https://contrib.rocks).

[Key Features](#key-features) •
[Getting started](#getting-started) •
[How to use](#how-to-use) •
[Configuration](#configuration) •
[Related projects](#related-projects) •
[GitPod Environment](#gitpod-environment) •
[License](#license) •
[Code Quality](#code-quality) •

</div>

## Key Features
<div>
This is a reference implementation that can serve as a jump start application. This reference GitHub repo is built using
<ul>
    <li>Java</li>
    <li>Maven</li>
    <li>JReleaser</li>
    <li>Picocli</li>
    <li>Code Quality tools</li>
    <li>GitHub Actions and Workflows</li>
    <li>GitPod environment</li>
    <li>Spock and JUnit tests</li>
    <li>Using Git Emojis</li>
</ul>
</div>

## Getting started

Once you have build and released the application, you can use the following commands to deploy the application to your Mac, Linux or Windows machine.
This is powered by GraalVM native image and distribution using JReleaser and GitHub Actions and Workflow.
```shell
# Substitute your username
# Deploy to Mac
brew tap rrajesh1979/tap
brew install mychecksum
```

Once installed you can invoke mychecksum with the file name and algorithm as shown below.

Invoking the command displays the usage information as shown below. This is powered by Picocli.
```shell
mychecksum
11:01:36.098 [main] INFO org.rrajesh1979.demo.MyCheckSum - Hello from MyCheckSum
Missing required parameter: '<file>'
Usage: mychecksum [-hV] [-a=<algorithm>] <file>
Prints the checksum (MD5 by default) of a file to STDOUT.
      <file>      The file whose checksum to calculate.
  -a, --algorithm=<algorithm>
                  MD5, SHA-1, SHA-256, ...
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
```

Some valid commands are shown below.
```shell
mychecksum hello.txt
11:09:40.116 [main] INFO org.rrajesh1979.demo.MyCheckSum - Hello from MyCheckSum
11:09:40.137 [main] INFO org.rrajesh1979.demo.MyCheckSum - Checksum of file hello.txt, is : f0ef7081e1539ac00ef5b761b4fb01b3
```

```shell
mychecksum hello.txt -a MD5
11:09:50.123 [main] INFO org.rrajesh1979.demo.MyCheckSum - Hello from MyCheckSum
11:09:50.151 [main] INFO org.rrajesh1979.demo.MyCheckSum - Checksum of file hello.txt, is : f0ef7081e1539ac00ef5b761b4fb01b3
```

```shell
mychecksum hello.txt -a SHA-256
11:10:10.578 [main] INFO org.rrajesh1979.demo.MyCheckSum - Hello from MyCheckSum
11:10:10.591 [main] INFO org.rrajesh1979.demo.MyCheckSum - Checksum of file hello.txt, is : 1894a19c85ba153acbf743ac4e43fc004c891604b26f8c69e1e83ea2afc7c48f
```

## How to use
You can fork this repository and build your own reference implementation.

## Configuration
Following needs to be done to build the reference implementation.
> Maven pom.xml with required 
>> application name, mainClass and other personalization

> JReleaser config: jreleaser.yml

> CodeCov - CODECOV_TOKEN in repository secrets

> CodeClimate - CODECLIMATE_TOKEN in repository secrets

> Release Token RELEASE_TOKEN in repository secrets

> GitHub Actions and Workflows: release.yml

> GitHub Actions and Workflows: code-quality-checks.yml

## GitPod Environment
Fork and develop online using this ready to use GitPod environment.

[![setup automated](https://img.shields.io/badge/Gitpod-ready_to_code-orange?logo=gitpod)](https://gitpod.io/from-referrer/)

## Related projects


## License

![GitHub](https://img.shields.io/github/license/rrajesh1979/ref-java-jwt)

## Code Quality

[![codecov](https://codecov.io/gh/rrajesh1979/ref-java-jwt/branch/master/graph/badge.svg?token=nuivwdrnL1)](https://codecov.io/gh/rrajesh1979/ref-java-jwt)

[![Maintainability](https://api.codeclimate.com/v1/badges/6bfbafbfd54e673b5a0b/maintainability)](https://codeclimate.com/github/rrajesh1979/ref-java-jwt/maintainability)
