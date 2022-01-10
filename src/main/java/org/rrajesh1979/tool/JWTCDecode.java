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

import org.javatuples.Pair;
import org.rrajesh1979.utils.JWTUtil;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "decode", description = "Decode JWT token")
@Slf4j
public class JWTCDecode implements Runnable {
    @Option(names = { "-j", "--jwt" }, description = "JWT String to be decoded.", required = true)
    String jwt;

    @Option(names = { "-k", "--key" }, description = "Key to be used for decoding.", required = true)
    String key;

    @Override
    public void run() {
        log.info("Starting JWTCDecode");

        Pair<String, String> decodedJwtAndKey = JWTUtil.decodeJWT(jwt, key);
        log.info("Decoded JWT Header: {}", decodedJwtAndKey.getValue0());
        log.info("Decoded JWT Payload: {}", decodedJwtAndKey.getValue1());
    }
}
