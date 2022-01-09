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

public class JWTUtil {
    public static Pair<String, String> createJWT(Map<String, Object> header, JSONObject payload) {
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

        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        Map<String, Object> payload = new HashMap<>();

        JSONObject userInputJson = new JSONObject(userInput);

        //Standard JWT claims
        userInputJson.put("iss", "https://example.com");
        userInputJson.put("sub", "1234567890");
        userInputJson.put("aud", "https://example.com");
        userInputJson.put("iat", System.nanoTime());
        userInputJson.put("exp", System.nanoTime() + 1000000000);

        Pair<String, String> jwtAndKey = createJWT(header, userInputJson);

        System.out.println("JWT :" + jwtAndKey.getValue0());
        System.out.println("Secret Key :" + jwtAndKey.getValue1());
    }

}
