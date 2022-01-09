package org.rrajesh1979.demo;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTC {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // We need a signing key, so we'll create one just for this example. Usually
        // the key would be read from your application configuration instead.
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws =
                Jwts.builder()
                        .setSubject("Joe")
                        .signWith(key)
                        .compact();

        System.out.println(jws);
    }
}
