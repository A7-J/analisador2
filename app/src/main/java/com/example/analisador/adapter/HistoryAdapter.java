package com.example.analisador.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.analisador.R;
import com.example.analisador.model.AnalysisResult;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<AnalysisResult> list;

    public HistoryAdapter(List<AnalysisResult> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_analysis_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AnalysisResult item = list.get(position);
        holder.txtHash.setText("Hash: " + item.passwordHash);
        holder.txtStrength.setText("Força: " + item.strength);
        holder.txtTimestamp.setText("Data: " + item.timestamp);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtHash, txtStrength, txtTimestamp;
        public ViewHolder(View itemView) {
            super(itemView);
            txtHash = itemView.findViewById(R.id.txtHash);
            txtStrength = itemView.findViewById(R.id.txtStrength);
            txtTimestamp = itemView.findViewById(R.id.txtTimestamp);
        }
    }
}
