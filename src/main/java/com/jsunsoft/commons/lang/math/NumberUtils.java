package com.jsunsoft.commons.lang.math;

/*
 * Copyright 2017 Benik Arakelyan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.function.Function;

public class NumberUtils {
    private static final Function<String, Long> STRING_LONG_FUNCTION = Long::valueOf;
    private static final Function<String, Integer> STRING_INTEGER_FUNCTION = Integer::valueOf;

    private NumberUtils() {
    }

    /**
     * @param value string value to check
     * @return <code>true</code> when value is long.
     */
    public static boolean isLong(String value) {
        return check(value, STRING_LONG_FUNCTION);
    }

    /**
     * @param value string value to check
     * @return <code>true</code> when value is <code>null</code> or isn't long.
     */
    public static boolean isNotLong(String value) {
        return !isLong(value);
    }

    /**
     * @param value string value to check
     * @return <code>true</code> when value is integer.
     */
    public static boolean isInteger(String value) {
        return check(value, STRING_INTEGER_FUNCTION);
    }

    /**
     * @param value string value to check
     * @return <code>true</code> when value is <code>null</code> or isn't integer.
     */
    public static boolean isNotInteger(String value) {
        return !isInteger(value);
    }

    /**
     * @param value string value to parse
     * @return The Long value or <code>null</code> If can't parse value to long or value is null.
     */
    public static Long toLong(String value) {
        return toNumber(value, STRING_LONG_FUNCTION);
    }

    /**
     * @param value string value to parse
     * @return The Integer value or <code>null</code> If can't parse value to Integer or value is null.
     */
    public static Integer toInteger(String value) {
        return toNumber(value, STRING_INTEGER_FUNCTION);
    }

    private static <T extends Number> T toNumber(String value, Function<String, T> function) {
        T result;

        if (value == null) {
            result = null;
        } else {
            try {
                result = function.apply(value);
            } catch (NumberFormatException ignored) {
                result = null;
            }
        }
        return result;
    }

    private static boolean check(String value, Function<String, ? extends Number> function) {
        return toNumber(value, function) != null;
    }
}
