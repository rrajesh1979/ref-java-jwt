package org.rrajesh1979.tool;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@CommandLine.Command(name = "encode")
@Slf4j
public class JWTCEncode implements Runnable {
    @Override
    public void run() {
        log.info("Hello from JWTCEncode");
        // We need a signing key, so we'll create one just for this example. Usually
        // the key would be read from your application configuration instead.
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws = Jwts.builder()
                // .setSubject("Joe")
                .setPayload("{\"name\": \"Joe\", \"picture\": \"https://example.com/image.png\"}")
                .signWith(key)
                .compact();

        System.out.println(jws);

        assert Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().getSubject().equals("Joe");

        System.out.println(Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws));

    }
}
