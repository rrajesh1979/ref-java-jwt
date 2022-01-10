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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

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


    //FIXME
//    @Test
//    @DisplayName("Test JWTC Main - decode")
//    void mainDecodeTest() {
//        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKV1QgRW5jb2RlciIsImF1ZCI6IkhlbGxvIEpXVCIsIm5hbWUiOiJKb2UiLCJpc3MiOiJycmFqZXNoMTk3OSIsInBpY3R1cmUiOiJodHRwczovL2V4YW1wbGUuY29tL2ltYWdlLnBuZyJ9.l1j1JyW3nvWJ90De8taOe1tZ80sHHHDMaibYEPv78LfA3Bw-uGgCECy5MwkE6nY3hP7isup433X5VqS2xP22fw";
//        String key = "mOYKXJKdhBYQFWNr9cHHsgGvHseKRR9Rw7E379oeUuzfG18MmlcO3c8i7tBMMufziy6xMoZZAiO7bNKxZl7Rfw==";
//
//        String[] args = {
//                "decode",
//                "-j=\"" + jwt + "\"",
//                "-k=\""+ key + "\""
//        };
//        System.out.println(String.join(" ", args));
//        CommandLine jwtcCommandLine = new CommandLine(new JWTC());
//        int exitCode = jwtcCommandLine
//                .setColorScheme(JWTC.getColorScheme())
//                .execute(args);
//        assertEquals(0, exitCode);
//    }
}