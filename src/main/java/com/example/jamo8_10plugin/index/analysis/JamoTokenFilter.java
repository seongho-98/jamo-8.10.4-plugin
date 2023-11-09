package com.example.jamo8_10plugin.index.analysis;

import com.example.jamo8_10plugin.index.analysis.parser.IJamoParser;
import com.example.jamo8_10plugin.index.analysis.parser.JamoParserType;
import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class JamoTokenFilter extends TokenFilter {

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    IJamoParser parser;

    public JamoTokenFilter(TokenStream input, JamoParserType parserType) {
        super(input);
        this.parser = parserType.getParser();
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            CharSequence parserdData = this.parser.parse(termAtt.toString());
            termAtt.setEmpty().append(parserdData);
            return true;
        } else {
            return false;
        }
    }
}
