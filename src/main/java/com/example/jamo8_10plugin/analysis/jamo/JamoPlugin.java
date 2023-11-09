package com.example.jamo8_10plugin.analysis.jamo;

import java.util.HashMap;
import java.util.Map;

import com.example.jamo8_10plugin.index.analysis.ChosungFilterFactory;
import com.example.jamo8_10plugin.index.analysis.JamoTokenFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

public class JamoPlugin  extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
        extra.put("jamo", JamoTokenFilterFactory::new);
        extra.put("chosung", ChosungFilterFactory::new);
        return extra;
    }
}