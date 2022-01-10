package org.rrajesh1979.tool;

import org.javatuples.Pair;
import org.rrajesh1979.utils.JWTUtil;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "encode")
@Slf4j
public class JWTCEncode implements Runnable {
    @Option(names = { "-a",
            "--algorithm" }, description = "Algorithm to be used. Default is HS256. Supported algorithms are HS256, HS384, HS512, RS256, RS384, RS512, ES256, ES384, ES512", defaultValue = "HS256")
    String alg;

    @Option(names = { "-t", "--ttl" }, description = "Time to Live in Milliseconds.", defaultValue = "3600000")
    long ttlMillis;

    @Option(names = { "-s", "--subject" }, description = "Subject of the JWT.")
    String sub;

    @Option(names = { "-ty", "--typ" }, description = "Token Type. Default is JWT.", defaultValue = "JWT")
    String typ;

    @Option(names = { "-i", "--issuer" }, description = "Principal that issued the JWT.", defaultValue = "rrajesh1979")
    String iss;

    @Option(names = { "-aud", "--audience" }, description = "Recipients the JWT is intended for.")
    String aud;

    @Option(names = { "-iat", "--issuedAt" }, description = "Include issued at in JWT.", defaultValue = "false")
    boolean iat;

    @Option(names = { "-p", "--userInput" }, description = "User provided payload in JSON format.", defaultValue = "{}")
    String userInput;

    @Override
    public void run() {
        log.info("Starting JWTCEncode");

        Pair<String, String> jwtAndKey = JWTUtil.createJWT(typ, alg, userInput,
                iss, sub, aud, iat, ttlMillis);

        log.info("JWT: {}", jwtAndKey.getValue0());
        log.info("Secret Key: {}", jwtAndKey.getValue1());

    }
}
