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

package org.rrajesh1979.tool;

import io.jsonwebtoken.io.Encoders;
import org.javatuples.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.rrajesh1979.utils.JWTUtil;
import picocli.CommandLine;

import java.security.Key;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class JWTCTest {

    @Test
    @DisplayName("Test JWTC Main - encode")
    void mainEncodeTest() {
        String[] args = {"encode"};
        CommandLine jwtcCommandLine = new CommandLine(new JWTC());
        int exitCode = jwtcCommandLine
                .setColorScheme(JWTC.getColorScheme())
                .execute(args);
        assertEquals(0, exitCode);
    }


    @Test
    @DisplayName("Test JWTC Main - decode")
    void mainDecodeTest() {
        String userInput = "{}";

        Pair<String, String> jwtAndKey = JWTUtil.createJWT("JWT", "HS512", userInput,
                "rrajesh1979", "JWT Encoder", "Hello JWT", false, 0);

        String jwt = jwtAndKey.getValue0();
        String key = jwtAndKey.getValue1();

        String[] args = {
                "decode",
                "-j=" + jwt + " ",
                "-k=\""+ key + "\""
        };
        System.out.println(String.join(" ", args));
        CommandLine jwtcCommandLine = new CommandLine(new JWTC());
        int exitCode = jwtcCommandLine
                .setColorScheme(JWTC.getColorScheme())
                .execute(args);
        assertEquals(0, exitCode);
    }
}