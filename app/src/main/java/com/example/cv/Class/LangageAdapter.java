package com.example.cv.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cv.R;

import java.util.ArrayList;

public class LangageAdapter extends BaseAdapter {

    private ArrayList<Langage> langages;
    private Context context;

    public LangageAdapter(ArrayList<Langage> langages, Context context) {
        this.langages = langages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return langages.size();
    }

    @Override
    public Object getItem(int i) {
        return langages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_language, viewGroup, false);
        }

        TextView lang = view.findViewById(R.id.textViewLang);
        lang.setText(langages.get(i).getNom());

        ProgressBar progress = view.findViewById(R.id.progressBar);
        progress.setProgress(langages.get(i).getProgress());
        return view;
    }
}
