package com.example.cv.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cv.R;

import java.util.ArrayList;

public class ProjetAdapter extends BaseAdapter {

    private ArrayList<Projet> projets;
    private Context context;

    public ProjetAdapter(ArrayList<Projet> projets, Context context) {
        this.projets = projets;
        this.context = context;
    }

    @Override
    public int getCount() {
        return projets.size();
    }

    @Override
    public Object getItem(int i) {
        return projets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_project, viewGroup, false);
        }

        TextView nom = view.findViewById(R.id.textViewNomProjet);
        nom.setText(projets.get(i).getNom());

        TextView description = view.findViewById(R.id.textViewDescProjet);
        description.setText(projets.get(i).getDescription());
        return view;
    }
}
