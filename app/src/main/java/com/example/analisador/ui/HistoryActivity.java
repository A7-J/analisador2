package com.example.analisador.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.analisador.adapter.HistoryAdapter;
import com.example.analisador.helper.HistoryManager;
import com.example.analisador.model.AnalysisResult;
import com.example.analisador.R;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HistoryManager historyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recyclerViewHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        historyManager = new HistoryManager(this);
        List<AnalysisResult> list = historyManager.getHistory();

        HistoryAdapter adapter = new HistoryAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
