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

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import com.sun.source.tree.Tree;
import lombok.extern.slf4j.Slf4j;
import org.javatuples.Pair;
import org.json.JSONObject;

import io.jsonwebtoken.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Slf4j
public class JWTUtil {
    private static Map<String, Object> algMap;
    static {
        algMap = new HashMap<>();
        algMap.put("HS256", SignatureAlgorithm.HS256);
        algMap.put("HS384", SignatureAlgorithm.HS384);
        algMap.put("HS512", SignatureAlgorithm.HS512);
        algMap.put("RS256", SignatureAlgorithm.RS256);
        algMap.put("RS384", SignatureAlgorithm.RS384);
        algMap.put("RS512", SignatureAlgorithm.RS512);
        algMap.put("ES256", SignatureAlgorithm.ES256);
        algMap.put("ES384", SignatureAlgorithm.ES384);
        algMap.put("ES512", SignatureAlgorithm.ES512);
        algMap.put("PS256", SignatureAlgorithm.PS256);
        algMap.put("PS384", SignatureAlgorithm.PS384);
        algMap.put("PS512", SignatureAlgorithm.PS512);
        algMap.put("", SignatureAlgorithm.HS256);
    }

    public static Pair<String, String> createJWT(String typ, String alg, String userInput,
                                                 String iss, String sub, String aud, boolean iat, long exp) {

        /* Construct JWT Header */
        Map<String, Object> header = new TreeMap<>();
        header.put("alg", Objects.requireNonNullElse(alg, "HS256"));
        header.put("typ", Objects.requireNonNullElse(typ, "JWT"));
        log.debug(header.toString());

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
            // Converting milliseconds to nanoseconds
            payload.put("exp", System.nanoTime() + exp * 1000 * 1000);
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
        SignatureAlgorithm signatureAlgorithm = (SignatureAlgorithm) algMap.get(algorithm);
        return Keys.secretKeyFor(signatureAlgorithm);
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

        log.info("JWT :{}", jwtAndKey.getValue0());
        log.info("Secret Key :{}", jwtAndKey.getValue1());

        Pair<String, String> decodedJwtAndKey = decodeJWT(jwtAndKey.getValue0(), jwtAndKey.getValue1());
        log.info("Decoded JWT Header :{}", decodedJwtAndKey.getValue0());
        log.info("Decoded JWT Key :{}", decodedJwtAndKey.getValue1());
    }

}
