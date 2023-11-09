package com.example.jamo8_10plugin.index.analysis;

import com.example.jamo8_10plugin.index.analysis.parser.JamoParserType;
import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class ChosungFilterFactory extends AbstractTokenFilterFactory {

    private JamoParserType parserType;

    //    public ChosungFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
//        super(indexSettings, name, settings);
    public ChosungFilterFactory(IndexSettings indexSettings, Environment environment, String name,
            Settings settings) {
        super(name, settings);
        this.parserType = JamoParserType.getParserTypeByString(JamoParserType.CHOSUNG.name());
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new JamoTokenFilter(tokenStream, parserType);
    }
}
