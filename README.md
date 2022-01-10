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
Command line tool for creating and verifying JWT tokens. Created with Java, GraalVM native image, Picocli and JReleaser.

[![Release](https://github.com/rrajesh1979/ref-java-jwt/actions/workflows/release.yml/badge.svg)](https://github.com/rrajesh1979/ref-java-jwt/actions/workflows/release.yml)
[![Code quality checks](https://github.com/rrajesh1979/ref-java-jwt/actions/workflows/code-quality-checks.yml/badge.svg?branch=master)](https://github.com/rrajesh1979/ref-java-jwt/actions/workflows/code-quality-checks.yml) 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=rrajesh1979_ref-java-jwt&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=rrajesh1979_ref-java-jwt)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/rrajesh1979/ref-java-jwt)
![GitHub last commit](https://img.shields.io/github/last-commit/rrajesh1979/ref-java-jwt)
![GitHub commit activity](https://img.shields.io/github/commit-activity/y/rrajesh1979/ref-java-jwt)
![GitHub pull requests](https://img.shields.io/github/issues-pr/rrajesh1979/ref-java-jwt)
![GitHub issues](https://img.shields.io/github/issues/rrajesh1979/ref-java-jwt)
![GitHub contributors](https://img.shields.io/github/contributors/rrajesh1979/ref-java-jwt)
![GitHub watchers](https://img.shields.io/github/watchers/rrajesh1979/ref-java-jwt)
![Known Vulnerabilities](https://snyk.io/test/github/rrajesh1979/ref-java-jwt/badge.svg)

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
This is a JWT CLI tool that is intended to serve as a reference implementation. This reference GitHub repo is built using
<ul>
    <li>Java</li>
    <li>Maven</li>
    <li>Picocli</li>
    <li>JReleaser</li>
    <li>CodeCov for code coverage</li>
    <li>Codeclimate and SonarCloud for quality checks</li>
    <li>GitHub Actions and Workflows</li>
    <li>GitPod environment</li>
    <li>JUnit tests</li>
</ul>
</div>

## Getting started

Once you have built and released the application, you can use the following commands to deploy the application to your Mac, Linux or Windows machine.
This is powered by GraalVM native image and distribution using JReleaser and GitHub Actions and Workflow.
```shell
# Substitute your username
# Deploy to Mac
brew tap rrajesh1979/tap
brew install jwtc
```

To upgrade version
```shell
brew update
brew upgrade jwtc
==> Upgrading 1 outdated package:
rrajesh1979/tap/jwtc 0.0.3 -> 0.0.4
==> Downloading https://github.com/rrajesh1979/ref-java-jwt/releases/download/v0.0.4/jwtc-0.0.4-osx-x86_64.zip
==> Downloading from https://objects.githubusercontent.com/github-production-release-asset-2e65be/445972514/8ad8375b-3107-490d-a826-3ad6e913632a?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4
######################################################################## 100.0%
==> Upgrading rrajesh1979/tap/jwtc
  0.0.3 -> 0.0.4

🍺  /usr/local/Cellar/jwtc/0.0.4: 5 files, 32.4MB, built in 3 seconds
==> Running `brew cleanup jwtc`...
Removing: /usr/local/Cellar/jwtc/0.0.3... (5 files, 32.2MB)
Removing: /Users/rajesh/Library/Caches/Homebrew/jwtc--0.0.3.zip... (10.4MB)
```

For command auto completion, you can use the following command.
```shell
source jwtc_completion
jwtc[TAB][TAB]
#Auto completion displays available sub-commands
jwtc
decode  encode  help
````

Once installed you can invoke jwtc with the file name and algorithm as shown below.

Invoking the command displays the usage information as shown below. This is powered by Picocli.
```shell
jwtc help
Usage: jwtc [-hV] [COMMAND]
Encode and decode JWT tokens.
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
Commands:
  help    Displays help information about the specified command
  encode  Encode a JWT token
  decode  Decode JWT token
```

```shell
jwtc encode help
Unmatched argument at index 1: 'help'
Usage: jwtc encode [-iat] [-a=<alg>] [-aud=<aud>] [-i=<iss>] [-p=<userInput>]
                   [-s=<sub>] [-t=<ttlMillis>] [-ty=<typ>]
  -a, --algorithm=<alg>   Algorithm to be used. Default is HS256. Supported
                            algorithms are HS256, HS384, HS512, RS256, RS384,
                            RS512, ES256, ES384, ES512
      -aud, --audience=<aud>
                          Recipients the JWT is intended for.
  -i, --issuer=<iss>      Principal that issued the JWT.
      -iat, --issuedAt    Include issued at in JWT.
  -p, --userInput=<userInput>
                          User provided payload in JSON format.
  -s, --subject=<sub>     Subject of the JWT.
  -t, --ttl=<ttlMillis>   Time to Live in Milliseconds.
      -ty, --typ=<typ>    Token Type. Default is JWT.
```

```shell
jwtc decode help
Missing required options: '--jwt=<jwt>', '--key=<key>'
Usage: jwtc decode -j=<jwt> -k=<key>
  -j, --jwt=<jwt>   JWT String to be decoded.
  -k, --key=<key>   Key to be used for decoding.
```

Some valid commands are shown below.
```shell
jwtc encode
16:17:48.928 [main] INFO org.rrajesh1979.tool.JWTCEncode - Starting JWTCEncode
16:17:48.955 [main] INFO org.rrajesh1979.tool.JWTCEncode - JWT: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJycmFqZXNoMTk3OSIsImV4cCI6MjYwNzMxMTE4MTM1MjU5fQ.5aa6651mlTOf8NOGrrugi3pvHoSYhDah67vlTVWw1fA
16:17:48.955 [main] INFO org.rrajesh1979.tool.JWTCEncode - Secret Key: QeQvvdxnvB9XEk0y0nnNh6w4V8BWfJ2uBwrNlnp84w0=
```

```shell
jwtc decode -j="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKV1QgRW5jb2RlciIsImF1ZCI6IkhlbGxvIEpXVCIsIm5hbWUiOiJKb2UiLCJpc3MiOiJycmFqZXNoMTk3OSIsInBpY3R1cmUiOiJodHRwczovL2V4YW1wbGUuY29tL2ltYWdlLnBuZyJ9.l1j1JyW3nvWJ90De8taOe1tZ80sHHHDMaibYEPv78LfA3Bw-uGgCECy5MwkE6nY3hP7isup433X5VqS2xP22fw" -k="mOYKXJKdhBYQFWNr9cHHsgGvHseKRR9Rw7E379oeUuzfG18MmlcO3c8i7tBMMufziy6xMoZZAiO7bNKxZl7Rfw=="
16:18:07.913 [main] INFO org.rrajesh1979.tool.JWTCDecode - Starting JWTCDecode
16:18:07.921 [main] INFO org.rrajesh1979.tool.JWTCDecode - Decoded JWT Header: {typ=JWT, alg=HS512}
16:18:07.922 [main] INFO org.rrajesh1979.tool.JWTCDecode - Decoded JWT Payload: {sub=JWT Encoder, aud=Hello JWT, name=Joe, iss=rrajesh1979, picture=https://example.com/image.png}
```

```shell
jwtc encode -a="HS512" -aud="Hello World" -i="rrajesh1979" -iat=true -s="Subject" --ttl=36000
16:21:10.986 [main] INFO org.rrajesh1979.tool.JWTCEncode - Starting JWTCEncode
16:21:11.015 [main] INFO org.rrajesh1979.tool.JWTCEncode - JWT: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTdWJqZWN0IiwiYXVkIjoiSGVsbG8gV29ybGQiLCJpc3MiOiJycmFqZXNoMTk3OSIsImV4cCI6MjU3MzY5MjE1MDg0ODExLCJpYXQiOjI1NzMzMzIxNTA4MjM1OH0.Kcnk5qBEy0BajIFzRm6RhQxxuYvd7wXodM-OGS2QD6Sw19KHQ8tpU3KVa6Fk-JrlM9YDAiC5SvYMJmmMEeisOw
16:21:11.015 [main] INFO org.rrajesh1979.tool.JWTCEncode - Secret Key: XF+okDOyZc4HgA/cOgwb7Vday3ihlR/8XFtD8Vo/4FTBV2XWVC+quTDEYFNu93QkOCS8bqvMUd6oCuCqHaFHDQ==
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
