/*
 *  Copyright (c) 2022 Rajesh Rajagopalan
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.rrajesh1979.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.javatuples.Pair;
import org.json.JSONObject;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JWTUtil {
    public static Pair<String, String> createJWT(String typ, String alg, String userInput,
                                                 String iss, String sub, String aud, boolean iat, long exp) {

        /* Construct JWT Header */
        Map<String, Object> header = new HashMap<>();
        header.put("typ", Objects.requireNonNullElse(typ, "JWT"));
        header.put("alg", Objects.requireNonNullElse(alg, "HS256"));

        /* Construct JWT Payload */
        JSONObject payload = new JSONObject(userInput);
        if (iss != null) {
            payload.put("iss", iss);
        }
        if (sub != null) {
            payload.put("sub", sub);
        }
        if (aud != null) {
            payload.put("aud", aud);
        }

        if (iat) {
            payload.put("iat", System.nanoTime());
        }

        if (exp != 0) {
            payload.put("exp", System.nanoTime() + exp);
        }

        Key key = signingKey(alg);

        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeader(header)
                .setPayload(payload.toString())
                .signWith(key);

        String jws = jwtBuilder.compact();

        return new Pair<>(jws, Encoders.BASE64.encode(key.getEncoded()));
    }

    private static Key signingKey(String algorithm) {
        switch (algorithm) {
            case "HS256":
                return Keys.secretKeyFor(SignatureAlgorithm.HS256);
            case "HS384":
                return Keys.secretKeyFor(SignatureAlgorithm.HS384);
            case "HS512":
                return Keys.secretKeyFor(SignatureAlgorithm.HS512);
            case "RS256":
                return Keys.secretKeyFor(SignatureAlgorithm.RS256);
            case "RS384":
                return Keys.secretKeyFor(SignatureAlgorithm.RS384);
            case "RS512":
                return Keys.secretKeyFor(SignatureAlgorithm.RS512);
            case "ES256":
                return Keys.secretKeyFor(SignatureAlgorithm.ES256);
            case "ES384":
                return Keys.secretKeyFor(SignatureAlgorithm.ES384);
            case "ES512":
                return Keys.secretKeyFor(SignatureAlgorithm.ES512);
            case "PS256":
                return Keys.secretKeyFor(SignatureAlgorithm.PS256);
            case "PS384":
                return Keys.secretKeyFor(SignatureAlgorithm.PS384);
            case "PS512":
                return Keys.secretKeyFor(SignatureAlgorithm.PS512);
            default:
                throw new IllegalArgumentException("Unsupported algorithm: " + algorithm);
        }
    }

    public static Pair<String, String> decodeJWT(String jws, String key) {
        Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws);
        String header = claims.getHeader().toString();
        String payload = claims.getBody().toString();
        return new Pair<>(header, payload);
    }

    public static void main(String[] args) {
        String userInput = "{\"name\": \"Joe\", \"picture\": \"https://example.com/image.png\"}";

        Pair<String, String> jwtAndKey = createJWT("JWT", "HS512", userInput,
                "rrajesh1979", "JWT Encoder", "Hello JWT", false, 0);

        System.out.println("JWT :" + jwtAndKey.getValue0());
        System.out.println("Secret Key :" + jwtAndKey.getValue1());

        Pair<String, String> decodedJwtAndKey = decodeJWT(jwtAndKey.getValue0(), jwtAndKey.getValue1());
        System.out.println("Decoded JWT Header:" + decodedJwtAndKey.getValue0());
        System.out.println("Decoded JWT Key :" + decodedJwtAndKey.getValue1());
    }

}
