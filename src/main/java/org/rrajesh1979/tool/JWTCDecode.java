package org.rrajesh1979.tool;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@CommandLine.Command(name = "decode")
@Slf4j
public class JWTCDecode implements Runnable {
    @Override
    public void run() {
        log.info("Hello from JWTCDecode");
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jws = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.6oB3jv-aya7s3Mb-AOT65V8F_-m7BhPaV3oRal09bOQ";
        System.out.println(Jwts.parserBuilder().setSigningKey(key).build().parse(jws));

    }
}
