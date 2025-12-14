package com.example.analisador.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.analisador.model.AnalysisResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static final String PREFS_NAME = "history_prefs";
    private static final String KEY_HISTORY = "analysis_history";

    private SharedPreferences prefs;
    private Gson gson;

    public HistoryManager(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveAnalysis(AnalysisResult result) {
        List<AnalysisResult> list = getHistory();
        list.add(0, result);
        prefs.edit().putString(KEY_HISTORY, gson.toJson(list)).apply();
    }

    public List<AnalysisResult> getHistory() {
        String json = prefs.getString(KEY_HISTORY, null);
        if (json == null) return new ArrayList<>();
        Type type = new TypeToken<List<AnalysisResult>>() {}.getType();
        return gson.fromJson(json, type);
    }
}
