package com.example.jamo8_10plugin.index.analysis.parser;

public class ChosungParser extends AbstractJamoParser {
    @Override
    protected void processWhenKorean(StringBuilder meaningfulChars, char chosung, char jungsung, char jongsung) {
        meaningfulChars.append(chosung);
    }

    @Override
    protected void processWhenNotKorean(StringBuilder meaningfulChars, char eachToken) {
        meaningfulChars.append(eachToken);
    }
}