package com.example.jamo8_10plugin.index.analysis.parser;

import java.util.HashMap;
import java.util.Map;

public enum JamoParserType {
    JAMO {
        @Override
        public IJamoParser getParser() {
            return new JamoParser();
        }
    },
    CHOSUNG {
        @Override
        public IJamoParser getParser() {
            return new ChosungParser();
        }
    };

    private static Map<String, JamoParserType> stringToEumMap = new HashMap<>(JamoParserType.values().length);

    static {
        for (JamoParserType type : JamoParserType.values()) {
            stringToEumMap.put(type.toString(), type);
        }
    }

    public static JamoParserType getParserTypeByString(String parserType) {
        if (stringToEumMap.containsKey(parserType)) {
            return stringToEumMap.get(parserType);
        }

        throw new IllegalArgumentException("parserType(" +parserType+") is not found");
    }

    public abstract IJamoParser getParser();
}
