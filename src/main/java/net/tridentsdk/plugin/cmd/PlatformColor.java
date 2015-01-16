/*
 * Trident - A Multithreaded Server Alternative
 * Copyright 2014 The TridentSDK Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.tridentsdk.plugin.cmd;

public final class PlatformColor {
    private static final String EMPTY = "";
    private static final String ESC = String.valueOf((char) 0x1B);

    private PlatformColor() {
    }

    public static String getColor(String color) {
        if (isWindows())
            return EMPTY;

        switch (color.toLowerCase()) {
            case "reset":
                return "\u001B[0m";
            case "black":
                return "\u001B[30m";
            case "red":
                return "\u001B[31m";
            case "green":
                return "\u001B[32m";
            case "yellow":
                return "\u001B[33m";
            case "blue":
                return "\u001B[34m";
            case "purple":
                return "\u001B[35m";
            case "cyan":
                return "\u001B[36m";
            case "white":
                return "\u001B[37m";
            case "cursoreol2":
                return ESC + "[2C";
        }

        return EMPTY;
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name");
        return os.toLowerCase().contains("windows");
    }
}
