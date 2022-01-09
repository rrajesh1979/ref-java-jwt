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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
                                                 String iss, String sub, String aud, long iat, long exp) {

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
        payload.put("iat", Objects.requireNonNullElse(iat, System.nanoTime()));
        payload.put("exp", Objects.requireNonNullElse(System.nanoTime() + exp, System.nanoTime() + 1000000000));


        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws = Jwts.builder()
                .setHeader(header)
                .setPayload(payload.toString())
                .signWith(key)
                .compact();

        return new Pair<>(jws, Encoders.BASE64.encode(key.getEncoded()));
    }

    public static void main(String[] args) {
        String userInput = "{\"name\": \"Joe\", \"picture\": \"https://example.com/image.png\"}";

        Pair<String, String> jwtAndKey = createJWT("JWT", "HS256", userInput, null, null, null, 0, 1000000000);

        System.out.println("JWT :" + jwtAndKey.getValue0());
        System.out.println("Secret Key :" + jwtAndKey.getValue1());
    }

}
