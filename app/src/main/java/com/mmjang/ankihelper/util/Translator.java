package com.mmjang.ankihelper.util;

import android.widget.Toast;

import com.mmjang.ankihelper.MyApplication;
import com.mmjang.ankihelper.data.Settings;
import com.mmjang.ankihelper.util.apis.MSTransApi;

import org.json.JSONArray;
import org.json.JSONException;

public class Translator {
    private static MSTransApi api;

    public static String translate(String query, String from, String to) throws Exception {
        if (api == null) {
            Settings settings = Settings.getInstance(MyApplication.getContext());
            if (!settings.getUserMstranslateKey().isEmpty()) {
                String apiKey = settings.getUserMstranslateKey();
                String apiRegion = settings.getUserMstranslateRegion();
                api = new MSTransApi(apiKey, apiRegion);
            } else {
                throw new Exception("API not found!");
            }
        }
        String jsonStr = "";
        try {
            jsonStr = api.getTransResult(query, from, to);
            JSONArray jsonArray = new JSONArray(jsonStr);
            JSONArray resultArray = jsonArray.getJSONObject(0).getJSONArray("translations");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < resultArray.length(); i++) {
                sb.append(resultArray.getJSONObject(i).getString("text"));
                sb.append("\n");
            }
            return sb.toString();
        } catch (JSONException e) {
            return "error\n" + e.getMessage() + "\n" + jsonStr;
        }
    }
    public static void main(String[] args) {
//        System.out.println(Translator.translate("i am a big fat guy", null, "zh-Hans"));
    }
}
