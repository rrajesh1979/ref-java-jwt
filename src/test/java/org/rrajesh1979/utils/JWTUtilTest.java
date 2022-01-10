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

import org.javatuples.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilTest {

    @Test
    @DisplayName("Test JWT payload generation")
    void encodeDecodeJWTTest() {
        String userInput = "{\"name\": \"Joe\", \"picture\": \"https://example.com/image.png\"}";

        Pair<String, String> jwtAndKey = JWTUtil.createJWT("JWT", "HS512", userInput,
                "rrajesh1979", "JWT Encoder", "Hello JWT", false, 0);

        String jwt = jwtAndKey.getValue0();
        String key = jwtAndKey.getValue1();

        Pair<String, String> decodedJwtAndKey = JWTUtil.decodeJWT(jwt, key);
        assertEquals(decodedJwtAndKey.getValue0(), "{typ=JWT, alg=HS512}");
        assertEquals(decodedJwtAndKey.getValue1(), "{sub=JWT Encoder, aud=Hello JWT, name=Joe, iss=rrajesh1979, picture=https://example.com/image.png}");
    }

    @Test
    @DisplayName("Test JWT payload generation with dynamic ttl")
    void encodeDecodeJWTTtlTest() {
        String userInput = "{\"name\": \"Joe\", \"picture\": \"https://example.com/image.png\"}";

        Pair<String, String> jwtAndKey = JWTUtil.createJWT("JWT", "HS512", userInput,
                "rrajesh1979", "JWT Encoder", "Hello JWT", true, 100);

        String jwt = jwtAndKey.getValue0();
        String key = jwtAndKey.getValue1();

        Pair<String, String> decodedJwtAndKey = JWTUtil.decodeJWT(jwt, key);
        assertEquals(decodedJwtAndKey.getValue0(), "{typ=JWT, alg=HS512}");
        assertNotEquals(decodedJwtAndKey.getValue1(), "{sub=JWT Encoder, aud=Hello JWT, name=Joe, iss=rrajesh1979, picture=https://example.com/image.png}");
    }


    @Test
    @DisplayName("Test JWT decode with valid key")
    void encodeDecodeJWTEmptyPayloadTest() {
        String userInput = "{}";

        Pair<String, String> jwtAndKey = JWTUtil.createJWT("JWT", "HS512", userInput,
                "rrajesh1979", "JWT Encoder", "Hello JWT", false, 0);

        String jwt = jwtAndKey.getValue0();
        String key = jwtAndKey.getValue1();

        Pair<String, String> decodedJwtAndKey = JWTUtil.decodeJWT(jwt, key);
        assertEquals(decodedJwtAndKey.getValue0(), "{typ=JWT, alg=HS512}");
        assertEquals(decodedJwtAndKey.getValue1(), "{sub=JWT Encoder, aud=Hello JWT, iss=rrajesh1979}");
    }

    @Test
    @DisplayName("Test JWT decode with invalid key")
    void encodeDecodeJWTInvalidKeyTest() {
        String userInput = "{}";

        Pair<String, String> jwtAndKey = JWTUtil.createJWT("JWT", "HS512", userInput,
                "rrajesh1979", "JWT Encoder", "Hello JWT", true, 0);

        String jwt = jwtAndKey.getValue0();
        String key = jwtAndKey.getValue1();

        Pair<String, String> decodedJwtAndKey = JWTUtil.decodeJWT(jwt, key);
        assertEquals(decodedJwtAndKey.getValue0(), "{typ=JWT, alg=HS512}");
        assertNotEquals(decodedJwtAndKey.getValue1(), "{sub=JWT Encoder, aud=Hello JWT, iss=rrajesh1979}");
    }
}