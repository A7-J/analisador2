package com.example.analisador.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.analisador.helper.HashUtils;
import com.example.analisador.helper.HistoryManager;
import com.example.analisador.model.AnalysisResult;
import com.example.analisador.service.BreachService;
import com.example.analisador.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText editPassword;
    Button btnAnalyze, btnHistory;
    HistoryManager historyManager;
    BreachService breachService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPassword = findViewById(R.id.editPassword);
        btnAnalyze = findViewById(R.id.btnAnalyze);
        btnHistory = findViewById(R.id.btnHistory);
        historyManager = new HistoryManager(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.password-checker.com/") // placeholder
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        breachService = retrofit.create(BreachService.class);

        btnAnalyze.setOnClickListener(v -> analyzePassword());
        btnHistory.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HistoryActivity.class)));
    }

    private void analyzePassword() {
        String password = editPassword.getText().toString();
        if (password.isEmpty()) {
            Toast.makeText(this, "Digite uma senha!", Toast.LENGTH_SHORT).show();
            return;
        }

        String hash = HashUtils.sha256(password);

        // Simulação simples de força
        int score = 0;
        if (password.length() >= 8) score += 1;
        if (password.matches(".*[A-Z].*")) score += 1;
        if (password.matches(".*[0-9].*")) score += 1;
        if (password.matches(".*[!@#$%^&*()].*")) score += 1;

        String strength;
        switch (score) {
            case 0: case 1: strength = "Fraca"; break;
            case 2: strength = "Média"; break;
            case 3: strength = "Forte"; break;
            default: strength = "Muito Forte";
        }

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

        AnalysisResult result = new AnalysisResult(hash, strength, score, timestamp);
        historyManager.saveAnalysis(result);

        Toast.makeText(this, "Senha analisada! Hash: " + hash, Toast.LENGTH_LONG).show();
    }
}
