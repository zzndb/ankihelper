package com.mmjang.ankihelper.util.apis;

import com.mmjang.ankihelper.util.HttpPost;

import java.util.HashMap;
import java.util.Map;

public class MSTransApi {
    private static final String TRANS_API_HOST = "https://api.cognitive.microsofttranslator.com/translate";
    private static final String API_VERSION = "3.0";

    private String apiKey;
    private String apiRegion;

    public MSTransApi(String apiKey, String apiRegion) {
        this.apiKey = apiKey;
        this.apiRegion = apiRegion;
    }

    public String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        return HttpPost.post(TRANS_API_HOST, params, query, this.apiKey, this.apiRegion);
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("from", from);
        params.put("to", to);

        params.put("api-version", API_VERSION);

        return params;
    }

}
